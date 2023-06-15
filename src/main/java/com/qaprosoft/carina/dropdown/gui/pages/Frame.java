package com.qaprosoft.carina.dropdown.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class Frame extends AbstractPage {

    @FindBy(id = "pet-select")
    private ExtendedWebElement dropdown;

    public Frame(WebDriver driver) {
        super(driver);
    }

    public void choosePetByName(String petName) {
        dropdown.select(petName);
    }
}
