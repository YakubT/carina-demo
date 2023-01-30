package com.qaprosoft.carina.demo.mytests.newweb;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.Test;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.gui.components.FooterMenu;
import com.qaprosoft.carina.demo.gui.components.NewsItem;
import com.qaprosoft.carina.demo.gui.pages.ArticlePage;
import com.qaprosoft.carina.demo.gui.pages.HomePage;
import com.qaprosoft.carina.demo.gui.pages.NewsPage;
import com.qaprosoft.carina.demo.gui.services.LoginService;
import com.qaprosoft.carina.demo.gui.services.UserService;
import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.utils.R;

public class ArticleTest implements IAbstractTest {

    private static final Logger LOGGER = LogManager.getLogger(ArticleTest.class);

    @Test(description = "task: verify article name")
    @MethodOwner(owner = "YakubT")
    @TestLabel(name = "feature", value = {"web", "acceptance"})
    public void testArticleName() {
        LoginService loginService = new LoginService(getDriver());
        HomePage homePage = loginService.login(new UserService().getUser());
        FooterMenu footerMenu = homePage.getFooterMenu();
        NewsPage newsPage = footerMenu.openNewsPage();
        Assert.assertTrue(newsPage.isPageOpened(), "News page is not opened");
        NewsItem firstArticle = newsPage.getArticleByPos(0);
        String articleNameOnTheNewsPage = firstArticle.readTitle();
        ArticlePage articlePage = firstArticle.openArticlePage();
        Assert.assertTrue(articlePage.isPageOpened(), "Article page is not opened");
        String articleNameOnTheArticlePage = articlePage.getArticleName();
        Assert.assertEquals(articleNameOnTheArticlePage, articleNameOnTheNewsPage,
                "Article name from News page and on the article page are not the same");
    }

    @Test(description = "task: verify Searching process")
    @MethodOwner(owner = "YakubT")
    public void testSearching() {
        SoftAssert softAssert = new SoftAssert();
        LoginService loginService = new LoginService(getDriver());
        HomePage homePage = loginService.login(new UserService().getUser());
        FooterMenu footerMenu = homePage.getFooterMenu();
        NewsPage newsPage = footerMenu.openNewsPage();
        softAssert.assertTrue(newsPage.isPageOpened(), "News page is not opened");
        String searchText = R.TESTDATA.get("search_text");
        newsPage.searchNews(searchText);
        softAssert.assertEquals(newsPage.getTitleText(), "Results for \"" + searchText + "\"",
                "Title text is incorrect");
        int currentPageNumber = 1;
        boolean f = true;
        while (f) {
            List<NewsItem> newsItemList = newsPage.getArticles();
            softAssert.assertTrue(newsItemList.stream().allMatch(newsItem -> newsItem.readTitle().contains(searchText)),
                    "Not all articles contains '" + searchText + "' in the page with number " +
                            currentPageNumber);
            currentPageNumber++;
            if (!newsPage.isPageButtonPresent(currentPageNumber)) {
                f = false;
            } else {
                newsPage.clickPageButton(currentPageNumber);
            }
        }
        softAssert.assertAll();
    }
}
