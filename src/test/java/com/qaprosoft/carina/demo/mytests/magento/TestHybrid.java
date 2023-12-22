package com.qaprosoft.carina.demo.mytests.magento;

import com.qaprosoft.carina.demo.mytests.mobile.NativeChrome;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.magento.pages.common.HomePageBase;
import com.qaprosoft.carina.demo.utils.MobileContextUtils;

public class TestHybrid implements IAbstractTest {

    @Test
    public void testHybrid() {
        HomePageBase homePage = initPage(getDriver(),HomePageBase.class);
        homePage.open();
        MobileContextUtils mobileContextUtils = new MobileContextUtils();
        mobileContextUtils.switchMobileContext(MobileContextUtils.View.NATIVE);
        NativeChrome nativeChrome = new NativeChrome(getDriver());
        nativeChrome.openNewTab();
    }
}
