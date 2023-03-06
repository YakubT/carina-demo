package com.qaprosoft.carina.demo.mytests;

import java.util.Arrays;
import java.util.Collections;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.qaprosoft.carina.demo.streams.StreamTasksSolver;

public class StreamTest3 implements IAbstractTest {

    @Test(description = "test from example")
    @MethodOwner(owner = "YakubT")
    public static void testGetListFromFirstAndLastLettersOfStringsFromExample() {
        Assert.assertEquals(StreamTasksSolver.getListFromFirstAndLastLettersOfStrings
                (Arrays.asList("asd", "a", "basdw")), Arrays.asList("ad", "aa", "bw"));
    }

    @Test(description = "test empty list")
    @MethodOwner(owner = "YakubT")
    public static void testFromEmptyList() {
        Assert.assertNotNull(StreamTasksSolver.getSortedListOfLengths(Collections.emptyList()));
    }
}
