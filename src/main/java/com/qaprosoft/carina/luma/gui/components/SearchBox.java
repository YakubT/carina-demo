package com.qaprosoft.carina.luma.gui.components;

import com.qaprosoft.carina.luma.gui.pages.SearchPage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;

public class SearchBox extends AbstractUIObject {

    @FindBy(id = "search")
    private ExtendedWebElement searchInputField;

    @FindBy(xpath = "//button[contains(@class, 'search')]")
    private ExtendedWebElement searchButton;

    public SearchBox(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public SearchPage search(String text) {
        searchInputField.type(text);
        searchButton.click();
        return new SearchPage(getDriver());
    }
}
