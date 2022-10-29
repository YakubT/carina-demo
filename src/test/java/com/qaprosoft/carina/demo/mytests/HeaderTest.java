package com.qaprosoft.carina.demo.mytests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.gui.components.HeaderMenu;
import com.qaprosoft.carina.demo.gui.enums.HeaderButtonLink;
import com.qaprosoft.carina.demo.gui.pages.HomePage;

public class HeaderTest implements IAbstractTest {
    @Test (description = "testing header functionality: " +
            "is all buttons are present and we can go to the next page by clicking on them")
    @MethodOwner(owner = "YakubT")
    public void testHeaderFunctionality() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
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
}
