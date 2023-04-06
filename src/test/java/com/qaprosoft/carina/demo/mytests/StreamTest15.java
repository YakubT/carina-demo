package com.qaprosoft.carina.demo.mytests;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.streams.StreamTasksSolver;
import com.qaprosoft.carina.demo.streams.models.CountryStat;
import com.qaprosoft.carina.demo.streams.models.Good;
import com.qaprosoft.carina.demo.streams.models.StorePrice;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;

public class StreamTest15 implements IAbstractTest {

    @Test(description = "test not empty list", dataProvider = "dataProvider")
    @MethodOwner(owner = "YakubT")
    public void testNotEmptyList(List<Good> goods, List<StorePrice> storePrices, List<CountryStat> expectedRes) {
        Assert.assertEquals(StreamTasksSolver.getCountryStat(goods,storePrices), expectedRes);
    }

    @DataProvider(name = "dataProvider")
    public Object[][] dataProvider() {
        return new Object[][] {
                {
                        Arrays.asList(new Good(1, "milk", "Poland"),
                                new Good(2, "milk", "Russia")),
                        Arrays.asList(new StorePrice(1, "BigShop", new BigDecimal("12.50")),
                                new StorePrice(1, "SushiBar", new BigDecimal("10.50")),
                                new StorePrice(2, "BigShop", new BigDecimal("12.50"))),
                        Arrays.asList(new CountryStat("Poland", 2, new BigDecimal("10.50")),
                                new CountryStat("Russia", 1, new BigDecimal("12.50")))
                },

                {
                        Arrays.asList(new Good(1, "milk", "Poland"),
                                new Good(2, "milk", "Russia")),
                        Arrays.asList(new StorePrice(1, "BigShop", new BigDecimal("12.50")),
                                new StorePrice(1, "SushiBar", new BigDecimal("10.50")),
                                new StorePrice(1, "BigShop", new BigDecimal("12.50"))),
                        Arrays.asList(new CountryStat("Poland", 3, new BigDecimal("10.50")),
                                new CountryStat("Russia", 0, new BigDecimal("0")))
                },
        };
    }

    @Test(description = "test empty lists")
    @MethodOwner(owner = "YakubT")
    public void testEmptyLists() {
        Assert.assertNotNull(StreamTasksSolver.getCountryStat(Collections.emptyList(),Collections.emptyList()));
    }
}
