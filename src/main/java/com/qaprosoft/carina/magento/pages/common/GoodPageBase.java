package com.qaprosoft.carina.magento.pages.common;

import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.core.gui.AbstractPage;
public abstract class GoodPageBase extends AbstractPage {

    public GoodPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract String getSizeByIndex(int index);

    public abstract String getCurrentColor();

    public abstract void chooseColor(int index);

    public abstract void chooseSize(int index);

    public abstract void submit();

    public abstract String getPrice();
}
