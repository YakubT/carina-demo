package com.qaprosoft.carina.demo.mytests.web;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.gui.pages.HomePage;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewsTest implements IAbstractTest {

    private static final Logger LOGGER = LogManager.getLogger(NewsTest.class);
    @Test(description = "verify name of articles on the first page")
    @MethodOwner(owner = "YakubT")
    public void testNameArticleOnFirstPage() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        int i = 1;
        while (homePage.isArticlePresent(i)) {
            Assert.assertTrue(homePage.isArticleHasText(i++),"Article doesn't have text");
        }
    }
}
