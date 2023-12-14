package com.qaprosoft.carina.demo.gui.pages.megento;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import org.openqa.selenium.WebDriver;

public class HomePage extends AbstractMagentoPage {

    public HomePage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_URL);
        setPageAbsoluteURL("https://magento.softwaretestingboard.com/");
    }
}
