package com.qaprosoft.carina.magento.pages.mobile;

import java.util.List;

import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.magento.components.common.SearchItemBase;
import com.qaprosoft.carina.magento.pages.common.CatalogSearchPageBase;
import com.qaprosoft.carina.magento.pages.common.GoodPageBase;

public class CatalogSearchPage extends CatalogSearchPageBase {

    public CatalogSearchPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public GoodPageBase clickByIndex(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean navigateToNextPage() {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<? extends SearchItemBase> getGoodsOnPage() {
        throw new UnsupportedOperationException();
    }

    @Override
    public SearchItemBase getSearchItemByIndex(int index) {
        throw new UnsupportedOperationException();
    }
}
