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

    public boolean isGlossaryParagraphSizeMatchesListSize() {
        int widthEtalon = headers.get(0).getSize().width;
        return glossaryParagraphs.stream().allMatch(glossaryParagraph -> glossaryParagraph.getWidth() == widthEtalon) &&
                headers.stream().allMatch(header -> header.getSize().width == widthEtalon);
    }

    public boolean verifyGlossaryParagraphMatchesText() {
        for (int i = 0; i < headers.size(); i++) {
            String regex = "^[" + headers.get(i).getText() + "]";
            Pattern pattern = Pattern.compile(regex);
            List<ExtendedWebElement> paragraphLinks = glossaryParagraphs.get(i).getLinks();
            for (ExtendedWebElement link:paragraphLinks) {
                if (!pattern.matcher(link.getText()).matches()) {
                    LOGGER.error("Glossary paragraph header: [" + headers.get(i).getText()
                            + "] does not matches first number or letter [" + link.getText().charAt(0) + "]");
                    return false;
                }
            }
            LOGGER.info("Glossary paragraph header: [" + headers.get(i).getText() + "] matches first " +
                    "letter or number");
        }
        return true;
    }
}
