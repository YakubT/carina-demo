package com.qaprosoft.carina.magento.components.common;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.gui.models.magento.ExtendedUser;
import com.qaprosoft.carina.magento.pages.common.AccountPageBase;

public abstract class SignUpFormBase extends AbstractUIObject {

    public SignUpFormBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract void fillLastNameField(String lastName);

    public abstract void fillFirstNameField(String firstName);

    public abstract void fillEmailField(String fillName);

    public abstract void fillPasswordField(String password);

    public abstract void fillConfirmPasswordField(String password);

    public abstract void submit();

    protected abstract void baseCreateAccount(ExtendedUser user);

    public abstract AccountPageBase createAccount(ExtendedUser user);


    public abstract String getPasswordStrength();
}
