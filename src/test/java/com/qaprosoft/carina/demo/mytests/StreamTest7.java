package com.qaprosoft.carina.demo.mytests;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.qaprosoft.carina.demo.streams.StreamTasksSolver;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qaprosoft.carina.core.foundation.IAbstractTest;

public class StreamTest7 implements IAbstractTest {

    @Test(description = "testing standart situations using dataProvider", dataProvider = "dataProvider")
    @MethodOwner(owner = "YakubT")
    public void testViaDataProvider(int k, List<Integer> integerList, List<Integer> expected) {
        Assert.assertEquals(StreamTasksSolver.getSymmetricalDifferenceLastWithoutKAndEven(k, integerList), expected);
    }

    @DataProvider(name = "dataProvider")
    public Object[][] dataProvider() {
        return new Object[][]{
                {5, Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9), Arrays.asList(9, 7, 4, 2)}
        };
    }

    @Test(description = "testing empty integerList")
    @MethodOwner(owner = "YakubT")
    public void testNotNull() {
        Assert.assertNotNull(StreamTasksSolver.getSymmetricalDifferenceLastWithoutKAndEven
                (0, Collections.emptyList()));
    }
}
