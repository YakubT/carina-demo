package com.qaprosoft.carina.magento.pages.desktop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.qaprosoft.carina.demo.gui.components.magento.SignUpForm;

public class SignUpPage extends AbstractMagentoPage {

    @FindBy(xpath = "//div[contains(@class,'columns')]")
    private SignUpForm signUpForm;

    @FindBy(xpath = "//div[contains(text(),'There is already an account')]")
    private ExtendedWebElement containerErrorMessage;

    @FindBy(partialLinkText = "Create an Account")
    private ExtendedWebElement marker;

    public SignUpPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(marker);
    }

    public SignUpForm getSignUpForm() {
        return signUpForm;
    }

    public boolean isErrorMessageDisplayed() {
        return containerErrorMessage.isElementPresent();
    }
}
