package com.qaprosoft.carina.demo.mytests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.gui.pages.HomePage;
import com.qaprosoft.carina.demo.gui.pages.SignUpPage;

public class SignupTest implements IAbstractTest {

    private static final Logger LOGGER = LogManager.getLogger(SignupTest.class);

    @Test(description = "test ability to sign up")
    @MethodOwner(owner = "YakubT")
    public void testSignUp() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        SignUpPage signUpPage = homePage.getHeaderMenu().goToSignUpPage();
        Properties property = new Properties();
        String email = "";
        String password = "";
        String username ="";
        try (FileInputStream fis = new FileInputStream("src/main/resources/_testdata.properties")) {
            property.load(fis);
            username = property.getProperty("user_name");
            email = property.getProperty("test_credentials").split("/")[0];
            password = property.getProperty("test_credentials").substring(
                    (property.getProperty("test_credentials").indexOf(":"))+1,
                    (property.getProperty("test_credentials").indexOf("}")));
        }
        catch (IOException e){
            LOGGER.error(e);
        }

        signUpPage.writeToNicknameTextBox(username);
        signUpPage.writeToEmailTextBox(email);
        signUpPage.writeToPasswordTextBox(password);
        signUpPage.confirmEverything();
        signUpPage.clickSubmitButton();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(signUpPage.isRegistered(),true,"Failed: not registered");
        softAssert.assertAll();
    }
}
