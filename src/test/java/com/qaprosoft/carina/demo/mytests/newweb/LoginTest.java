package com.qaprosoft.carina.demo.mytests.newweb;

import com.qaprosoft.carina.demo.gui.models.User;
import com.qaprosoft.carina.demo.gui.services.UserService;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.gui.components.LoginForm;
import com.qaprosoft.carina.demo.gui.enums.HeaderIconLink;
import com.qaprosoft.carina.demo.gui.pages.HomePage;
import com.qaprosoft.carina.demo.gui.pages.LoginPage;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;

public class LoginTest implements IAbstractTest {

    @Test(description = "Login scenarios", dataProvider = "login scenarios")
    @MethodOwner(owner = "YakubT")
    public void testLoginResult(User user, String message) {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        homePage.getHeaderMenu().clickHeaderMenuIcon(HeaderIconLink.LOG_IN);
        LoginForm loginForm = homePage.getLoginForm();
        LoginPage loginPage = loginForm.login(user);
        if (!message.equals("")) {
            Assert.assertTrue(loginPage.isMessagePresent(message), "Unexpected log in result");
        } else {
            pause(1);
            Assert.assertTrue(homePage.isPageOpened(), "Not logged in");
        }
    }

    @DataProvider(parallel = true, name = "login scenarios")
    public Object[][] dataProviderLogin() {
        return new Object[][]{
                {new UserService().getUser(), ""},
                {new UserService().getUserWithInvalidEmail(), "Reason: User record not found."},
                {new UserService().getUserWithInvalidPassword(), "Reason: Wrong password."}
        };
    }
}
