package com.qaprosoft.carina.demo.mytests.magento;

import com.qaprosoft.carina.magento.pages.common.CartPageBase;
import com.qaprosoft.carina.magento.pages.common.CatalogSearchPageBase;
import com.qaprosoft.carina.magento.pages.common.GoodPageBase;
import com.qaprosoft.carina.magento.pages.common.HomePageBase;
import com.qaprosoft.carina.magento.pages.desktop.CartPage;
import com.qaprosoft.carina.magento.pages.desktop.CatalogSearchPage;
import com.qaprosoft.carina.magento.pages.desktop.GoodPage;
import com.qaprosoft.carina.magento.pages.desktop.HomePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qaprosoft.carina.core.foundation.IAbstractTest;

public class ShoppingCartTest implements IAbstractTest {

    private final String defaultSearch = "T-shirt";

    private static final Logger LOGGER = LogManager.getLogger(ShoppingCartTest.class);

    @Test(testName = "regression#2")
    public void testShoppingCartFunctionality() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        CatalogSearchPageBase catalogSearchPage = homePage.getHeaderMenu().searchGood(defaultSearch);
        GoodPageBase goodPage = catalogSearchPage.clickByIndex(0);
        goodPage.chooseSize(0);
        String size = goodPage.getSizeByIndex(0);
        goodPage.chooseColor(0);
        String colorOnGoodPage = goodPage.getCurrentColor();
        goodPage.submit();
        CartPageBase cartPage = homePage.getHeaderMenu().goToCartPage();
        LOGGER.info(colorOnGoodPage);
        LOGGER.info(cartPage.getColor());
        Assert.assertEquals(colorOnGoodPage, cartPage.getColor(), "Colors are not equal");
        Assert.assertEquals(size, cartPage.getSize(), "Size are not equal");
    }
}