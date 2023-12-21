package com.qaprosoft.carina.demo.mytests.magento;

import org.testng.annotations.Test;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.magento.pages.common.HomePageBase;

public class Demo implements IAbstractTest {

    @Test
    public void demoTest() {
        HomePageBase homePageBase = initPage(getDriver(), HomePageBase.class);
        homePageBase.open();
    }
}
