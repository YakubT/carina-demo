package com.qaprosoft.carina.demo.mytests.magento;

import com.qaprosoft.carina.demo.gui.services.magento.UserService;
import com.qaprosoft.carina.magento.pages.common.HomePageBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qaprosoft.carina.magento.pages.desktop.HomePage;
import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.magento.pages.desktop.SignInPage;

public class SignInTest implements IAbstractTest {

    @Test(testName = "regression#1")
    public void testExistingUser() {
        HomePageBase homePage = initPage(getDriver(),HomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened());
        SignInPage signInPage = homePage.getHeaderMenu().clickSignInButton();
        signInPage.signIn(UserService.getDefaultUser());
        Assert.assertTrue(homePage.isPageOpened());
    }
}
