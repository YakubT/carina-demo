package com.qaprosoft.carina.demo.gui.utils;

import org.apache.commons.lang3.NotImplementedException;
import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.gui.enums.HeaderButtonLink;
import com.qaprosoft.carina.demo.gui.pages.NewsPage;
import com.qaprosoft.carina.demo.gui.pages.PhoneFinderPage;

public class HeaderPageFactory {

    public AbstractPage getPageByHeaderButton(HeaderButtonLink headerButtonLink, WebDriver driver) {
        switch (headerButtonLink.getValue()) {
            case "Phone Finder":
                return new PhoneFinderPage(driver);
            case "News":
                return new NewsPage(driver);
            default:
                throw new NotImplementedException("Page objects isn't implemented");
        }
    }
}
