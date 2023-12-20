package com.qaprosoft.carina.magento.components.common;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.magento.pages.common.CatalogSearchPageBase;
import com.qaprosoft.carina.magento.pages.common.SignInPageBase;
import com.qaprosoft.carina.magento.pages.common.SignUpPageBase;
import com.qaprosoft.carina.magento.pages.desktop.CartPage;

public abstract class HeaderMenuBase extends AbstractUIObject {

    public HeaderMenuBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract SignInPageBase clickSignInButton();

    public abstract SignUpPageBase clickSignUpPage();

    public abstract void signOut();

    public abstract CatalogSearchPageBase searchGood(String name);

    public abstract void goToCheckOut();

    public abstract CartPage goToCartPage();
}
