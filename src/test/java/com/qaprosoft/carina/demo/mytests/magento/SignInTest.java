package com.qaprosoft.carina.demo.mytests.magento;

import com.qaprosoft.carina.demo.gui.services.magento.UserService;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qaprosoft.carina.demo.gui.pages.megento.HomePage;
import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.gui.pages.megento.SignInPage;

public class SignInTest implements IAbstractTest {

    @Test(testName = "regression#1")
    public void testExistingUser() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened());
        SignInPage signInPage = homePage.getHeaderMenu().clickSignInButton();
        signInPage.signIn(UserService.getDefaultUser());
        Assert.assertTrue(homePage.isPageOpened());
    }
}
