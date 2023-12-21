package com.qaprosoft.carina.magento.components.android;

import com.qaprosoft.carina.magento.pages.common.SignUpPageBase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.magento.components.common.HeaderMenuBase;
import com.qaprosoft.carina.magento.pages.common.CatalogSearchPageBase;
import com.qaprosoft.carina.magento.pages.desktop.CartPage;
import com.qaprosoft.carina.magento.pages.mobile.SignInPage;
import com.qaprosoft.carina.magento.pages.mobile.SignUpPage;

public class HeaderMenu extends HeaderMenuBase {

    @FindBy(xpath = "//a[contains(@class,'showcart')]")
    private ExtendedWebElement cartIcon;

    @FindBy(xpath = "//label[contains(@for,'search')]")
    private ExtendedWebElement magnifyingGlassIcon;

    @FindBy(id = "search")
    private ExtendedWebElement searchInputField;

    @FindBy(xpath = "//span[contains(@class,'nav')]")
    private ExtendedWebElement hamburgerMenu;

    @FindBy(xpath = "//a[contains(text(),'Account') and contains(@class,'nav-sections-item-switch')]")
    private ExtendedWebElement accountBtn;

    @FindBy(xpath = "//div[contains(@class,'section-items nav-sections-items')]//a[contains(text(),'Sign In')]")
    private ExtendedWebElement signInBtn;

    @FindBy(xpath = "//div[@id='store.links']//div//a[contains(text(),'Sign Out')]")
    private ExtendedWebElement signOutBtn;

    public HeaderMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public SignInPage clickSignInButton() {
        hamburgerMenu.click();
        accountBtn.click();
        signInBtn.click();
        return new SignInPage(getDriver());
    }

    @Override
    public SignUpPageBase clickSignUpPage() {
        return new SignUpPage(getDriver());
    }

    @Override
    public void signOut() {
        hamburgerMenu.click();
        accountBtn.click();
        signOutBtn.click();
    }

    @Override
    public CatalogSearchPageBase searchGood(String name) {
        magnifyingGlassIcon.click();
        searchInputField.type(name+ Keys.RETURN);
        throw new UnsupportedOperationException();
    }

    @Override
    public void goToCheckOut() {
        throw new UnsupportedOperationException();
    }

    @Override
    public CartPage goToCartPage() {
        throw new UnsupportedOperationException();
    }
}
