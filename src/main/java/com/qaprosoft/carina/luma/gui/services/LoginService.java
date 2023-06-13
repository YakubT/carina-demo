package com.qaprosoft.carina.luma.gui.services;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.qaprosoft.carina.luma.gui.models.User;
import com.qaprosoft.carina.luma.gui.pages.LoginPage;
import com.qaprosoft.carina.luma.gui.pages.HomePage;

public class LoginService {

    private WebDriver driver;

    public LoginService(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage login(User user) {
        HomePage homePage = new HomePage(driver);
        homePage.open();
        LoginPage loginPage = homePage.loginButtonClick();
        loginPage.login(UserService.getDefaultUser());
        Assert.assertTrue(homePage.isPageOpened(),"test failed");
        return homePage;
    }
}
