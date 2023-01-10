package com.qaprosoft.carina.demo.gui.components;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.gui.enums.HeaderButtonLink;
import com.qaprosoft.carina.demo.gui.enums.HeaderIconLink;
import com.qaprosoft.carina.demo.gui.pages.SignUpPage;
public class HeaderMenu extends AbstractUIObject {

    @FindBy(xpath = "//li/a[text() = '%s']")
    private ExtendedWebElement headerMenuButton;

    @FindBy(xpath = "//*[@id='social-connect']//i[contains(@class,'%s')]")
    private ExtendedWebElement headerIcon;

    @FindBy(xpath = "//button[contains(@aria-label,'Navigation')]")
    private ExtendedWebElement hamburgerMenu;

    @FindBy(id = "topsearch-text")
    private ExtendedWebElement searchPanel;

    @FindBy (id = "logo")
    private ExtendedWebElement logo;

    public  HeaderMenu(WebDriver driver, SearchContext searchContext) {super(driver,searchContext);}

    public void clickHeaderMenuButton(HeaderButtonLink headerButtonLink) {
        headerMenuButton.format(headerButtonLink.getValue()).click();
    }

    public boolean isHeaderMenuButtonPresent(HeaderButtonLink headerButtonLink) {
        return headerMenuButton.format(headerButtonLink.getValue()).isElementPresent();
    }

    public boolean isHeaderIconPresent(HeaderIconLink headerIconLink) {
        return headerIcon.format(headerIconLink.getValue()).isElementPresent();
    }
    public void clickHeaderMenuIcon(HeaderIconLink headerIconLink) {
        headerIcon.format(headerIconLink.getValue()).click();
    }

    public boolean isHamburgerMenuPresent() {
      return hamburgerMenu.isElementPresent();
    }

    public boolean isSearchPanelPresent() {
        return searchPanel.isElementPresent();
    }

    public boolean isLogoPresent() {
        return logo.isElementPresent();
    }

    public SignUpPage goToSignUpPage() {
        clickHeaderMenuIcon(HeaderIconLink.SIGN_UP);
        return new SignUpPage(getDriver());
    }
}
