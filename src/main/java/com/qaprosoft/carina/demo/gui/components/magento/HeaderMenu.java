package com.qaprosoft.carina.demo.gui.components.magento;

import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.gui.pages.megento.CartPage;
import com.qaprosoft.carina.demo.gui.pages.megento.CatalogSearchPage;
import com.qaprosoft.carina.demo.gui.pages.megento.SignInPage;
import com.qaprosoft.carina.demo.gui.pages.megento.SignUpPage;
public class HeaderMenu extends AbstractUIObject {

    @FindBy(xpath = "//a[contains(text(),'Sign In')]")
    private ExtendedWebElement signInButton;

    @FindBy(linkText = "Create an Account")
    private ExtendedWebElement createAccountButton;

    @FindBy(xpath = ".//a[contains(text(),'Sign Out')]")
    private ExtendedWebElement signOutButton;

    @FindBy(xpath = ".//button[contains(@class,'switch')]")
    private ExtendedWebElement buttonDropDownList;

    @FindBy(id = "search")
    private ExtendedWebElement searchField;

    @FindBy(xpath = "//a[contains(@class,'cart')]")
    private ExtendedWebElement cartIcon;

    @FindBy(xpath = "//button[contains(@id,'checkout')]")
    private ExtendedWebElement goToCheckoutBtn;

    @FindBy(xpath = "//a[contains(@class,'viewcart')]")
    private ExtendedWebElement viewEditCartBtn;

    @FindBy(xpath = "/span[contains(text(),'My Cart')]//..//span[contains(@class,'counter qty')]")
    private ExtendedWebElement counter;


    public HeaderMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public SignInPage clickSignInButton() {
        signInButton.click();
        return new SignInPage(getDriver());
    }

    public SignUpPage clickSignUpPage() {
        createAccountButton.click();
        return new SignUpPage(getDriver());
    }

    public void signOut() {
        buttonDropDownList.click();
        signOutButton.click();
    }

    public CatalogSearchPage searchGood(String name) {
        searchField.type(name + Keys.RETURN);
        return new CatalogSearchPage(getDriver());
    }

    public void goToCheckOut() {
        cartIcon.click();
        goToCheckoutBtn.click();
    }

    public CartPage goToCartPage() {
        counter.isElementPresent();
        cartIcon.click();
        viewEditCartBtn.click();
        return new CartPage(getDriver());
    }
}
