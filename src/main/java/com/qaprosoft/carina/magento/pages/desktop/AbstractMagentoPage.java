package com.qaprosoft.carina.magento.pages.desktop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.magento.components.desktop.HeaderMenu;
import com.qaprosoft.carina.magento.pages.common.AbstractMagentoPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = AbstractMagentoPage.class)
public abstract class AbstractMagentoPage extends AbstractMagentoPageBase {
    @FindBy(xpath = "//header[contains(@class,'page')]")
    private HeaderMenu headerMenu;

    public AbstractMagentoPage(WebDriver driver) {
        super(driver);
    }

    public HeaderMenu getHeaderMenu() {
        return headerMenu;
    }
}
