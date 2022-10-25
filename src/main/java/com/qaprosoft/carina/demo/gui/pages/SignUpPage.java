package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SignUpPage extends AbstractPage {

    @FindBy(id = "uname")
    private ExtendedWebElement nicknameTextBox;

    @FindBy(xpath = "//*[@id = 'frmOpin']/fieldset/input[@id = \"email\"]")
    private ExtendedWebElement emailTextBox;

    @FindBy(xpath = "//*[@id = 'frmOpin']/input[@id = \"upass\"]")
    private ExtendedWebElement passwordTextBox;

    @FindBy(xpath = "//label[@for = \"%s\"]")
    private ExtendedWebElement swiper;

    @FindBy(xpath = "//div[@id= \"ucsubmit-f\"]/input[@id= \"nick-submit\"]")
    private ExtendedWebElement submitButton;

    @FindBy( xpath = "//[text() = 'Your account was created. ']")
    ExtendedWebElement accountWasCreatedTitle;
    public SignUpPage(WebDriver driver) {
        super(driver);
        setPageURL("/register.php3");
    }

    public void writeToNicknameTextBox(String s) {
        nicknameTextBox.type(s);
    }

    public void writeToEmailTextBox(String s) {
        emailTextBox.type(s);
    }

    public void writeToPasswordTextBox(String s) {
        passwordTextBox.type(s);
    }

    public void confirmEverything() {
        swiper.format("iagree1").click();
        swiper.format("iagree2").click();
    }

    public void clickSubmitButton() {
        if (submitButton.isClickable())
            submitButton.click();
        else
            throw new RuntimeException("Submit button is not clickable");
    }

    public boolean isRegistered() {
        return accountWasCreatedTitle.isElementPresent();
    }
}
