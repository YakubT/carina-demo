package com.qaprosoft.carina.luma.gui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.luma.gui.models.User;

public class LoginPage extends AbstractPage {

    @FindBy(id = "email")
    private ExtendedWebElement loginInput;

    @FindBy(id = "pass")
    private ExtendedWebElement passInput;

    @FindBy(id = "send2")
    private ExtendedWebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void setTextLoginInput(String text) {
        loginInput.type(text);
    }

    public void setTextPasswordInput(String text) {
        passInput.type(text);
    }

    public void clickLoginButton() {
        loginButton.click();
        setUiLoadedMarker(loginButton);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
    }

    public HomePage login(User user) {
        setTextLoginInput(user.getEmail());
        setTextPasswordInput(user.getPassword());
        clickLoginButton();
        return new HomePage(getDriver());
    }
}
