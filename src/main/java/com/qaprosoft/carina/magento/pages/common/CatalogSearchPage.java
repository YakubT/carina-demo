package com.qaprosoft.carina.magento.pages.common;

import com.qaprosoft.carina.magento.pages.desktop.GoodPage;
import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.core.gui.AbstractPage;


public abstract class CatalogSearchPage extends AbstractPage {

    public CatalogSearchPage(WebDriver driver) {
        super(driver);
    }

    public abstract GoodPage clickByIndex();

}
