package com.qaprosoft.carina.demo.mytests;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.streams.StreamTasksSolver;

public class StreamTest8 implements IAbstractTest {
    @Test(description = "Testing not empty list", dataProvider = "dataProvider")
    public void testNotEmptyList(int d, int k, List<Integer> integerList, List<Integer> expectedRes) {
        Assert.assertEquals(StreamTasksSolver.getUnionOfTwoSetsFromTask8(d, k, integerList), expectedRes);
    }

    @DataProvider(name = "dataProvider")
    public Object[][] dataProvider() {
        return new Object[][]{
                {3, 4, Arrays.asList(-10, 3, -3, 4, 55, 6), Arrays.asList(55, 6, 4)}
        };
    }

    @Test(description = "testEmptyList")
    public void testEmptyList() {
        Assert.assertNotNull(StreamTasksSolver.getUnionOfTwoSetsFromTask8(3,0, Collections.emptyList()));
    }
}
