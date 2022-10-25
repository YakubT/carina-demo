package com.qaprosoft.carina.demo.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginForm extends AbstractUIObject {

    @FindBy (xpath = "//*[@id = \"login-popup2\"]/form/input[@id = \"email\"]")
    private ExtendedWebElement loginTextBox;

    @FindBy (xpath = "//*[@id = \"login-popup2\"]/form/input[@id = \"upass\"]")
    private ExtendedWebElement passwordTextBox;

    @FindBy (xpath = "//*[@id = \"login-popup2\"]/form/input[@id = \"nick-submit\"]")
    private ExtendedWebElement submitButton;

    public  LoginForm(WebDriver driver, SearchContext searchContext) {super(driver, searchContext);}

    public void writeToLoginTextBox(String s) {
        loginTextBox.type(s);
    }

    public void writeToPasswordTextBox(String s) {
        passwordTextBox.type(s);
    }

    public void SubmitClick() {
        if (submitButton.isClickable())
            submitButton.click();
        else
            throw new RuntimeException("Submit button is not clickable");
    }
}
