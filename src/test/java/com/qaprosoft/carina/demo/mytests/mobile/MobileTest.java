package com.qaprosoft.carina.demo.mytests.mobile;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.CarinaDescriptionPageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.LoginPageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.MapsPageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.WelcomePageBase;
import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
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
        CarinaDescriptionPageBase carinaDescriptionPage = loginPageBase.login();
        Assert.assertTrue(carinaDescriptionPage.isPageOpened(), "Carina description page isn't opened");
    }

    @Test(description = "testing map feature")
    @MethodOwner(owner = "YakubT")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void testMap() {
        WelcomePageBase welcomePage = initPage(getDriver(), WelcomePageBase.class);
        LoginPageBase loginPage = welcomePage.clickNextBtn();
        CarinaDescriptionPageBase carinaDescriptionPage = loginPage.login();
        Assert.assertTrue(carinaDescriptionPage.isPageOpened(), "Carina description page isn't opened");
        MapsPageBase mapsPage = carinaDescriptionPage.navigateToMapPage();
        Assert.assertTrue(mapsPage.isPageOpened(), "Page didn't open");
    }
}
