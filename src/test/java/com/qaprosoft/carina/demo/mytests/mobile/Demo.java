package com.qaprosoft.carina.demo.mytests.mobile;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.utils.MobileContextUtils;
import org.testng.annotations.Test;

public class Demo implements IAbstractTest {

    @Test
    public void test() {
        getDriver().get("https://magento.softwaretestingboard.com/");
        MobileContextUtils mobileContextUtils = new MobileContextUtils();
        mobileContextUtils.switchMobileContext(MobileContextUtils.View.WEB);
    }
}
