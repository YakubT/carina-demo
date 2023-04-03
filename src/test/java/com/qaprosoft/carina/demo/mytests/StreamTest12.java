package com.qaprosoft.carina.demo.mytests;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.streams.StreamTasksSolver;
import com.qaprosoft.carina.demo.streams.models.NumberPair;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;

public class StreamTest12 implements IAbstractTest {

    @Test(description = "test not empty list", dataProvider = "dataProvider")
    @MethodOwner(owner = "YakubT")
    public void testNotEmptyList(List<Integer> integerList1, List<Integer> integerList2,
                                 List<Character> expectedRes) {
        Assert.assertEquals(StreamTasksSolver.getNumberPairsThatEndsOnTheSameDigit(integerList1, integerList2),
                expectedRes);
    }

    @DataProvider(name = "dataProvider")
    @MethodOwner(owner = "YakubT")
    public Object[][] dataProvider() {
        return new Object[][]{
                {Arrays.asList(1, 2, 33, 44), Arrays.asList(11, 22, 13), Arrays.asList(new NumberPair(1, 11),
                        new NumberPair(2, 22), new NumberPair(33, 13))},
        };
    }

    @Test(description = "test not null result of empty list")
    @MethodOwner(owner = "YakubT")
    public void testEmptyLists() {
        Assert.assertNotNull(StreamTasksSolver.getNumberPairsThatEndsOnTheSameDigit(Collections.emptyList(),
                Collections.emptyList()));
    }
}
