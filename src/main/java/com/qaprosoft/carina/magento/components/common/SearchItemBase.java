package com.qaprosoft.carina.magento.components.common;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.magento.pages.common.GoodPageBase;

public abstract class SearchItemBase extends AbstractUIObject {

    public SearchItemBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract String getPrice();

    public abstract void addToCart();

    public abstract GoodPageBase click();
}
