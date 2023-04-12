package com.qaprosoft.carina.demo.mytests;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.streams.StreamTasksSolver;
import com.qaprosoft.carina.demo.streams.models.MaxDiscountOwner;
import com.qaprosoft.carina.demo.streams.models.Supplier;
import com.qaprosoft.carina.demo.streams.models.SupplierDiscount;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;

public class StreamTest14 implements IAbstractTest {

    @Test(description = "test not empty lists", dataProvider = "dataProvider")
    @MethodOwner(owner = "YakubT")
    public void testNotEmpty(List<Supplier> supplierList, List<SupplierDiscount> supplierDiscounts,
                             List<MaxDiscountOwner> expectedRes) {
        Assert.assertEquals(StreamTasksSolver.getMaxDiscOwners(supplierList, supplierDiscounts), expectedRes);
    }

    @DataProvider(name = "dataProvider")
    public Object[][] dataProvider() {
        return new Object[][]{
                {Arrays.asList(new Supplier(1, 1993, "Sumskaya"),
                        new Supplier(2, 1994, "Pushkinskaya"),
                        new Supplier(3, 1995, "Beketova"),
                        new Supplier(4, 1996, "Amosova"),
                        new Supplier(5, 1996, "Amosova")),
                        Arrays.asList(new SupplierDiscount(1, 9, "Posad"),
                                new SupplierDiscount(2, 9, "Posad"),
                                new SupplierDiscount(3, 10, "Colins"),
                                new SupplierDiscount(4, 10, "Colins"),
                                new SupplierDiscount(5, 10, "Denim")),
                        Arrays.asList(new MaxDiscountOwner("Colins", new Supplier(3, 1995, "Beketova")),
                                new MaxDiscountOwner("Denim", new Supplier(5, 1996, "Amosova")),
                                new MaxDiscountOwner("Posad", new Supplier(1, 1993, "Sumskaya")))}
        };
    }

    @Test(description = "empty list")
    @MethodOwner(owner = "YakubT")
    public void testEmpty() {
        Assert.assertNotNull(StreamTasksSolver.getMaxDiscOwners(Collections.emptyList(),Collections.emptyList()));
    }
}
