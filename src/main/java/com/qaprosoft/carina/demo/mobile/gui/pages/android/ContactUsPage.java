package com.qaprosoft.carina.demo.mobile.gui.pages.android;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.ContactUsPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ContactUsPageBase.class)
public class ContactUsPage extends ContactUsPageBase {

    @FindBy(xpath = "//*[@resource-id = 'form42080497']/android.view.View[1]/android.widget.EditText")
    private ExtendedWebElement emailField;

    @FindBy(xpath = "//*[@resource-id = 'form42080497']/android.view.View[2]/android.widget.EditText")
    private ExtendedWebElement nameField;

    @FindBy(xpath = "//*[@resource-id = 'form42080497']/android.view.View[3]/android.widget.EditText")
    private ExtendedWebElement questionField;

    @FindBy(xpath = "//*[@resource-id = 'form42080497']/android.view.View[4]")
    private ExtendedWebElement submitButton;

    @FindBy(xpath = "//div[contains(@class,'t-form__errorbox-text')]")
    private ExtendedWebElement errorLabel;

    @FindBy(id = "g-recaptcha-response")
    private ExtendedWebElement recaptcha;

    public ContactUsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void typeName(String name) {
        nameField.type(name);
    }

    @Override
    public void typeEmail(String email) {
        emailField.type(email);
    }

    @Override
    public void typeQuestion(String question) {
        questionField.type(question);
    }

    @Override
    public void submit() {
        submitButton.click();
    }

    @Override
    public boolean isErrorMessagePresent() {
        return errorLabel.isElementPresent();
    }

    @Override
    public boolean isRecaptchaPresent() {
        return recaptcha.isElementPresent();
    }

}
