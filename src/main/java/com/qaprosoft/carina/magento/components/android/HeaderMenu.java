package com.qaprosoft.carina.magento.components.android;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.magento.components.common.HeaderMenuBase;
import com.qaprosoft.carina.magento.pages.common.CatalogSearchPageBase;
import com.qaprosoft.carina.magento.pages.desktop.CartPage;
import com.qaprosoft.carina.magento.pages.desktop.SignInPage;
import com.qaprosoft.carina.magento.pages.desktop.SignUpPage;

public class HeaderMenu extends HeaderMenuBase {

    @FindBy(xpath = "//a[contains(@class,'showcart')]")
    private ExtendedWebElement cartIcon;

    @FindBy(xpath = "//label[contains(@for,'search')]")
    private ExtendedWebElement magnifyingGlassIcon;

    @FindBy(id = "search")
    private ExtendedWebElement searchInputField;

    @Override
    public SignInPage clickSignInButton() {
        return null;
    }

    @Override
    public SignUpPage clickSignUpPage() {
        return null;
    }

    @Override
    public void signOut() {

    }

    @Override
    public CatalogSearchPageBase searchGood(String name) {
        magnifyingGlassIcon.click();
        searchInputField.type(name+ Keys.RETURN);

    }

    @Override
    public void goToCheckOut() {

    }

    @Override
    public CartPage goToCartPage() {
        return null;
    }
}
