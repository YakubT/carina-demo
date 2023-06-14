package com.qaprosoft.carina.demo.mytests.newweb.luma;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.luma.gui.pages.GoodPage;
import com.qaprosoft.carina.luma.gui.pages.HomePage;
import com.qaprosoft.carina.luma.gui.components.MiniCart;
import com.qaprosoft.carina.luma.gui.services.LoginService;
import com.qaprosoft.carina.luma.gui.pages.SearchPage;
import com.qaprosoft.carina.luma.gui.services.UserService;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;

public class SearchTest implements IAbstractTest {

    private String defaultSearch = "jacket";
    private List<String> expectedGoods = List.of("Typhon Performance Fleece-lined Jacket", "Riona Full Zip Jacket");

    private SearchPage searchPage;
    private HomePage homePage;

    @BeforeMethod()
    public void beforeEach() {
        LoginService loginService = new LoginService(getDriver());
        homePage = loginService.login(UserService.getDefaultUser());
        searchPage = homePage.getSearchBox().search(defaultSearch);
    }

    @Test(description = "goals: verify search page is displayed and contains needed item")
    @MethodOwner(owner = "YakubT")
    public void testSearchContainsItem() {
        Assert.assertTrue(searchPage.isPageOpened(), "Search page is not opened");
        Assert.assertTrue(searchPage.isContainsProductsWithName(expectedGoods), "Doesn't contains all of "
                + expectedGoods);
    }

    @Test(description = "test adding good to cart")
    @MethodOwner(owner = "YakubT")
    public void testAddingToCart() {
        MiniCart miniCart = homePage.clickCartIcon();
        if (!miniCart.getItems().isEmpty()) {
            miniCart.getItems().forEach(miniCartItem -> {
                miniCartItem.deleteItem();
                homePage.clickAcceptButton();
            });
        }
        GoodPage goodPage = searchPage.getGoods().get(0).addToCart();
        double priceFromGoodPage = goodPage.getPrice();
        goodPage.chooseSize("XS");
        goodPage.chooseFirstColorFromList();
        goodPage.addToCart();
        pause(4);
        miniCart = homePage.clickCartIcon();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(priceFromGoodPage, miniCart.getTotalPrice(), "Prices in cart and in good page " +
                "is not equal");
        softAssert.assertEquals(miniCart.getItems().get(0).getQuantity(), 1, "Quantity should be 1");
        softAssert.assertAll();
    }
}
