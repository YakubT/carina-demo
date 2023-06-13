package com.qaprosoft.carina.demo.mytests.newweb.luma;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.luma.gui.pages.HomePage;
import com.qaprosoft.carina.luma.gui.pages.LoginPage;
import com.qaprosoft.carina.luma.gui.services.UserService;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;

public class LoginTest implements IAbstractTest {

    @Test(description = "Verify that the user is successfully logged in.")
    @MethodOwner(owner = "YakubT")
    public void testLoginSuccess() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        LoginPage loginPage = homePage.loginButtonClick();
        loginPage.login(UserService.getDefaultUser());
        Assert.assertTrue(homePage.isPageOpened(),"test failed");
    }

}
