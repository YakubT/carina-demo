package com.qaprosoft.carina.demo.gui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;

public class LoginPage extends AbstractPage {

    @FindBy(xpath = "//h3[text() = 'Login successful.']")
    private ExtendedWebElement LoginSuccessfulTitle;

    @FindBy(xpath = "//p[text() = '%s']")
    private ExtendedWebElement loginMessage;

    public LoginPage(WebDriver driver) {
        super(driver);
        setPageURL("/login.php3");
    }

    public boolean isLoggedIn() {
        return LoginSuccessfulTitle.isElementPresent();
    }

    public boolean isMessagePresent(String s) {
        return loginMessage.format(s).isElementPresent();
    }
}
