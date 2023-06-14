package com.qaprosoft.carina.luma.gui.components;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;

public class MiniCartItem extends AbstractUIObject {

    @FindBy(xpath = "..//input[contains(@class,'qty')]")
    private ExtendedWebElement quantity;

    @FindBy(xpath = "//a[contains(@class,'delete')]")
    private ExtendedWebElement deleteIcon;

    public MiniCartItem(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public int getQuantity() {
        return Integer.parseInt(quantity.getAttribute("data-item-qty"));
    }

    public void deleteItem() {
        deleteIcon.click();
    }
}
