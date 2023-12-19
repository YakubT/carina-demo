package com.qaprosoft.carina.magento.pages.desktop;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.magento.pages.common.CartPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = CartPageBase.class)
public class CartPage extends CartPageBase {

    @FindBy(xpath = "(//dl[contains(@class,'item-options')])//dd[1]")
    private ExtendedWebElement sizeItem;

    @FindBy(xpath = "(//dl[contains(@class,'item-options')])//dd[2]")
    private ExtendedWebElement colorItem;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getSize() {
        return sizeItem.getText();
    }

    public String getColor() {
        return colorItem.getText();
    }

}