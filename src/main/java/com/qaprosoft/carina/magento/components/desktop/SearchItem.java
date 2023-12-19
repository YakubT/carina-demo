package com.qaprosoft.carina.magento.components.desktop;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.magento.components.common.SearchItemBase;
import com.qaprosoft.carina.magento.pages.desktop.GoodPage;

public class SearchItem extends SearchItemBase {

    @FindBy(xpath = ".//span[contains(@id,'price')]")
    ExtendedWebElement price;

    @FindBy(xpath = ".//button")
    ExtendedWebElement addToCartButton;

    public SearchItem(WebDriver driver, SearchContext searchContext) {
        super(driver,searchContext);
    }

    public String getPrice() {
        return price.getText();
    }

    public void addToCart() {
        addToCartButton.click();
    }

    public GoodPage click() {
        rootElement.click();
        return new GoodPage(getDriver());
    }
}
