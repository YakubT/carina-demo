package com.qaprosoft.carina.demo.cucumber.steps;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import com.qaprosoft.carina.core.foundation.webdriver.IDriverPool;
import com.qaprosoft.carina.demo.gui.enums.HeaderButtonLink;
import com.qaprosoft.carina.demo.gui.utils.HeaderPageFactory;
import com.qaprosoft.carina.demo.gui.pages.HomePage;
import com.qaprosoft.carina.demo.gui.pages.NewsPage;
import org.testng.Assert;

public class GSMArenaNewsSteps implements IDriverPool {

    @Given("I am on main page")
    public void iAmOnMainPage() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened());
    }

    @When("I open {string} page")
    public void openPage(String page) {
       new HeaderPageFactory().getPageByHeaderButton(HeaderButtonLink.
                valueOf(page.toUpperCase()), getDriver()).open();
    }

    @Then("page {string} should be open")
    public void isPageOpened(String page) {
        Assert.assertTrue(new HeaderPageFactory().getPageByHeaderButton(HeaderButtonLink.
                valueOf(page.toUpperCase()), getDriver()).isPageOpened());
    }

    @Then("page 'News' should contains an item")
    public void isNewsContainsAllItems() {
        Assert.assertTrue(new NewsPage(getDriver()).getArticleByPos(1).isPresent());
    }

}
