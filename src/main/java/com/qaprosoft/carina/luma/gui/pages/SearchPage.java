package com.qaprosoft.carina.luma.gui.pages;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.luma.gui.components.GoodItem;

public class SearchPage extends AbstractPage {

    @FindBy(xpath = "//div[contains(@class,'product-item-info')]")
    private List<GoodItem> goods;


    @FindBy(xpath = "//span[contains(text(),'Search results for:')]")
    private ExtendedWebElement marker;

    public SearchPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(marker);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
    }

    public boolean isContainsProductsWithName(List<String> goodsTitles) {
        return goodsTitles.stream().allMatch(title -> goods.stream()
                .anyMatch(goodItem -> goodItem.verifyText(title)));
    }
}
