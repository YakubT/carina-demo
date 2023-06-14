package com.qaprosoft.carina.luma.gui.pages;

import java.util.List;

import com.qaprosoft.carina.luma.gui.components.MiniCart;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;

public class GoodPage extends AbstractPage {

    @FindBy(xpath = "//div[contains(@class,'size')]//div[contains(@class,'swatch-option')]")
    private List<ExtendedWebElement> sizeButtons;

    @FindBy(xpath = "//div[contains(@class,'swatch-option color')]")
    private List<ExtendedWebElement> colorsButtons;

    @FindBy(id = "product-addtocart-button")
    private ExtendedWebElement addToCartButton;

    @FindBy(xpath = "//div[contains(@class,'block-minicart')]")
    private MiniCart miniCart;

    @FindBy(xpath = "//span[@class='price']")
    private ExtendedWebElement priceTitle;

    public GoodPage(WebDriver driver) {
        super(driver);
    }

    public void chooseSize(String size) {
       ExtendedWebElement sizeButton =sizeButtons.stream().filter(el->el.getText().equals(size)).findFirst().
               orElseThrow();
       sizeButton.click();
    }

    public void chooseFirstColorFromList(){
        colorsButtons.get(0).click();
    }

    public void addToCart() {
        addToCartButton.click();
    }

    public double getPrice() {
        return Double.parseDouble(priceTitle.getText().substring(1));
    }
}
