package com.qaprosoft.carina.magento.pages.common;

import java.util.List;

import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.magento.components.common.SearchItemBase;


public abstract class CatalogSearchPageBase extends AbstractPage {

    public CatalogSearchPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract GoodPageBase clickByIndex(int index);

    public abstract boolean navigateToNextPage();

    public abstract List<? extends SearchItemBase> getGoodsOnPage();

    public abstract SearchItemBase getSearchItemByIndex(int index);
}