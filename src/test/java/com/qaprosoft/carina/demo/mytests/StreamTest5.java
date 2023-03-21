package com.qaprosoft.carina.demo.mytests;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.qaprosoft.carina.demo.streams.StreamTasksSolver;

public class StreamTest5 implements IAbstractTest {

    @Test(description = "Testing not empty list via dataProvider", dataProvider = "dataProvider")
    @MethodOwner(owner = "YakubT")
    public static void testNotEmptyLists(List<Integer> input, List<String> expectedOutput) {
        Assert.assertEquals(StreamTasksSolver.getSequenceOfStringRepresentationOfOddAndSort(input), expectedOutput);
    }

    @DataProvider(name = "dataProvider")
    public Object[][] dataProvider() {
        return new Object[][]{{Arrays.asList(1, 2, 3, 4, 5, 6), Arrays.asList("1", "3", "5")},
                {Arrays.asList(11, 2, 3, 4, 5, 6), Arrays.asList("11", "3", "5")},
                {Arrays.asList(2, 3, 11, 4, 5, 6), Arrays.asList("11", "3", "5")}
        };
    }

    @Test(description = "Test empty input")
    @MethodOwner(owner = "YakubT")
    public static void testEmptyList() {
        Assert.assertNotNull(StreamTasksSolver.getSequenceOfStringRepresentationOfOddAndSort(Collections.emptyList()));
    }
}
