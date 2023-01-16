package com.qaprosoft.carina.demo.mytests.mobile;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.CarinaDescriptionPageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.LoginPageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.MapsPageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.WelcomePageBase;
import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.utils.mobile.IMobileUtils;

public class MapTest implements IAbstractTest, IMobileUtils {

    @Test (description = "Verify Map feature")
    @MethodOwner (owner = "YakubT")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void testMapFeature() {
        WelcomePageBase welcomePageBase = initPage(getDriver(),WelcomePageBase.class);
        LoginPageBase loginPage = welcomePageBase.clickNextBtn();
        CarinaDescriptionPageBase carinaDescriptionPage = loginPage.login();
        //Web View page is opened
        Assert.assertTrue(carinaDescriptionPage.isPageOpened(),"Web View page is not opened");
        MapsPageBase mapsPage = carinaDescriptionPage.navigateToMapPage();
        //Map page is opened
        Assert.assertTrue(mapsPage.isPageOpened(),"Map page is not opened");
        // Zoom and Zoom out btns is presented
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(mapsPage.isZoomInBtnPresent(),"Zoom in btn isn't presented");
        softAssert.assertTrue(mapsPage.isZoomOutBtnPresent(),"Zoom out btn isn't presented");
        // Zoom in above zoom out
        Assert.assertTrue(mapsPage.getZoomInCoordinateY()+mapsPage.getZoomInHeight()
                <=mapsPage.getZoomOutCoordinateY(),"Zoom in isn't above zoom out");
        softAssert.assertAll();
    }
}
