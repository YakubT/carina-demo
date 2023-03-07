package com.qaprosoft.carina.demo.mytests;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.streams.StreamTasksSolver;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;

public class StreamTest4 implements IAbstractTest {

    @Test(description = "stream task4 test from the example")
    @MethodOwner(owner = "YakubT")
    public static void testGetSortedListOfElementsWithFixedLengthFromExample() {
        List<String> inputList = Arrays.asList("8DC3", "4F", "B", "3S", "S3", "A1", "2A3G", "1B");
        List<String> res = StreamTasksSolver.getSortedListOfElementsThatHaveFixedLength(2, inputList);
        Assert.assertEquals(res, Arrays.asList("A1", "S3"));
    }

    @Test(description = "stream task4 test empty list")
    @MethodOwner(owner = "YakubT")
    public static void testEmptyList() {
        Assert.assertNotNull(StreamTasksSolver.getSortedListOfElementsThatHaveFixedLength(1, Collections.emptyList()));
    }

    @Test(description = "stream task4 test zero k")
    @MethodOwner(owner = "YakubT")
    public static void testZeroK() {
        List<String> inputList = Arrays.asList("8DC3", "4F", "B", "3S", "S3", "A1", "2A3G", "1B");
        Assert.assertNotNull(StreamTasksSolver.getSortedListOfElementsThatHaveFixedLength(0,inputList));
    }
}
