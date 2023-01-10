package com.qaprosoft.carina.demo.mobile.gui.pages.android;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.MapsPageBase;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = MapsPageBase.class)
public class MapsPage extends MapsPageBase {

    @FindBy(id = "com.solvd.carinademoapplication:id/toolbar")
    private ExtendedWebElement toolbar;

    public MapsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return toolbar.isElementPresent();
    }

}
