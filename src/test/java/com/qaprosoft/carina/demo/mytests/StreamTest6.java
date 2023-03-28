package com.qaprosoft.carina.demo.mytests;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.streams.StreamTasksSolver;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;

public class StreamTest6 implements IAbstractTest {

    @Test(description = "test of solver for task6 not empty both", dataProvider = "dataProvider")
    @MethodOwner(owner = "YakubT")
    public void testNotEmpty(List<Integer> inputIntegers, List<String> inputStrings, List<String> expectedOutput) {
        Assert.assertEquals(StreamTasksSolver.getSequenceOfStringsFromRuleOfTask6(inputIntegers, inputStrings),
                expectedOutput);
    }

    @DataProvider(name = "dataProvider")
    public Object[][] dataProvider() {
        return new Object[][]{
                //1
                {Arrays.asList(1, 3, 4), Arrays.asList("1aa", "aaa", "1", "a"), Arrays.
                        asList("1", "1aa", "Not Found")},
                //2
                {Arrays.asList(1, 3, 4, 5), Arrays.asList("b", "c", "12345", "d"), Arrays.asList("Not Found",
                        "Not Found", "Not Found", "12345")},
        };
    }

    @Test(description = "test empty integers list")
    @MethodOwner(owner = "YakubT")
    public void testEmptyIntegersList() {
        Assert.assertNotNull(StreamTasksSolver.getSequenceOfStringsFromRuleOfTask6(Collections.emptyList(),
                Arrays.asList("1aa", "aaa", "1", "a")));
    }

    @Test(description = "test empty string list")
    @MethodOwner(owner = "YakubT")
    public void testEmptyStringsList() {
        Assert.assertNotNull(StreamTasksSolver.getSequenceOfStringsFromRuleOfTask6(Arrays.asList(1, 3, 4, 5),
                Collections.emptyList()));
    }

    @Test(description = "test empty string list and integer list")
    @MethodOwner(owner = "YakubT")
    public void testEmptyStringsAndIntList() {
        Assert.assertNotNull(StreamTasksSolver.getSequenceOfStringsFromRuleOfTask6(Collections.emptyList(),
                Collections.emptyList()));
    }
}
