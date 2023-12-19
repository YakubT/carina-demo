package com.qaprosoft.carina.magento.pages.mobile;

import com.qaprosoft.carina.magento.components.common.SearchItemBase;
import com.qaprosoft.carina.magento.pages.common.CatalogSearchPageBase;
import com.qaprosoft.carina.magento.pages.common.GoodPageBase;

import java.util.List;

public class CatalogSearchPage extends CatalogSearchPageBase {

    @Override
    public GoodPageBase clickByIndex(int index) {
        return null;
    }

    @Override
    public boolean navigateToNextPage() {
        return false;
    }

    @Override
    public List<? extends SearchItemBase> getGoodsOnPage() {
        return null;
    }

    @Override
    public SearchItemBase getSearchItemByIndex(int index) {
        return null;
    }
}
