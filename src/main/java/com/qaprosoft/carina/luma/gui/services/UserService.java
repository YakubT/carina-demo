package com.qaprosoft.carina.luma.gui.services;

import com.qaprosoft.carina.luma.gui.models.User;
import com.zebrunner.carina.utils.R;

public class UserService {

    public static User getDefaultUser() {
        return new User(R.TESTDATA.get("luna.email"), R.TESTDATA.getDecrypted("luna.password"));
    }

    public static User getCustomUser(String email, String password) {
        return new User(email,password);
    }
}
