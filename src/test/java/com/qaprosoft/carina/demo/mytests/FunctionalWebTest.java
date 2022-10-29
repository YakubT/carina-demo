package com.qaprosoft.carina.demo.mytests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.gui.components.FooterMenu;
import com.qaprosoft.carina.demo.gui.components.HeaderMenu;
import com.qaprosoft.carina.demo.gui.components.LoginForm;
import com.qaprosoft.carina.demo.gui.enums.FooterButtonLink;
import com.qaprosoft.carina.demo.gui.enums.HeaderButtonLink;
import com.qaprosoft.carina.demo.gui.enums.HeaderIconLink;
import com.qaprosoft.carina.demo.gui.pages.HomePage;

public class FunctionalWebTest implements IAbstractTest {

    private static final Logger LOGGER = LogManager.getLogger(FunctionalWebTest.class);

    @Test
    @MethodOwner(owner = "YakubT")
    public void testLoginForm() {
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

    @Test
    @MethodOwner(owner = "YakubT")
    public void testHeader() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        //Closing advertising if it's displayed
        homePage.getWeValuePrivacyAd().closeAdIfPresent();
        homePage.clickHamburgerMenu();
        HeaderMenu headerMenu = homePage.getHeaderMenu();
        SoftAssert softAssert = new SoftAssert();
        for (HeaderButtonLink headerButtonLink:HeaderButtonLink.values()) {
            softAssert.assertEquals(headerMenu.isHeaderMenuButtonPresent(headerButtonLink),true,headerButtonLink.getValue() +
                    " menu button isn't present ");
        }

        String prevUrl = "https://www.gsmarena.com/";
        for (HeaderButtonLink headerButtonLink:HeaderButtonLink.values()) {
            headerMenu.clickHeaderMenuButton(headerButtonLink);
            softAssert.assertEquals(getDriver().getCurrentUrl()!=prevUrl,true,headerButtonLink.getValue()+
                    " page didn't open");
            prevUrl = getDriver().getCurrentUrl();
        }
        softAssert.assertAll();
    }

    @Test
    @MethodOwner(owner = "YakubT")
    public void testFooter() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        FooterMenu footerMenu = homePage.getFooterMenu();
        SoftAssert softAssert = new SoftAssert();
        for (FooterButtonLink footerButtonLink:FooterButtonLink.values()) {
            homePage.open();
            Assert.assertEquals(footerMenu.isFooterMenuButtonPresent(footerButtonLink),true,footerButtonLink.getValue() +
                    " menu button isn't present ");
        }
        String prevUrl = "https://www.gsmarena.com/";
        for (FooterButtonLink footerButtonLink:FooterButtonLink.values()) {
            homePage.open();
            footerMenu.clickFooterMenuButton(footerButtonLink);
            softAssert.assertEquals(getDriver().getCurrentUrl()!=prevUrl,true, footerButtonLink.getValue() +
                    " page didn't open");
            prevUrl = getDriver().getCurrentUrl();
        }
        softAssert.assertAll();
    }
}
