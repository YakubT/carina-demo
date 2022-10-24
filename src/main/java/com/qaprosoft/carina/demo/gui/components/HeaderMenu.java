package com.qaprosoft.carina.demo.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.gui.components.enums.HeaderButtonLink;
import com.qaprosoft.carina.demo.gui.components.enums.HeaderIconLink;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HeaderMenu extends AbstractUIObject {

    @FindBy(xpath = "//li/a[text() = %s]")
    private ExtendedWebElement headerMenuButton;

    @FindBy(xpath = "//span[text() = %s]")
    private ExtendedWebElement headerIcon;
    public  HeaderMenu(WebDriver driver, SearchContext searchContext) {super(driver,searchContext);}

    public void clickHeaderMenuButton(HeaderButtonLink headerButtonLink) {
        headerMenuButton.format(headerButtonLink.getValue()).click();
    }

    public void clickHeaderIcon(HeaderIconLink headerIconLink) {
        headerIcon.format(headerIconLink.getValue()).click();
    }
}
