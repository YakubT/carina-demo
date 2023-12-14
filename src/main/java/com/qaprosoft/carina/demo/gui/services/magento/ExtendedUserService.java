package com.qaprosoft.carina.demo.gui.services.magento;

import com.qaprosoft.carina.demo.gui.models.magento.ExtendedUser;

import static com.qaprosoft.carina.demo.gui.services.magento.RandomGen.*;

public class ExtendedUserService {


    public static ExtendedUser generateRandomValidUser() {

        return new ExtendedUser(generateRandomNameOrSurname(),generateRandomNameOrSurname(),
                generateEmail(),generateValidPassword());
    }
}
