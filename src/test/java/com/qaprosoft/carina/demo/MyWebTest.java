package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.gui.components.enums.HeaderIconLink;
import com.qaprosoft.carina.demo.gui.pages.HomePage;
import com.qaprosoft.carina.demo.gui.pages.SignUpPage;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class MyWebTest implements IAbstractTest {

    private static final Logger LOGGER = LogManager.getLogger(MyWebTest.class);
    @Test
    public void testSignUp() {
        // Open GSM Arena home page and verify page is opened
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        homePage.getHeaderMenu().clickHeaderIcon(HeaderIconLink.SIGN_UP);
        SignUpPage signUpPage = new SignUpPage(getDriver());
        signUpPage.writeToNicknameTextBox("UserT777");
        Properties property = new Properties();
        String email = "";
        String password = "";
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
        LOGGER.info(email);
        LOGGER.info(password);
        signUpPage.writeToEmailTextBox(email);
        signUpPage.writeToPasswordTextBox(password);
        signUpPage.confirmEverything();
        signUpPage.clickSubmitButton();
    }
}
