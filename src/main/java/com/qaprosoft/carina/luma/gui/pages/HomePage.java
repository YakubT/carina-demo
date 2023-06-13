package com.qaprosoft.carina.luma.gui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.luma.gui.components.SearchBox;

public class HomePage extends AbstractPage {

    @FindBy(linkText = "Sign In")
    private ExtendedWebElement loginButton;

    @FindBy(xpath = "//input[@id='search']//..")
    private SearchBox searchBox;

    public HomePage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://magento.softwaretestingboard.com/");
    }

    public LoginPage loginButtonClick() {
        loginButton.click();
        return new LoginPage(getDriver());
    }

    public SearchBox getSearchBox() {
        return searchBox;
    }
}
