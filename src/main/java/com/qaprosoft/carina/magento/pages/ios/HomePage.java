package com.qaprosoft.carina.magento.pages.ios;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.qaprosoft.carina.demo.utils.MobileContextUtils;
import com.qaprosoft.carina.magento.components.ios.HeaderMenu;
import com.qaprosoft.carina.magento.pages.common.HomePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase {

    @FindBy(xpath = "//div[contains(@class,'header content')]")
    private HeaderMenu headerMenu;

    public HomePage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_URL);
        setPageAbsoluteURL("https://magento.softwaretestingboard.com/");
        MobileContextUtils contextUtils = new MobileContextUtils();
        contextUtils.switchMobileContext(MobileContextUtils.View.WEB);
    }

    @Override
    public HeaderMenu getHeaderMenu() {
        return headerMenu;
    }
}
