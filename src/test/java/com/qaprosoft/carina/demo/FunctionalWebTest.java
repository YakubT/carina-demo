package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.gui.components.HeaderMenu;
import com.qaprosoft.carina.demo.gui.components.LoginForm;
import com.qaprosoft.carina.demo.gui.components.enums.HeaderButtonLink;
import com.qaprosoft.carina.demo.gui.components.enums.HeaderIconLink;
import com.qaprosoft.carina.demo.gui.pages.HomePage;
import org.apache.commons.codec.binary.Hex;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.devtools.v85.dom.model.RGBA;
import org.openqa.selenium.support.Color;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class FunctionalWebTest implements IAbstractTest {

    private static final Logger LOGGER = LogManager.getLogger(FunctionalWebTest.class);

    @Test
    public void testLoginForm() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        homePage.getHeaderMenu().clickHeaderIcon(HeaderIconLink.LOG_IN);
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
        softAssert.assertEquals(loginForm.isSubmitButtonPresent(),true, "Log in button is not present");
        loginForm.hoverSubmitButton();
        try {
            Thread.sleep(300);
        }
        catch (InterruptedException e) {
            LOGGER.info(e);
        }
        Color color =Color.fromString(loginForm.getSubmitButtonColor().asHex());
        LOGGER.info(color.asHex());
        softAssert.assertEquals(loginForm.getSubmitButtonColor().asHex().equals("#d50000"),true,
                "Color is not red");
        softAssert.assertEquals(loginForm.isForgotPasswordButtonPresent(),true,
                "Forgot my password button is not present");
        softAssert.assertEquals(loginForm.isForgotPasswordButtonClickable(),true,
                "Forgot my password button is not clickable");
        softAssert.assertAll();
    }

    @Test
    public void testHeader() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        //Closing advertising if it's displayed
        homePage.getWeValuePrivacyAd().closeAdIfPresent();
        homePage.clickHamburgerMenu();
        HeaderMenu headerMenu = homePage.getHeaderMenu();
        SoftAssert softAssert = new SoftAssert();
        for (HeaderButtonLink headerButtonLink:HeaderButtonLink.values()) {
            softAssert.assertEquals(headerMenu.isHeaderMenuButtonPresent(headerButtonLink),true,"header " +
                    "menu button isn't present ");
        }

        String prevUrl = "https://www.gsmarena.com/";
        for (HeaderButtonLink headerButtonLink:HeaderButtonLink.values()) {
            headerMenu.clickHeaderMenuButton(headerButtonLink);
            softAssert.assertEquals(getDriver().getCurrentUrl()!=prevUrl,true,"Page didn't open");
            prevUrl = getDriver().getCurrentUrl();
        }
        softAssert.assertAll();
    }
}
