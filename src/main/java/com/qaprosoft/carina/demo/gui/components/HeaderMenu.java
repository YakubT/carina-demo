package com.qaprosoft.carina.demo.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.gui.components.enums.HeaderLink;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HeaderMenu extends AbstractUIObject {

    @FindBy(xpath = "//li/a[text()= %s]")
    private ExtendedWebElement headerMenuButton;
    public  HeaderMenu(WebDriver driver, SearchContext searchContext) {super(driver,searchContext);}

    public void clickHeaderMenuButton(HeaderLink headerLink) {
        headerMenuButton.format(headerLink.getValue()).click();
    }
}
