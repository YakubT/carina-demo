package com.qaprosoft.carina.demo.mytests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


import com.qaprosoft.carina.core.foundation.utils.StringGenerator;
import com.qaprosoft.carina.demo.db.models.User;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.UsernameAndPassword;
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
        signUpPage.writeToNicknameTextBox(StringGenerator.generateWord(10));
        signUpPage.writeToEmailTextBox(StringGenerator.generateEmail());
        signUpPage.writeToPasswordTextBox(StringGenerator.generateWord(5)+"B1234");
        signUpPage.confirmEverything();
        signUpPage.clickSubmitButton();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(signUpPage.isRegistered(),true,"Failed: not registered");
        softAssert.assertAll();
    }
}
