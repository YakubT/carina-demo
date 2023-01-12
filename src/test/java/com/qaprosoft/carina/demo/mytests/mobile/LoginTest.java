package com.qaprosoft.carina.demo.mytests.mobile;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.Test;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.CarinaDescriptionPageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.LoginPageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.WelcomePageBase;
import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.mobile.IMobileUtils;

public class LoginTest implements IAbstractTest, IMobileUtils {

    @Test(description = "verifying login page")
    @MethodOwner(owner = "YakubT")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void testLogin() {
        //Login page is opened
        WelcomePageBase welcomePageBase = initPage(getDriver(),WelcomePageBase.class);
        LoginPageBase loginPage = welcomePageBase.clickNextBtn();
        Assert.assertTrue(loginPage.isPageOpened(),"Login page is not opened");
        // verify all fields are presented
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(loginPage.isNameFieldPresent(),"Name field is not presented");
        softAssert.assertTrue(loginPage.isPasswordFieldPresent(),"Password field is not presented");
        softAssert.assertTrue(loginPage.isMaleSexRadioButtonPresent(),"Male radiobutton is not presented");
        softAssert.assertTrue(loginPage.isFemaleSexRadioButtonPresent(),"Female radiobutton is not presented");
        softAssert.assertTrue(loginPage.isPrivacyPolicyCheckboxPresent(),"Privacy policy " +
                "checkbox is not presented");
        //male/female and privacy policy isn't checked
        softAssert.assertFalse(loginPage.isSexMaleChecked(),"Male mustn't be checked");
        softAssert.assertFalse(loginPage.isSexFemaleChecked(),"Female mustn't be checked");
        softAssert.assertFalse(loginPage.isPrivacyPolicyCheckboxChecked(),"Privacy Policy mustn't be checked");
        // type name and password
        loginPage.typeName(R.TESTDATA.get("user_name"));
        loginPage.typePassword(R.TESTDATA.getDecrypted("pass"));
        softAssert.assertEquals(loginPage.getPasswordFieldText(), R.TESTDATA.getDecrypted("pass"),
                "Password is not typed");
        //select sex
        loginPage.selectMaleSex();
        Assert.assertTrue(loginPage.isSexMaleChecked(),"Male isn't checked");
        //tap Privacy Policy checkbox
        loginPage.checkPrivacyPolicyCheckbox();
        Assert.assertTrue(loginPage.isSexMaleChecked(),"Privacy Policy isn't checked");
        //click Sign Up btn
        CarinaDescriptionPageBase carinaDescriptionPage = loginPage.clickLoginBtn();
        Assert.assertTrue(carinaDescriptionPage.isPageOpened(),"WebViewPage isn't opened");
        softAssert.assertAll();
    }
}
