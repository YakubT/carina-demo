package com.qaprosoft.carina.demo.mytests;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.dropdown.gui.pages.DropDownPage;
import org.testng.annotations.Test;

public class SelectTest implements IAbstractTest {

    @Test
    public void test() {
        DropDownPage dropDownPage = new DropDownPage(getDriver());
        dropDownPage.open();
        dropDownPage.choosePetByName("Dog");
    }
}
