package com.qaprosoft.carina.demo.gui.services.magento;

import com.qaprosoft.carina.demo.gui.models.magento.User;

public class UserService {

    public static User getDefaultUser() {
        return new User("email123456@gmail.com","Password1234");
    }
}
