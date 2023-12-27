package com.qaprosoft.carina.magento.pages.ios;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.magento.components.ios.SearchItem;
import com.qaprosoft.carina.magento.pages.common.CatalogSearchPageBase;
public class CatalogSearchPage extends CatalogSearchPageBase {

    @FindBy(xpath = "//div[contains(@class,'products wrapper')]//li[contains(@class,'product-item')]")
    private List<SearchItem> goods;

    private SearchItem searchItem;

    @FindBy(xpath = "(//a[@title='Next'])[2]")
    private ExtendedWebElement nextPageBtn;

    public CatalogSearchPage(WebDriver driver) {
        super(driver);
    }

    public GoodPage clickByIndex(int index) {
        pause(5);
        goods.get(index).click();
        return new GoodPage(getDriver());
    }

    public List<SearchItem> getGoodsOnPage() {
        return goods;
    }

    public SearchItem getSearchItemByIndex(int index) {
        return new SearchItem(getDriver(), getDriver().
                findElement(By.xpath("//li[contains(@class,'product-item')][" + String.valueOf(index + 1) + "]"))
        );
    }

    public boolean navigateToNextPage() {
        if (nextPageBtn.isElementPresent()) {
            nextPageBtn.click();
            return true;
        }
        return false;
    }
}
