package com.qaprosoft.carina.demo.mytests.magento;

import com.qaprosoft.carina.magento.pages.common.AccountPageBase;
import com.zebrunner.carina.utils.R;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.gui.services.magento.UserService;
import com.qaprosoft.carina.magento.pages.common.HomePageBase;
import com.qaprosoft.carina.magento.pages.common.SignInPageBase;

public class SignInTest implements IAbstractTest {

    @Test(testName = "regression#1")
    public void testExistingUser() {
        HomePageBase homePage = initPage(getDriver(),HomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened());
        SignInPageBase signInPage = homePage.getHeaderMenu().clickSignInButton();
        signInPage.signIn(UserService.getDefaultUser());
        if (R.CONFIG.getProperties().get("capabilities.platformName").equals("ANDROID")) {
            AccountPageBase accountPageBase = initPage(getDriver(), AccountPageBase.class);
            Assert.assertTrue(accountPageBase.isPageOpened());
        } else {
            Assert.assertTrue(homePage.isPageOpened());
        }
    }
}
