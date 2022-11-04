package com.qaprosoft.carina.demo.mytests.dataprovider;

import org.testng.annotations.DataProvider;

public class DataProviderLogin {

    @DataProvider(name = "login scenarios")
    public Object[][] dataProviderMethod() {
        return new Object[][] {
                //1
                {"", "", "Заполните это поле"},
                //2
                {"testEmail", "", "Адрес электронной почты должен содержать"},
                {"testEmail@", "", "Введите часть адреса"},
                //3
                {"", "1", "Заполните это поле"},
                //4
                {"testEmail", "1", "Адрес электронной почты должен содержать"},
                {"testEmail@", "1", "Введите часть адреса"},
                //5
                {"testEmail", "1234To", "Адрес электронной почты должен содержать"},
                //6
                {"testEmail@ukr.net", "1", "Введите данные в указанном формате."},
                //7
                {"testEmail@", "1234To", "Введите часть адреса"},
        };
    }
}
