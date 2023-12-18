package com.qaprosoft.carina.magento.components.common;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.magento.pages.desktop.SignInPage;
import com.qaprosoft.carina.magento.pages.desktop.CartPage;
import com.qaprosoft.carina.magento.pages.desktop.CatalogSearchPage;
import com.qaprosoft.carina.magento.pages.desktop.SignUpPage;

public abstract class HeaderMenuBase extends AbstractUIObject {

    public HeaderMenuBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract SignInPage clickSignInButton();

    public abstract SignUpPage clickSignUpPage();

    public abstract void signOut();

    public abstract CatalogSearchPage searchGood(String name);

    public abstract void goToCheckOut();

    public abstract CartPage goToCartPage();
}
