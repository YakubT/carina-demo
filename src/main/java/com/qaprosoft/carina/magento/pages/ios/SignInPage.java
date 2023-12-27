package com.qaprosoft.carina.magento.pages.ios;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.qaprosoft.carina.demo.gui.models.magento.User;
import com.qaprosoft.carina.demo.utils.MobileContextUtils;
import com.qaprosoft.carina.magento.pages.common.SignInPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = SignInPageBase.class)
public class SignInPage extends SignInPageBase {

    @FindBy(xpath = "//input[contains(@name,'login[username]')]")
    private ExtendedWebElement emailField;

    @FindBy(xpath = "//input[contains(@name,'login[password]')]")
    private ExtendedWebElement passwordField;

    @FindBy(id = "send2")
    private ExtendedWebElement signInButton;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeWindow[1]")
    private ExtendedWebElement helpNativeElement;

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void fillEmailField(String email) {
        emailField.type(email);
    }

    @Override
    public void fillPasswordField(String password) {
        passwordField.type(password);
    }

    @Override
    public void signInButtonClick() {
        signInButton.click();
    }

    @Override
    public HomePage signIn(User user) {
        fillEmailField(user.getEmail());
        fillPasswordField(user.getPassword());
        signInButtonClick();
        MobileContextUtils mobileContextUtils = new MobileContextUtils();
        mobileContextUtils.switchMobileContext(MobileContextUtils.View.NATIVE);
        helpNativeElement.click();
        return new HomePage(getDriver());
    }

}
