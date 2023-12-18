package com.qaprosoft.carina.demo.mytests.magento;

import com.qaprosoft.carina.magento.components.desktop.SearchItem;
import com.qaprosoft.carina.magento.pages.desktop.CatalogSearchPage;
import com.qaprosoft.carina.magento.pages.desktop.GoodPage;
import com.qaprosoft.carina.magento.pages.desktop.HomePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qaprosoft.carina.core.foundation.IAbstractTest;

import java.util.List;

public class SearchTest implements IAbstractTest {

    private final String defaultSearch = "T-shirt";
    private static final Logger LOGGER = LogManager.getLogger(SearchTest.class);

    @Test(testName = "time-consuming#1")
    public void testCheckCorrespondingOfPrices() throws Exception {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        CatalogSearchPage catalogSearchPage = homePage.getHeaderMenu().searchGood(defaultSearch);
        SoftAssert softAssert = new SoftAssert();
        int page = 1;
        do {
            LOGGER.info("Page "+page+" is opened");
            List<SearchItem> searchItems = catalogSearchPage.getGoodsOnPage();
            int size = searchItems.size();
            for (int i = 0; i < size; i++) {
                SearchItem item = catalogSearchPage.getSearchItemByIndex(i);
                String firstPrice = item.getPrice();
                GoodPage goodPage = item.click();
                LOGGER.info("Item with number on the page "+(i+1)+" is clicked");
                LOGGER.info(getDriver().getCurrentUrl());
                softAssert.assertEquals(firstPrice, goodPage.getPrice(), "error in product " + getDriver().getCurrentUrl());
                getDriver().navigate().back();
            }
            page++;

        } while (catalogSearchPage.navigateToNextPage());
        softAssert.assertAll();
    }
}