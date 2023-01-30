package com.qaprosoft.carina.demo.gui.services;

import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.demo.gui.components.LoginForm;
import com.qaprosoft.carina.demo.gui.enums.HeaderIconLink;
import com.qaprosoft.carina.demo.gui.pages.HomePage;

public class LoginService {

    private final LoginForm loginForm;

    private final UserService userService = new UserService();

    public LoginService(WebDriver driver) {
        HomePage homePage = new HomePage(driver);
        homePage.getHeaderMenu().clickHeaderMenuIcon(HeaderIconLink.LOG_IN);
        loginForm = homePage.getLoginForm();
    }

    public void login() {
        loginForm.login(userService.getUser());
    }

    public void loginWithInvalidEmail() {
        loginForm.login(userService.getUserWithInvalidEmail());
    }

    public void loginWithInvalidPassword() {
        loginForm.login(userService.getUserWithInvalidPassword());
    }
}
