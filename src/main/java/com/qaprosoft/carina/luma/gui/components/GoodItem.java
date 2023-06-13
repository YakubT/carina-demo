package com.qaprosoft.carina.luma.gui.components;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;

public class GoodItem extends AbstractUIObject {

    @FindBy(xpath = ".//a[contains(@class,'product-item-link')]")
    private ExtendedWebElement title;

    public GoodItem(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void hover() {
        Actions actions = new Actions(getDriver());
        actions.moveToElement(rootElement);
    }

    public String getTitleText() {
        return title.getText();
    }

    public boolean verifyText(String text) {
        return title.getText().equals(text);
    }
}
