package com.qaprosoft.carina.magento.pages.desktop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.gui.models.magento.User;

public class SignInPage extends AbstractMagentoPage {

    @FindBy(xpath = "//input[contains(@name,'login[username]')]")
    private ExtendedWebElement emailField;

    @FindBy(xpath = "//input[contains(@name,'login[password]')]")
    private ExtendedWebElement passwordField;

    @FindBy(id = "send2")
    private ExtendedWebElement signInButton;

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    public void fillEmailField(String email) {
        emailField.type(email);
    }

    public void fillPasswordField(String password) {
        passwordField.type(password);
    }

    public void signInButtonClick() {
        signInButton.click();
    }

    public void signIn(User user) {
        fillEmailField(user.getEmail());
        fillPasswordField(user.getPassword());
        signInButtonClick();
    }
}
