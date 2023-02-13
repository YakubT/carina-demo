package com.qaprosoft.carina.demo.mytests.newweb;

import com.qaprosoft.carina.demo.gui.enums.HeaderIconLink;
import com.qaprosoft.carina.demo.gui.pages.PhoneFinderPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.gui.pages.HomePage;
import com.qaprosoft.carina.demo.gui.components.HeaderMenu;
import com.qaprosoft.carina.demo.gui.enums.HeaderButtonLink;

public class PhoneFinderTest implements IAbstractTest {

    @Test
    public void testPhoneFindProcess() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        HeaderMenu headerMenu = homePage.getHeaderMenu();
        Assert.assertTrue(headerMenu.isHeaderMenuButtonPresent(HeaderButtonLink.PHONE_FINDER),
                "Phone finder doesn't exists");
        PhoneFinderPage phoneFinderPage = (PhoneFinderPage) headerMenu.clickHeaderMenuButton(HeaderButtonLink.PHONE_FINDER);
        
    }
}
