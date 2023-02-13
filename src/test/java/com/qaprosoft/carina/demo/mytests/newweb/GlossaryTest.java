package com.qaprosoft.carina.demo.mytests.newweb;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.gui.pages.GlossaryPage;
import com.qaprosoft.carina.demo.gui.pages.HomePage;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;

public class GlossaryTest implements IAbstractTest {

    @Test(description = "Verify Glossary paragraph header and text by first letter")
    @MethodOwner(owner = "YakubT")
    public void testHeaderAndText() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        GlossaryPage glossaryPage = homePage.getFooterMenu().openGlossaryPage();
        Assert.assertTrue(glossaryPage.isPageOpened(), "Glossary is not opened");
        Assert.assertTrue(glossaryPage.isGlossaryParagraphSizeMatchesListSize(), "Paragraph doesn't match list size");
        Assert.assertTrue(glossaryPage.verifyGlossaryParagraphMatchesText(), "Titles are not sorted by alphabet");
    }
    
    @Test(description = "Verify Glossary paragraph text by alphabet")
    @MethodOwner(owner = "YakubT")
    public void testIsSortedInParagraph() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        GlossaryPage glossaryPage = homePage.getFooterMenu().openGlossaryPage();
        Assert.assertTrue(glossaryPage.isPageOpened(), "Glossary is not opened");
        Assert.assertTrue(glossaryPage.isParagraphsTextSorted(),"Paragraph text is not sorted");
    }
}
