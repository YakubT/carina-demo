package com.qaprosoft.carina.demo.gui.pages;

import java.util.List;
import java.util.regex.Pattern;

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
        for (GlossaryParagraph glossaryParagraph : glossaryParagraphs) {
            List<ExtendedWebElement> links = glossaryParagraph.getLinks();
            for (int i=1;i<links.size();i++) {
                String currentLowerCase = links.get(i).getText().toLowerCase();
                String prevLowerCase = links.get(i-1).getText().toLowerCase();
                if (currentLowerCase.compareTo(prevLowerCase)<0) {
                    LOGGER.info("Paragraph["+glossaryParagraph.getTitle()+ "] doesn't consist of sorted elements");
                    return false;
                }
            }
            LOGGER.info("Paragraph["+glossaryParagraph.getTitle()+ "] consists of sorted elements");
        }
        return true;
    }
}