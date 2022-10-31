package com.qaprosoft.carina.demo.mytests;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
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
        LoginPage loginPage = homePage.getLoginForm().clickLoginButton();
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

    @Test (description = "test unsuccessful login scenarios", dataProvider = "login scenarios")
    @MethodOwner(owner = "YakubT")
    public void testLogInUnSuccessfulDataProvider(String login, String password, String expectedMessage) {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        homePage.getHeaderMenu().clickHeaderMenuIcon(HeaderIconLink.LOG_IN);
        LoginForm loginForm = homePage.getLoginForm();
        loginForm.writeToLoginTextBox(login);
        loginForm.writeToPasswordTextBox(password);
        loginForm.clickLoginButton();
        LOGGER.info("login tooltip: "+loginForm.getTooltipMessagePasswordTextBox());
        LOGGER.info("password tooltip: "+loginForm.getTooltipMessageLoginTextBox());
        String actualMessage = !loginForm.getTooltipMessageLoginTextBox().isEmpty()?loginForm.getTooltipMessageLoginTextBox():
                loginForm.getTooltipMessagePasswordTextBox();
        LOGGER.info(actualMessage);
        LOGGER.info(expectedMessage);
        Assert.assertEquals(actualMessage.contains(expectedMessage),true,
                "Fail: actual: "+actualMessage+" expected: "+
                       expectedMessage);
    }

    @DataProvider(parallel = false, name = "login scenarios")
    public Object[][] dataProviderLogin() {
        return new Object[][] {
                //1
                {"","","Заполните это поле"},
                //2
                {"testEmail","","Адрес электронной почты должен содержать"},
                {"testEmail@","","Введите часть адреса"},
                //3
                {"","1", "Заполните это поле"},
                //4
                {"testEmail","1","Адрес электронной почты должен содержать"},
                {"testEmail@","1","Введите часть адреса"},
                //5
                {"testEmail","1234To","Адрес электронной почты должен содержать"},
                //6
                {"testEmail@ukr.net","1","Введите данные в указанном формате."},
                //7
                {"testEmail@","1234To","Введите часть адреса"},
        };
    }
}
