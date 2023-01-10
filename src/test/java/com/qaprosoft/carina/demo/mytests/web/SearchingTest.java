package com.qaprosoft.carina.demo.mytests.web;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.gui.components.HeaderMenu;
import com.qaprosoft.carina.demo.gui.pages.HomePage;
import com.qaprosoft.carina.demo.gui.pages.ResultPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchingTest implements IAbstractTest {

    @Test (description = "testing of searching process")
    public void testSearchingProcess(String inputText, boolean isResultShouldBe) {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        HeaderMenu headerMenu = homePage.getHeaderMenu();
        ResultPage resultPage = headerMenu.search(inputText);
        Assert.assertTrue(resultPage.isPageOpened(),"Result page didn't");
        Assert.assertEquals(resultPage.isResultFound(),isResultShouldBe,"Unexpected result");
    }
}
