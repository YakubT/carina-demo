package com.qaprosoft.carina.demo.gui.pages;

import java.util.regex.Pattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;

public class PhoneFinderPage extends AbstractPage {

    @FindBy(xpath = "//button/span[text()='Brand:']")
    private ExtendedWebElement brandButton;

    @FindBy(xpath = "//ul[contains(@class,'dropdown-menu inner')]//span[text()='%s']")
    private ExtendedWebElement brandDropDownItem;

    @FindBy(xpath = "//span[@class='pf-border']//input[@value='Show']/../span")
    private ExtendedWebElement showButton;

    public PhoneFinderPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_URL);
        setPageURL("/search.php3");
    }

    public void clickBrandButton() {
        brandButton.click();
    }

    public void chooseBrandDropDownItem(String s) {
        brandDropDownItem.format(s).click();
    }

    public boolean isShowButtonPresent() {
        return showButton.isElementPresent();
    }

    public void clickShowButton() {
        showButton.click();
    }

    public String getShowButtonText() {
        return showButton.getText();
    }

    public boolean isShowButtonHasValidText() {
        String regex = "^[0-9]+ results$";
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(showButton.getText()).matches();
    }
}
