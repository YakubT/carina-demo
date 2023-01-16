package com.qaprosoft.carina.demo.mytests.newweb;

import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.Test;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.gui.components.HeaderMenu;
import com.qaprosoft.carina.demo.gui.enums.HeaderButtonLink;
import com.qaprosoft.carina.demo.gui.enums.HeaderIconLink;
import com.qaprosoft.carina.demo.gui.pages.HomePage;

public class HeaderTest implements IAbstractTest {

    @Test(description = "Verifying all header components are presented")
    @MethodOwner (owner = "YakubT")
    @TestLabel(name = "feature", value = {"web", "acceptance"})
    public void testHeaderComponentsPresent() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        HeaderMenu headerMenu = homePage.getHeaderMenu();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(headerMenu.isHamburgerMenuButtonPresent(),"Hamburger menu btn isn't presented");
        softAssert.assertTrue(headerMenu.isSearchPanelPresent(),"Search panel isn't presented");
        softAssert.assertTrue(headerMenu.isLogoPresent(),"Logo isn't presented");
        for (HeaderIconLink headerIconLink:HeaderIconLink.values()) {
            softAssert.assertTrue(headerMenu.isHeaderMenuIconPresent(headerIconLink),headerIconLink.getValue()+
                    " icon isn't present");
        }
        for (HeaderButtonLink headerButtonLink:HeaderButtonLink.values()) {
            softAssert.assertTrue(headerMenu.isHeaderMenuButtonPresent(headerButtonLink),
                    headerButtonLink.getValue()+
                    " button isn't present");
        }
        softAssert.assertAll();
    }
}
