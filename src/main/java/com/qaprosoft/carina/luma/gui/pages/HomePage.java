package com.qaprosoft.carina.luma.gui.pages;

import com.qaprosoft.carina.luma.gui.components.MiniCart;
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

    @FindBy(xpath = "//a[contains(@class,'action showcart')]")
    private ExtendedWebElement cartIcon;

    @FindBy(xpath = "//div[contains(@class,'block-minicart')]")
    private MiniCart miniCart;

    @FindBy(xpath = "//button[contains(@class,'action-accept')]")
    private ExtendedWebElement acceptButton;

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

    public MiniCart clickCartIcon() {
        cartIcon.click();
        return miniCart;
    }

    public void clickAcceptButton() {
        acceptButton.click();
    }
}
