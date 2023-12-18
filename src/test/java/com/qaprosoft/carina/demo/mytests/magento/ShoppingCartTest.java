package com.qaprosoft.carina.demo.mytests.magento;

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
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        CatalogSearchPage catalogSearchPage = homePage.getHeaderMenu().searchGood(defaultSearch);
        GoodPage goodPage = catalogSearchPage.clickByIndex(0);
        goodPage.chooseSize(0);
        String size = goodPage.getSizeByIndex(0);
        goodPage.chooseColor(0);
        String colorOnGoodPage = goodPage.getCurrentColor();
        goodPage.submit();
        CartPage cartPage = homePage.getHeaderMenu().goToCartPage();
        LOGGER.info(colorOnGoodPage);
        LOGGER.info(cartPage.getColor());
        Assert.assertTrue(cartPage.getColor().equals(colorOnGoodPage),"Colors are not equal");
        Assert.assertTrue(cartPage.getSize().equals(size),"Size are not equal");
    }
}