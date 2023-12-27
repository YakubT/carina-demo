package com.qaprosoft.carina.demo.mytests.mobile;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;

public class NativeChrome extends AbstractPage {

    @FindBy(id = "com.android.chrome:id/tab_switcher_button")
    private ExtendedWebElement tabBtn;

    @FindBy(id = "com.android.chrome:id/new_tab_view_button")
    private ExtendedWebElement plusBtn;

    public NativeChrome(WebDriver driver) {
        super(driver);
    }

    public void openNewTab() {
        tabBtn.click();
        plusBtn.click();
    }
}
