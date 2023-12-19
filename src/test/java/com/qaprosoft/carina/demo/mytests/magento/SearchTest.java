package com.qaprosoft.carina.demo.mytests.magento;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.magento.pages.common.HomePageBase;
import com.qaprosoft.carina.magento.components.common.SearchItemBase;
import com.qaprosoft.carina.magento.pages.common.CatalogSearchPageBase;
import com.qaprosoft.carina.magento.pages.common.GoodPageBase;

public class SearchTest implements IAbstractTest {

    private final String defaultSearch = "T-shirt";
    private static final Logger LOGGER = LogManager.getLogger(SearchTest.class);

    @Test(testName = "time-consuming#1")
    public void testCheckCorrespondingOfPrices() throws Exception {
        HomePageBase homePage = initPage(getDriver(),HomePageBase.class);
        homePage.open();
        CatalogSearchPageBase catalogSearchPage = homePage.getHeaderMenu().searchGood(defaultSearch);
        SoftAssert softAssert = new SoftAssert();
        int page = 1;
        do {
            LOGGER.info("Page "+page+" is opened");
            List<? extends SearchItemBase> searchItems = catalogSearchPage.getGoodsOnPage();
            int size = searchItems.size();
            for (int i = 0; i < size; i++) {
                SearchItemBase item = catalogSearchPage.getSearchItemByIndex(i);
                String firstPrice = item.getPrice();
                GoodPageBase goodPage = item.click();
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