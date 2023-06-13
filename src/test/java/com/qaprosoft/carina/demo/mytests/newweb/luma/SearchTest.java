package com.qaprosoft.carina.demo.mytests.newweb.luma;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.luma.gui.pages.HomePage;
import com.qaprosoft.carina.luma.gui.services.LoginService;
import com.qaprosoft.carina.luma.gui.pages.SearchPage;
import com.qaprosoft.carina.luma.gui.services.UserService;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;

public class SearchTest implements IAbstractTest {

    private String defaultSearch = "jacket";
    private List<String> expectedGoods = List.of("Typhon Performance Fleece-lined Jacket","Riona Full Zip Jacket");

    SearchPage searchPage;

    @BeforeMethod()
    public void beforeEach() {
        LoginService loginService = new LoginService(getDriver());
        HomePage homePage = loginService.login(UserService.getDefaultUser());
        searchPage = homePage.getSearchBox().search(defaultSearch);
    }

    @Test(description = "goals: verify search page is displayed and contains needed item")
    @MethodOwner(owner = "YakubT")
    public void testSearchContainsItem() {
        Assert.assertTrue(searchPage.isPageOpened(),"Search page is not opened");
        Assert.assertTrue(searchPage.isContainsProductsWithName(expectedGoods),"Doesn't contains all of "
                +expectedGoods);
    }

    @Test(description = "test adding good to cart")
    @MethodOwner(owner = "YakubT")
    public void testAddingToCart() {
        searchPage.getGoods().get(0).addToCart();
    }
}
