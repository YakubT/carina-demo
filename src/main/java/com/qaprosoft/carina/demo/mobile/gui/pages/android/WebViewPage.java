package com.qaprosoft.carina.demo.mobile.gui.pages.android;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.ContactUsPageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.WebViewPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = WebViewPageBase.class)
public class WebViewPage extends WebViewPageBase {

    @FindBy(xpath = "//android.widget.TextView[2]")
    private ExtendedWebElement hamburgerMenu;

    @FindBy(xpath ="//android.view.View[@content-desc='Contact Us']")
    private ExtendedWebElement contactUsLink;

    public WebViewPage(WebDriver driver) {
        super(driver);
    }

    public void hamburgerMenuClick() {
        hamburgerMenu.click();
    }
    @Override
    public ContactUsPageBase goToContactUsPage() {
        pause(1);
        hamburgerMenuClick();
        pause(1);
        contactUsLink.click();
        return initPage(getDriver(), ContactUsPageBase.class);
    }

}
