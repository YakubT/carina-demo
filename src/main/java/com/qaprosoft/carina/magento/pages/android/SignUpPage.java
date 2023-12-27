package com.qaprosoft.carina.magento.pages.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.magento.pages.common.SignUpPageBase;
import com.qaprosoft.carina.magento.components.common.SignUpFormBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = SignUpPageBase.class)
public class SignUpPage extends SignUpPageBase {

    private final com.qaprosoft.carina.magento.pages.desktop.SignUpPage signUpPage =
            new com.qaprosoft.carina.magento.pages.desktop.SignUpPage(getDriver());

    @FindBy(partialLinkText = "Create an Account")
    private ExtendedWebElement marker;

    public SignUpPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(marker);
    }

    @Override
    public SignUpFormBase getSignUpForm() {
       return signUpPage.getSignUpForm();
    }

    @Override
    public boolean isErrorMessageDisplayed() {
        return signUpPage.isErrorMessageDisplayed();
    }

}
