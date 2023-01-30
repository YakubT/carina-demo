package com.qaprosoft.carina.demo.gui.services;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.qaprosoft.carina.demo.gui.components.HeaderMenu;
import com.qaprosoft.carina.demo.gui.components.LoginForm;
import com.qaprosoft.carina.demo.gui.enums.HeaderIconLink;
import com.qaprosoft.carina.demo.gui.models.User;
import com.qaprosoft.carina.demo.gui.pages.HomePage;

public class LoginService {

    private final WebDriver driver;

    public LoginService(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage login(User user) {
        HomePage homePage = new HomePage(driver);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        HeaderMenu headerMenu = homePage.getHeaderMenu();
        headerMenu.clickHeaderMenuIcon(HeaderIconLink.LOG_IN);
        LoginForm loginForm = homePage.getLoginForm();
        loginForm.login(user);
        Assert.assertTrue(homePage.isPageOpened(), "User wasn't login on website");
        return homePage;
    }
}
