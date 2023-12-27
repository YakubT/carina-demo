package com.qaprosoft.carina.magento.components.desktop;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.gui.models.magento.ExtendedUser;
import com.qaprosoft.carina.magento.pages.desktop.AccountPage;
import com.qaprosoft.carina.magento.components.common.SignUpFormBase;

public class SignUpForm extends SignUpFormBase {

    @FindBy(id = "firstname")
    private ExtendedWebElement firstNameField;

    @FindBy(id = "lastname")
    private ExtendedWebElement lastNameField;

    @FindBy(id = "email_address")
    private ExtendedWebElement emailField;

    @FindBy(id = "password")
    private ExtendedWebElement passwordField;

    @FindBy(id = "password-confirmation")
    private ExtendedWebElement confirmPasswordField;

    @FindBy(xpath = ".//button")
    private ExtendedWebElement submitButton;

    @FindBy(id = "password-strength-meter")
    private ExtendedWebElement passwordStrength;

    public SignUpForm(WebDriver driver,SearchContext searchContext) {
        super(driver,searchContext);
    }

    public void fillLastNameField(String lastName) {
        lastNameField.type(lastName);
    }

    public void fillFirstNameField(String firstName) {
        firstNameField.type(firstName);
    }

    public void fillEmailField(String fillName) {
        emailField.type(fillName);
    }

    public void fillPasswordField(String password) {
        passwordField.type(password);
    }

    public void fillConfirmPasswordField(String password) {
        confirmPasswordField.type(password);
    }

    public void submit() {
        submitButton.click();
    }

    protected void baseCreateAccount(ExtendedUser user) {
        fillFirstNameField(user.getFirstName());
        fillLastNameField(user.getLastName());
        fillEmailField(user.getEmail());
        fillPasswordField(user.getPassword());
    }

    public AccountPage createAccount(ExtendedUser user) {
        baseCreateAccount(user);
        fillConfirmPasswordField(user.getPassword());
        submit();
        return new AccountPage(getDriver());
    }

    public AccountPage createAccount(ExtendedUser user, String confirmString) {
        baseCreateAccount(user);
        fillConfirmPasswordField(confirmString);
        submit();
        return new AccountPage(getDriver());
    }

    public String getPasswordStrength() {
        return passwordStrength.getText();
    }

}

