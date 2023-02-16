package com.qaprosoft.carina.demo.gui.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.qaprosoft.carina.core.gui.AbstractPage;

public class PhoneFinderResultPage extends AbstractPage {

    @FindBy(xpath = "//h1[contains(text(),'Phone finder results')]")
    private ExtendedWebElement title;

    @FindBy(xpath = "//div[@class='st-text']")
    private ExtendedWebElement resultText;
    @FindBy(xpath = "//p[text()='Note: Please report wrong Phone Finder results ']")
    private ExtendedWebElement bottomText;

    @FindBy(linkText = "click here")
    private ExtendedWebElement refineSearchBtn;

    @FindBy(xpath = "//div[contains(@class,'makers')]//span")
    private List<ExtendedWebElement> listOfPhonesNames;

    public PhoneFinderResultPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(title);
    }

    public boolean isResultTextContainsText(String text) {
        return resultText.getText().contains(text);
    }

    public boolean isRefineSearchButtonPresent() {
        return refineSearchBtn.isElementPresent();
    }

    public boolean isAllPhonesBrandCorrespondString(String brand) {
        return listOfPhonesNames.stream().allMatch((phoneName) -> phoneName.getText().contains(brand));
    }

    public boolean isBottomTextPresent() {
        return bottomText.isElementPresent();
    }

    public PhoneFinderSearchPage clickHereBtn() {
        refineSearchBtn.click();
        return new PhoneFinderSearchPage(getDriver());
    }
}
