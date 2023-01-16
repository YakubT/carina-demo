package com.qaprosoft.carina.demo.mobile.gui.pages.android;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.MapsPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = MapsPageBase.class)
public class MapsPage extends MapsPageBase {

    @FindBy (xpath = "//android.widget.TextView[contains(@text,'Map')]")
    private ExtendedWebElement title;

    @FindBy(xpath = "//android.widget.ImageView[@content-desc='Zoom in']")
    private ExtendedWebElement zoomInBtn;

    @FindBy(xpath = "//android.widget.ImageView[@content-desc='Zoom out']")
    private ExtendedWebElement zoomOutBtn;

    public MapsPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(title);
    }

    @Override
    public boolean isZoomInBtnPresent() {
        return zoomInBtn.isElementPresent();
    }

    @Override
    public boolean isZoomOutBtnPresent() {
        return zoomOutBtn.isElementPresent();
    }

    @Override
    public Point getZoomInLocation() {
        return zoomInBtn.getLocation();
    }

    @Override
    public Point getZoomOutLocation() {
        return zoomOutBtn.getLocation();
    }

    @Override
    public int getZoomInCoordinateX() {
        return getZoomInLocation().x;
    }

    @Override
    public int getZoomInCoordinateY() {
        return getZoomInLocation().y;
    }

    @Override
    public int getZoomOutCoordinateX() {
        return getZoomOutLocation().x;
    }

    @Override
    public int getZoomOutCoordinateY() {
        return getZoomOutLocation().y;
    }
    @Override
    public Dimension getZoomInSize() {
        return zoomInBtn.getSize();
    }

    @Override
    public Dimension getZoomOutSize() {
        return zoomOutBtn.getSize();
    }

    @Override
    public int getZoomInWidth() {
        return getZoomInSize().width;
    }

    @Override
    public int getZoomInHeight() {
        return getZoomInSize().height;
    }

    @Override
    public int getZoomOutWidth() {
        return getZoomOutSize().width;
    }

    @Override
    public int getZoomOutHeight() {
        return getZoomOutSize().height;
    }

    @Override
    public boolean isZoomInAboveZoomOutButton() {
        return getZoomInCoordinateY()<getZoomOutCoordinateY();
    }
}
