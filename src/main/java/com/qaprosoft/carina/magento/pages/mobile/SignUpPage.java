package com.qaprosoft.carina.magento.pages.mobile;

import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.magento.pages.common.SignUpPageBase;
import com.qaprosoft.carina.magento.components.common.SignUpFormBase;
import com.zebrunner.carina.utils.factory.DeviceType;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = SignUpPageBase.class)
public class SignUpPage extends SignUpPageBase{

    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public SignUpFormBase getSignUpForm() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isErrorMessageDisplayed() {
        throw new UnsupportedOperationException();
    }

}
