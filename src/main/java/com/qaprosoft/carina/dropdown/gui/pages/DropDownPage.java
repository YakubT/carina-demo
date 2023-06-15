package com.qaprosoft.carina.dropdown.gui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;

public class DropDownPage extends AbstractPage {

    @FindBy(xpath = "//iframe[contains(@class,'interactive')]")
    private ExtendedWebElement outputFrame;

    public DropDownPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://developer.mozilla.org/en-US/docs/Web/HTML/Element/select");
    }

    public void choosePetByName(String text) {
        getDriver().switchTo().frame(outputFrame.getElement());
        getDriver().switchTo().frame(getDriver().findElement(By.id("output-iframe")));
        Frame frame = new Frame(getDriver());
        frame.choosePetByName(text);
        getDriver().switchTo().defaultContent();
    }

}
