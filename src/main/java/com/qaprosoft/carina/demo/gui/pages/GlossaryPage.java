package com.qaprosoft.carina.demo.gui.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.gui.components.GlossaryParagraph;

public class GlossaryPage extends AbstractPage {

    @FindBy(xpath = "//div[@class = 'st-text']/h3")
    private List<ExtendedWebElement> headers;

    @FindBy(xpath = "//div[@class = 'st-text']/p")
    private List<GlossaryParagraph> glossaryParagraphs;

    public GlossaryPage(WebDriver driver) {
        super(driver);
        setPageURL("/glossary.php3");
    }

    public List<ExtendedWebElement> getHeaders() {
        return headers;
    }

    public List<GlossaryParagraph> getGlossaryParagraphs() {
        return glossaryParagraphs;
    }
}
