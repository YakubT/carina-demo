package com.qaprosoft.carina.demo.mytests.newweb;

import java.util.List;

import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.gui.components.GlossaryParagraph;
import com.qaprosoft.carina.demo.gui.pages.GlossaryPage;
import com.qaprosoft.carina.demo.gui.pages.HomePage;

public class GlossaryTest implements IAbstractTest {

    private boolean isDigit(char c) {
        return '0' <= c && c <= '9';
    }

    @Test(description = "Verify Glossary paragraph header and text by first letter")
    @MethodOwner(owner = "YakubT")
    public void testHeaderAndText() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        GlossaryPage glossaryPage = homePage.getFooterMenu().openGlossaryPage();
        Assert.assertTrue(glossaryPage.isPageOpened(), "Glossary is not opened");
        SoftAssert softAssert = new SoftAssert();
        //checking headers size
        List<ExtendedWebElement> headerList = glossaryPage.getHeaders();
        boolean isSizeOfHeadersEquals = headerList.stream().allMatch((header) -> header.getSize().equals(headerList.get(0).
                getSize()));
        softAssert.assertTrue(isSizeOfHeadersEquals, "Headers have different sizes");
        //checking paragraphs size
        List<GlossaryParagraph> paragraphList = glossaryPage.getGlossaryParagraphs();
        boolean isWidthOfParagraphEquals = paragraphList.stream().allMatch((paragraph) -> paragraph.getWidth() ==
                paragraphList.get(0).getWidth());
        softAssert.assertTrue(isWidthOfParagraphEquals, "Paragraphs widths are different");
        //checking text
        for (int i = 0; i < headerList.size(); i++) {
            boolean isCorrectStartingSymbol;
            if (headerList.get(i).getText().contains("0")) {
                isCorrectStartingSymbol = paragraphList.get(i).getLinks().stream().allMatch((link) -> isDigit(link.getText().
                        charAt(0)));
                softAssert.assertTrue(isCorrectStartingSymbol, "Some words don't begin with the digit");
            } else {
                char character = headerList.get(i).getText().charAt(0);
                isCorrectStartingSymbol = paragraphList.get(i).getLinks().stream().allMatch((link) -> link.getText().
                        charAt(0) == character);
                softAssert.assertTrue(isCorrectStartingSymbol, "Some words don't begin with " + character);
            }
        }
        softAssert.assertAll();
    }
}
