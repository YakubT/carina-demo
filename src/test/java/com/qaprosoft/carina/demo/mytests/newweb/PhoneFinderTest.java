package com.qaprosoft.carina.demo.mytests.newweb;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.dataprovider.annotations.CsvDataSourceParameters;
import com.qaprosoft.carina.demo.gui.components.HeaderMenu;
import com.qaprosoft.carina.demo.gui.enums.HeaderButtonLink;
import com.qaprosoft.carina.demo.gui.pages.HomePage;
import com.qaprosoft.carina.demo.gui.pages.PhoneFinderSearchPage;
import com.qaprosoft.carina.demo.gui.pages.PhoneFinderResultPage;

public class PhoneFinderTest implements IAbstractTest {

    @Test(dataProvider = "DataProvider")
    @CsvDataSourceParameters(path = "csv/search_model_brand.csv", dsUid = "TUID")
    public void testPhoneFindProcess(HashMap<String, String> args) {
        String brand = args.get("brandName");
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        HeaderMenu headerMenu = homePage.getHeaderMenu();
        headerMenu.clickBurgerMenu();
        //1
        Assert.assertTrue(headerMenu.isHeaderMenuButtonPresent(HeaderButtonLink.PHONE_FINDER),
                "Phone finder doesn't exists");
        PhoneFinderSearchPage phoneFinderPageSearch = (PhoneFinderSearchPage) headerMenu.clickHeaderMenuButton(HeaderButtonLink.PHONE_FINDER);
        //2
        Assert.assertTrue(phoneFinderPageSearch.isPageOpened(), "PhoneFinder search page isn't opened");
        phoneFinderPageSearch.clickBrandButton();
        phoneFinderPageSearch.chooseBrandDropDownItem(brand);
        //3.1
        Assert.assertTrue(phoneFinderPageSearch.isShowButtonPresent(), "Show button isn't present");
        SoftAssert softAssert = new SoftAssert();
        //3.2
        softAssert.assertTrue(phoneFinderPageSearch.isShowButtonHasValidText(), "Show btn should have text = 'x' results'");
        PhoneFinderResultPage phoneFinderResultPage = phoneFinderPageSearch.clickShowButton();
        //4
        Assert.assertTrue(phoneFinderResultPage.isPageOpened(), "Phone finder results isn't opened");
        //4.1
        softAssert.assertTrue(phoneFinderResultPage.isResultTextContainsText("Your search returned"), "Text isn't" +
                " presented 'Your search returned x results.'");
        //4.2
        softAssert.assertTrue(phoneFinderResultPage.isResultTextContainsText(
                "To refine your search"), "Text with words: Your search returned click here. isn't presented");
        //4.3
        Assert.assertTrue(phoneFinderResultPage.isRefineSearchButtonPresent(), "Refine search btn isn't presented");
        //4.4
        Assert.assertTrue(phoneFinderResultPage.isAllPhonesBrandCorrespondString(brand), "Not all phones has brand " + brand);
        //4.5
        softAssert.assertTrue(phoneFinderResultPage.isBottomTextPresent(), "Bottom text isn't present");
        phoneFinderPageSearch = phoneFinderResultPage.clickHereBtn();
        //5
        Assert.assertTrue(phoneFinderPageSearch.isPageOpened(), "Search page isn't opened");
        softAssert.assertAll();
    }
}
