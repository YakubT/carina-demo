package com.qaprosoft.carina.magento.pages.common;

import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.gui.models.magento.User;

public abstract class SignInPageBase extends AbstractPage {
    public SignInPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void fillEmailField(String email);

    public abstract void fillPasswordField(String password);

    public abstract void signInButtonClick();

    public abstract HomePageBase signIn(User user);
}
