package com.qaprosoft.carina.demo.mytests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.Color;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.gui.components.LoginForm;
import com.qaprosoft.carina.demo.gui.enums.HeaderIconLink;
import com.qaprosoft.carina.demo.gui.pages.HomePage;
import com.qaprosoft.carina.demo.gui.pages.LoginPage;

public class LoginTest implements IAbstractTest {

    private static final Logger LOGGER = LogManager.getLogger(LoginTest.class);

    @Test(description = "test the ability to log in")
    @MethodOwner(owner = "YakubT")
    public void testLogInAbility() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        homePage.getHeaderMenu().clickHeaderMenuIcon(HeaderIconLink.LOG_IN);
        String email = "";
        String password = "";
        Properties property = new Properties();
        try (FileInputStream fis = new FileInputStream("src/main/resources/_testdata.properties")) {
            property.load(fis);
            email = property.getProperty("test_credentials").split("/")[0];
            password = property.getProperty("test_credentials").substring(
                    (property.getProperty("test_credentials").indexOf(":"))+1,
                    (property.getProperty("test_credentials").indexOf("}")));
        }
        catch (IOException e){
            LOGGER.error(e);
        }
        homePage.getLoginForm().writeToLoginTextBox(email);
        homePage.getLoginForm().writeToPasswordTextBox(password);
        LoginPage loginPage = homePage.getLoginForm().LoginButtonClick();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(loginPage.isLoggedIn(),true,"Failed: not logged in");
        softAssert.assertAll();
    }

    @Test(description = "login form functionality testing")
    @MethodOwner(owner = "YakubT")
    public void testLoginFormFunctionality() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        homePage.getHeaderMenu().clickHeaderMenuIcon(HeaderIconLink.LOG_IN);
        SoftAssert softAssert = new SoftAssert();
        LoginForm loginForm = homePage.getLoginForm();
        softAssert.assertEquals(loginForm.isLoginTextPresented(),true,
                "Title login text is not presented");
        softAssert.assertEquals(loginForm.isLoginTextBoxPresented(),true, "Emails textField is " +
                "not present");
        softAssert.assertEquals(loginForm.isLoginTextBoxTypeAble(),true, "Can't type email");
        softAssert.assertEquals(loginForm.isPasswordTextBoxPresented(),true, "Passwords textField is " +
                "not present");
        softAssert.assertEquals(loginForm.isLoginTextBoxTypeAble(),true, "Can't type password");
        softAssert.assertEquals(loginForm.isLoginButtonPresent(),true, "Log in button is not present");
        loginForm.hoverLoginButton();
        pause(1);
        Color color =Color.fromString(loginForm.getLoginButtonColor().asHex());
        LOGGER.info(color.asHex());
        softAssert.assertEquals(loginForm.getLoginButtonColor().asHex().equals("#d50000"),true,
                "Color is not red");
        softAssert.assertEquals(loginForm.isForgotPasswordButtonPresent(),true,
                "Forgot my password button is not present");
        softAssert.assertEquals(loginForm.isForgotPasswordButtonClickable(),true,
                "Forgot my password button is not clickable");
        softAssert.assertAll();
    }
}
