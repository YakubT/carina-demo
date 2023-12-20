package com.qaprosoft.carina.magento.pages.common;

import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.magento.components.common.HeaderMenuBase;

public abstract class HomePageBase extends AbstractPage {

    public HomePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract HeaderMenuBase getHeaderMenu();
}
