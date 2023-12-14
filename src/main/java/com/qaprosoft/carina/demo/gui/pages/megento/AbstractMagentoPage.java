package com.qaprosoft.carina.demo.gui.pages.megento;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.gui.components.magento.HeaderMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;



public class AbstractMagentoPage extends AbstractPage {
    @FindBy(xpath = "//header[contains(@class,'page')]")
    private HeaderMenu headerMenu;

    public AbstractMagentoPage(WebDriver driver) {
        super(driver);
    }

    public HeaderMenu getHeaderMenu() {
        return headerMenu;
    }
}
