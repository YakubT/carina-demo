package com.qaprosoft.carina.demo.gui.components;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.gui.pages.LoginPage;

public class LoginForm extends AbstractUIObject {

    @FindBy(id = "email")
    private ExtendedWebElement loginTextBox;

    @FindBy(id = "upass")
    private ExtendedWebElement passwordTextBox;

    @FindBy(id = "nick-submit")
    private ExtendedWebElement loginButton;

    @FindBy(xpath = "//p[text() = 'Login']")
    private ExtendedWebElement loginText;

    @FindBy(xpath = "//a[@class = 'forgot']")
    private ExtendedWebElement forgotPasswordButton;

    public LoginForm(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void writeToLoginTextBox(String s) {
        loginTextBox.type(s);
    }

    public void writeToPasswordTextBox(String s) {
        passwordTextBox.type(s);
    }

    public LoginPage login(String email, String password) {
        writeToLoginTextBox(email);
        writeToPasswordTextBox(password);
        return clickLoginButton();
    }

    public LoginPage clickLoginButton() {
        loginButton.click();
        return new LoginPage(getDriver());
    }

    public boolean isLoginTextPresented() {
        return loginText.isElementPresent();
    }

    public boolean isLoginTextBoxPresented() {
        return loginTextBox.isElementPresent();
    }

    public boolean isLoginButtonPresent() {
        return loginButton.isElementPresent();
    }

    public boolean isForgotPasswordButtonPresent() {
        return forgotPasswordButton.isElementPresent();
    }

    public void hoverLoginButton() {
        loginButton.hover();
    }

    public Color getLoginButtonColor() {
        return Color.fromString(loginButton.getElement().getCssValue("background-color"));
    }

    public boolean isPasswordTextBoxPresented() {
        return passwordTextBox.isElementPresent();
    }

    public boolean isLoginTextBoxTypeAble() {
        try {
            loginTextBox.type("text");
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean isPasswordTextBoxTypeAble() {
        try {
            passwordTextBox.type("text");
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean isForgotPasswordButtonClickable() {
        return forgotPasswordButton.isClickable();
    }

    public String getTooltipMessageLoginTextBox() {
        return loginTextBox.getAttribute("validationMessage");
    }

    public String getTooltipMessagePasswordTextBox() {
        return passwordTextBox.getAttribute("validationMessage");
    }
}
