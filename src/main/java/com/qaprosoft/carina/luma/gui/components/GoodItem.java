package com.qaprosoft.carina.luma.gui.components;

import com.qaprosoft.carina.luma.gui.pages.GoodPage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;

public class GoodItem extends AbstractUIObject {

    @FindBy(xpath = ".//a[contains(@class,'product-item-link')]")
    private ExtendedWebElement title;

    @FindBy(xpath = "//button[contains(@title,'Add to Cart')]")
    private ExtendedWebElement addToCartButton;

    public GoodItem(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void hover() {
       title.hover();
    }

    public String getTitleText() {
        return title.getText();
    }

    public boolean verifyText(String text) {
        return title.getText().equals(text);
    }

    public GoodPage addToCart() {
        hover();
        addToCartButton.click();
        return new GoodPage(getDriver());
    }
}
