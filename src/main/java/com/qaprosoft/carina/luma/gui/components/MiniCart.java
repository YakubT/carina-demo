package com.qaprosoft.carina.luma.gui.components;

import java.util.List;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;

public class MiniCart extends AbstractUIObject {

    @FindBy(xpath = "//span[@class='price']")
    private ExtendedWebElement totalPriceTitle;

    @FindBy(xpath = "//ol[@id='mini-cart']//div[@class='product']")
    private List<MiniCartItem> items;

    public MiniCart(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public double getTotalPrice() {
        return Double.parseDouble(totalPriceTitle.getText().substring(1));
    }

    public List<MiniCartItem> getItems() {
        return items;
    }
}
