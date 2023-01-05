package com.qaprosoft.carina.demo.mytests.mobile;

import com.qaprosoft.carina.demo.mobile.gui.pages.common.CarinaDescriptionPageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.LoginPageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.WelcomePageBase;
import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.zebrunner.carina.utils.mobile.IMobileUtils;

public class MobileTest implements IAbstractTest, IMobileUtils {

    @Test(description = "testing login page (sign up in fact)")
    @MethodOwner(owner = "YakubT")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void testLogin() {
        WelcomePageBase welcomePageBase = initPage(getDriver(),WelcomePageBase.class);
        Assert.assertTrue(welcomePageBase.isPageOpened(), "Welcome page isn't open");
        LoginPageBase loginPageBase = welcomePageBase.clickNextBtn();
        Assert.assertFalse(loginPageBase.isLoginBtnActive(),"Login button shouldn't be active");
        loginPageBase.typeName("YakubT");
        loginPageBase.typePassword(RandomStringUtils.randomAlphabetic(10));
        loginPageBase.clickLoginBtn();
        loginPageBase.selectMaleSex();
        loginPageBase.checkPrivacyPolicyCheckbox();
        CarinaDescriptionPageBase carinaDescriptionPage = loginPageBase.clickLoginBtn();
        Assert.assertTrue(carinaDescriptionPage.isPageOpened(), "Carina description page isn't opened");
    }
}
