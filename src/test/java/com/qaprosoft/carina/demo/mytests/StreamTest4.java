package com.qaprosoft.carina.demo.mytests;

import java.util.Arrays;
import java.util.Collections;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.streams.StreamTasksSolver;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;

public class StreamTest4 implements IAbstractTest {

    @Test(description = "stream task4 test from the example")
    @MethodOwner(owner = "YakubT")
    public static void testGetSortedListOfElementsWithFixedLengthFromExample() {
        Assert.assertEquals(StreamTasksSolver.getSortedListOfElementsThatHaveFixedLengthEndingInADigit(2,
                Arrays.asList("8DC3", "4F", "B", "3S", "S3", "A1", "2A3G", "1B")), Arrays.asList("A1", "S3"));
    }

    @Test(description = "stream task4 test empty list")
    @MethodOwner(owner = "YakubT")
    public static void testEmptyList() {
        Assert.assertNotNull(StreamTasksSolver.getSortedListOfElementsThatHaveFixedLengthEndingInADigit(1, Collections.emptyList()));
    }

    @Test(description = "stream task4 test zero k")
    @MethodOwner(owner = "YakubT")
    public static void testZeroK() {
        Assert.assertNotNull(StreamTasksSolver.getSortedListOfElementsThatHaveFixedLengthEndingInADigit(0,
                Arrays.asList("8DC3", "4F", "B", "3S", "S3", "A1", "2A3G", "1B")));
    }
}
