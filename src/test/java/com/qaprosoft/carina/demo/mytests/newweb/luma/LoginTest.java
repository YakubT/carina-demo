package com.qaprosoft.carina.demo.mytests.newweb.luma;

import org.testng.annotations.Test;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.luma.gui.services.LoginService;
import com.qaprosoft.carina.luma.gui.services.UserService;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;

public class LoginTest implements IAbstractTest {

    @Test(description = "Verify that the user is successfully logged in.")
    @MethodOwner(owner = "YakubT")
    public void testLoginSuccess() {
        LoginService loginService = new LoginService(getDriver());
        loginService.login(UserService.getDefaultUser());
    }

}
