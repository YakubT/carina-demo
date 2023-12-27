package com.qaprosoft.carina.magento.pages.android;

import com.qaprosoft.carina.magento.pages.common.GoodPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = GoodPageBase.class)
public class GoodPage extends GoodPageBase {

    private final com.qaprosoft.carina.magento.pages.desktop.GoodPage goodPageDesk
            = new com.qaprosoft.carina.magento.pages.desktop.GoodPage(getDriver());

    public GoodPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getSizeByIndex(int index) {
        return goodPageDesk.getSizeByIndex(index);
    }

    @Override
    public String getCurrentColor() {
        return goodPageDesk.getCurrentColor();
    }

    @Override
    public void chooseColor(int index) {
        goodPageDesk.chooseColor(index);
    }

    @Override
    public void chooseSize(int index) {
        goodPageDesk.chooseSize(index);
    }

    @Override
    public void submit() {
        goodPageDesk.submit();
    }

    @Override
    public String getPrice() {
        return goodPageDesk.getPrice();
    }
}
