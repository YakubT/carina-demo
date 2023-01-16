package com.qaprosoft.carina.demo.mobile.gui.pages.common;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.core.gui.AbstractPage;

public abstract class MapsPageBase extends AbstractPage {

    public MapsPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isZoomInBtnPresent();

    public abstract boolean isZoomOutBtnPresent();

    public abstract Point getZoomInLocation();

    public abstract Point getZoomOutLocation();

    public abstract int getZoomInCoordinateX();

    public abstract int getZoomInCoordinateY();

    public abstract int getZoomOutCoordinateX();

    public abstract int getZoomOutCoordinateY();

    public abstract Dimension getZoomInSize();

    public abstract Dimension getZoomOutSize();

    public abstract int getZoomInWidth();

    public abstract int getZoomInHeight();

    public abstract int getZoomOutWidth();

    public abstract int getZoomOutHeight();

    public abstract boolean isZoomInAboveZoomOutButton();

}
