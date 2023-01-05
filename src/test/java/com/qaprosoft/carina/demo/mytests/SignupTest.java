package com.qaprosoft.carina.demo.mytests;



import com.zebrunner.carina.utils.StringGenerator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.gui.pages.HomePage;
import com.qaprosoft.carina.demo.gui.pages.SignUpPage;

public class SignupTest implements IAbstractTest {

    private static final Logger LOGGER = LogManager.getLogger(SignupTest.class);

    @Test(description = "test ability to sign up")

    public void testSignUpAbility() {
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
