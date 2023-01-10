package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

public class ResultPage extends AbstractPage {

    @FindBy(xpath = "//h3[contains(text(),'we found no results')]")
    private ExtendedWebElement noResultTitle;
    public ResultPage(WebDriver driver) {
        super(driver);
        setPageURL("/res.php3");
    }

    public boolean isResultFound() {
        return noResultTitle.isElementNotPresent(1000);
    }
}
