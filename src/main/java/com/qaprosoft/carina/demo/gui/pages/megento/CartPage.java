package com.qaprosoft.carina.demo.gui.pages.megento;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;

public class CartPage extends AbstractMagentoPage {

    @FindBy(xpath = "(//dl[contains(@class,'item-options')])//dd[1]")
    private ExtendedWebElement sizeItem;

    @FindBy(xpath = "(//dl[contains(@class,'item-options')])//dd[2]")
    private ExtendedWebElement colorItem;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getSize() {
        return sizeItem.getText();
    }

    public String getColor() {
        return colorItem.getText();
    }

}