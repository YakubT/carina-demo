package com.qaprosoft.carina.magento.pages.mobile;

import com.qaprosoft.carina.demo.utils.MobileContextUtils;
import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.qaprosoft.carina.magento.components.desktop.HeaderMenu;
import com.qaprosoft.carina.magento.pages.common.HomePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase {

    public HomePage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_URL);
        setPageAbsoluteURL("https://magento.softwaretestingboard.com/");
        MobileContextUtils contextUtils = new MobileContextUtils();
        contextUtils.switchMobileContext(MobileContextUtils.View.WEB1);
    }

    @Override
    public HeaderMenu getHeaderMenu() {
        return null;
    }
}
