package com.qaprosoft.carina.demo.gui.pages.megento;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;

public class AccountPage extends AbstractMagentoPage {

    @FindBy(xpath = "//span[contains(text(),'My Account')]")
    private ExtendedWebElement marker;

    public AccountPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(marker);
    }
}
