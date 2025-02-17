package com.qaprosoft.carina.demo.mobile.gui.pages.android;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.ContactUsPageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.WebViewPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = WebViewPageBase.class)
public class WebViewPage extends WebViewPageBase {

    @FindBy(linkText = "Contact Us")
    private ExtendedWebElement contactUsLink;

    @FindBy(xpath = "//div[@id = 'rec42972268']//div[contains(@class,'burger')]")
    private  ExtendedWebElement burger;
    public WebViewPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public ContactUsPageBase goToContactUsPage() {
        burger.click();
        contactUsLink.click();
        return initPage(getDriver(), ContactUsPageBase.class);
    }

}
