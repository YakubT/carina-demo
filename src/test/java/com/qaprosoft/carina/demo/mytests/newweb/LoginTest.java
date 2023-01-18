package com.qaprosoft.carina.demo.mytests.newweb;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.gui.components.LoginForm;
import com.qaprosoft.carina.demo.gui.enums.HeaderIconLink;
import com.qaprosoft.carina.demo.gui.pages.HomePage;
import com.qaprosoft.carina.demo.gui.pages.LoginPage;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.utils.R;

public class LoginTest implements IAbstractTest {

    @Test(description = "Login scenarios", dataProvider = "login scenarios")
    @MethodOwner(owner = "YakubT")
    public void testLoginResult(String email, String password, String message) {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        homePage.getHeaderMenu().clickHeaderMenuIcon(HeaderIconLink.LOG_IN);
        LoginForm loginForm = homePage.getLoginForm();
        LoginPage loginPage = loginForm.login(email, password);
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
                {R.TESTDATA.get("email"), R.TESTDATA.getDecrypted("pass"), ""},
                {"WrongUserEmail@gmail.com", R.TESTDATA.getDecrypted("pass"), "Reason: User record not found."},
                {R.TESTDATA.get("email"), "WrongPassword123456", "Reason: Wrong password."}
        };
    }
}
