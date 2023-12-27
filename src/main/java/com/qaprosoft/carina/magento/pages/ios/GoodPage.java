package com.qaprosoft.carina.magento.pages.ios;

import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.magento.pages.common.GoodPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = GoodPageBase.class)
public class GoodPage extends GoodPageBase {

    private final com.qaprosoft.carina.magento.pages.desktop.GoodPage goodPageDesk
            = new com.qaprosoft.carina.magento.pages.desktop.GoodPage(getDriver());

    public GoodPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getSizeByIndex(int index) {
        pause(5);
        return goodPageDesk.getSizeByIndex(index);
    }

    @Override
    public String getCurrentColor() {
        pause(5);
        return goodPageDesk.getCurrentColor();
    }

    @Override
    public void chooseColor(int index) {
        pause(5);
        goodPageDesk.chooseColor(index);
    }

    @Override
    public void chooseSize(int index) {
        pause(5);
        goodPageDesk.chooseSize(index);
    }

    @Override
    public void submit() {
        pause(5);
        goodPageDesk.submit();
    }

    @Override
    public String getPrice() {
        pause(5);
        return goodPageDesk.getPrice();
    }
}
