package com.qaprosoft.carina.magento.pages.common;

import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.core.gui.AbstractPage;

public abstract class CatalogSearchPageBase extends AbstractPage {

    public CatalogSearchPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract GoodPageBase clickByIndex(int index);

    public abstract boolean navigateToNextPage();
}
