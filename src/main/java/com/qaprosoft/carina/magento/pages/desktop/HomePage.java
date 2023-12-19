package com.qaprosoft.carina.magento.pages.desktop;

import com.qaprosoft.carina.magento.pages.common.CatalogSearchPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.qaprosoft.carina.magento.components.desktop.HeaderMenu;
import com.qaprosoft.carina.magento.pages.common.HomePageBase;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase {

    @FindBy(xpath = "//header[contains(@class,'page')]")
    private HeaderMenu headerMenu;

    public HomePage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_URL);
        setPageAbsoluteURL("https://magento.softwaretestingboard.com/");
    }

    public HeaderMenu getHeaderMenu() {
        return headerMenu;
    }
}
