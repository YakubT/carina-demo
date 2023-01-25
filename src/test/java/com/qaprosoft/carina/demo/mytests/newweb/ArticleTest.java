package com.qaprosoft.carina.demo.mytests.newweb;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.gui.components.FooterMenu;
import com.qaprosoft.carina.demo.gui.components.NewsItem;
import com.qaprosoft.carina.demo.gui.pages.ArticlePage;
import com.qaprosoft.carina.demo.gui.pages.HomePage;
import com.qaprosoft.carina.demo.gui.pages.NewsPage;
import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;

public class ArticleTest implements IAbstractTest {

    @Test(description = "task: verify article name")
    @MethodOwner(owner = "YakubT")
    @TestLabel(name = "feature", value = {"web", "acceptance"})
    public void testArticleName() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        FooterMenu footerMenu = homePage.getFooterMenu();
        NewsPage newsPage = footerMenu.openNewsPage();
        Assert.assertTrue(newsPage.isPageOpened(), "News page is not opened");
        NewsItem firstArticle = newsPage.getArticleByPos(0);
        String s1 = firstArticle.readTitle();
        ArticlePage articlePage = firstArticle.openArticlePage();
        Assert.assertTrue(articlePage.isPageOpened(), "Article page is not opened");
        String s2 = articlePage.getArticleName();
        Assert.assertEquals(s1, s2, "Article name from News page and on the article page are not the same");
    }
}
