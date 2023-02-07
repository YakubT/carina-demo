package com.qaprosoft.carina.demo.gui.pages;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.gui.components.GlossaryParagraph;

public class GlossaryPage extends AbstractPage {

    private Logger LOGGER = LogManager.getLogger(GlossaryPage.class);

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

    public boolean isParagraphsTextSorted() {
        for (int i = 0; i < glossaryParagraphs.size(); i++) {
            GlossaryParagraph glossaryParagraph = glossaryParagraphs.get(i);
            List<ExtendedWebElement> links = glossaryParagraph.getLinks();
            for (int j = 1; j < links.size(); j++) {
                String currentLowerCase = links.get(j).getText().toLowerCase();
                String prevLowerCase = links.get(j - 1).getText().toLowerCase();
                if (currentLowerCase.compareTo(prevLowerCase) < 0) {
                    LOGGER.info("Paragraph[" + headers.get(i).getText() + "] doesn't consist of sorted elements");
                    return false;
                }
            }
            LOGGER.info("Paragraph[" + headers.get(i).getText() + "] consists of sorted elements");
        }
        return true;
    }
}