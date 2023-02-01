package com.qaprosoft.carina.demo.gui.components;

import java.util.List;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;

public class GlossaryParagraph extends AbstractUIObject {

    @FindBy(xpath = "/a")
    private List<ExtendedWebElement> links;

    private ExtendedWebElement title;

    public GlossaryParagraph(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public int getWidth() {
        return rootElement.getSize().width;
    }

    public List<ExtendedWebElement> getLinks() {
        return links;
    }
}
