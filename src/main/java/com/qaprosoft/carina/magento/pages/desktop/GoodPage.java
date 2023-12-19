package com.qaprosoft.carina.magento.pages.desktop;


import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.magento.pages.common.GoodPageBase;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = GoodPageBase.class)
public class GoodPage extends GoodPageBase {

    @FindBy(xpath = "//div[contains(@id,'color')]")
    private List<ExtendedWebElement> colors;

    @FindBy(xpath = "//div[contains(@id,'size')]")
    private List<ExtendedWebElement> sizes;

    @FindBy(xpath = "//button[contains(@id,'addtocart')]")
    private ExtendedWebElement submitButton;

    @FindBy(xpath = "(//span[@class='swatch-attribute-selected-option'])[2]")
    private ExtendedWebElement titleColor;

    @FindBy(xpath = "//div[contains(@class,'product-info-price')]//span[contains(@id,'price')]")
    private ExtendedWebElement price;

    public GoodPage(WebDriver driver) {
        super(driver);
    }

    public String getSizeByIndex(int index) {
        return sizes.get(index).getText();
    }

    public String getCurrentColor() {
        return titleColor.getText();
    }

    public void chooseColor(int index) {
        colors.get(index).click();
    }

    public void chooseSize(int index) {
        sizes.get(index).click();
    }

    public void submit() {
        submitButton.click();
    }

    public String getPrice() {
        return price.getText();
    }
}