package com.qaprosoft.carina.demo.mytests.newweb;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.gui.components.HeaderMenu;
import com.qaprosoft.carina.demo.gui.enums.HeaderButtonLink;
import com.qaprosoft.carina.demo.gui.pages.HomePage;
import com.qaprosoft.carina.demo.gui.pages.PhoneFinderPage;

public class PhoneFinderTest implements IAbstractTest {

    @Test
    public void testPhoneFindProcess() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        HeaderMenu headerMenu = homePage.getHeaderMenu();
        Assert.assertTrue(headerMenu.isHeaderMenuButtonPresent(HeaderButtonLink.PHONE_FINDER),
                "Phone finder doesn't exists");
        PhoneFinderPage phoneFinderPage = (PhoneFinderPage) headerMenu.clickHeaderMenuButton(HeaderButtonLink.PHONE_FINDER);
        phoneFinderPage.clickBrandButton();
        phoneFinderPage.chooseBrandDropDownItem("Xiaomi");
        Assert.assertTrue(phoneFinderPage.isShowButtonPresent(), "Show button isn't present");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(phoneFinderPage.isShowButtonHasValidText(), "Show btn should have text = 'x' results'");
        phoneFinderPage.clickShowButton();
    }
}
