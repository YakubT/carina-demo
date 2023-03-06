package com.qaprosoft.carina.demo.mytests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.streams.StreamTasksSolver;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;

public class StreamTest2 implements IAbstractTest {

    @Test (description = "test from example")
    @MethodOwner(owner = "YakubT")
    public static void testGetSortedListOfLengthFromExample() {
        Assert.assertEquals(StreamTasksSolver.getSortedListOfLengths(Arrays.asList
                ("Hello", "world", "!", "Good", "morning", "!")), new ArrayList<Integer>() {
            {
                add(1);
                add(1);
                add(4);
                add(5);
                add(5);
                add(7);
            }
        });
    }

    @Test (description = "test empty list")
    @MethodOwner(owner = "YakubT")
    public static void testGetSortedListOfLengthFromEmptyList() {
        Assert.assertNotNull(StreamTasksSolver.getSortedListOfLengths(Collections.emptyList()));
    }
}
