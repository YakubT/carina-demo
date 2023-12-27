package com.qaprosoft.carina.magento.components.ios;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.magento.pages.ios.GoodPage;
import com.qaprosoft.carina.magento.pages.common.GoodPageBase;

public class SearchItem extends com.qaprosoft.carina.magento.components.desktop.SearchItem {

    public SearchItem(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public GoodPageBase click() {
        anchor.click();
        return new GoodPage(getDriver());
    }
}
