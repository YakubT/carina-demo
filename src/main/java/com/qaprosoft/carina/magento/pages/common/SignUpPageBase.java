package com.qaprosoft.carina.magento.pages.common;

import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.magento.components.common.SignUpFormBase;

public abstract class SignUpPageBase extends AbstractPage {

    public SignUpPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract SignUpFormBase getSignUpForm();

    public abstract boolean isErrorMessageDisplayed();
}
