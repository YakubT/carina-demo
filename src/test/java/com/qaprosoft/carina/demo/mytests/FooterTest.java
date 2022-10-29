package com.qaprosoft.carina.demo.mytests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.gui.components.FooterMenu;
import com.qaprosoft.carina.demo.gui.enums.FooterButtonLink;
import com.qaprosoft.carina.demo.gui.pages.HomePage;

public class FooterTest implements IAbstractTest {
    @Test (description = "testing footer functionality: " +
            "is all buttons are present and we can go to the next page by clicking on them")
    @MethodOwner(owner = "YakubT")
    public void testFooterFunctionality() {
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
