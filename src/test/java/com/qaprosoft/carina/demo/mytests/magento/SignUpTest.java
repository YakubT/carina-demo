package com.qaprosoft.carina.demo.mytests.magento;

import com.qaprosoft.carina.core.foundation.dataprovider.annotations.CsvDataSourceParameters;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.gui.components.magento.SignUpForm;
import com.qaprosoft.carina.demo.gui.models.magento.ExtendedUser;
import com.qaprosoft.carina.magento.pages.desktop.AccountPage;
import com.qaprosoft.carina.magento.pages.desktop.HomePage;
import com.qaprosoft.carina.magento.pages.desktop.SignUpPage;
import com.qaprosoft.carina.demo.gui.services.magento.ExtendedUserService;

import java.util.Map;

public class SignUpTest implements IAbstractTest {

    @Test(dataProvider = "userProvider", testName = "data-driven#1")
    public void testSignUpWithStrongPassword(ExtendedUser user) {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened());
        SignUpPage signUpPage = homePage.getHeaderMenu().clickSignUpPage();
        Assert.assertTrue(signUpPage.isPageOpened());
        AccountPage accountPage = signUpPage.getSignUpForm().createAccount(user);
        Assert.assertTrue(accountPage.isPageOpened() || signUpPage.isErrorMessageDisplayed(),
                "Test failed with user "+user.toString());
    }


    private String weakPassword = "Password Strength: Weak";

    @Test(dataProvider = "DataProvider",testName = "data-driven#2")
    @CsvDataSourceParameters(path = "csv/weak_passwords.csv")
    public void testWeakPassword(Map<String, String> args) {
        String password = args.get("password");
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened());
        SignUpPage signUpPage = homePage.getHeaderMenu().clickSignUpPage();
        SignUpForm signUpForm = signUpPage.getSignUpForm();
        signUpForm.fillPasswordField(password);
        Assert.assertEquals(signUpForm.getPasswordStrength().trim(),weakPassword,
                signUpForm.getPasswordStrength().trim());
    }

    @DataProvider(name = "userProvider",parallel = true)
    public Object[][] userProvider() {
        Object[][] res = new Object[50][1];
        for (int i = 0; i < res.length; i++) {
            res[i][0] = ExtendedUserService.generateRandomValidUser();
        }
        return res;
    }
}

