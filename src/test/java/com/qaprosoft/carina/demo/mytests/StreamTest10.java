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

public class StreamTest10 implements IAbstractTest {

    @Test(description = "test not empty list", dataProvider = "dataProvider")
    @MethodOwner(owner = "YakubT")
    public void testNotEmptyList(List<String> input, List<Character> expectedRes) {
        Assert.assertEquals(StreamTasksSolver.getSequenceOfCharactersSortedByInitialLengthOfString(input),
                expectedRes);
    }

    @DataProvider(name = "dataProvider")
    @MethodOwner(owner = "YakubT")
    public Object[][] dataProvider() {
        return new Object[][]{
                {Arrays.asList("asnsbiu", "asdsad", "asnsb", "asdf", "asdfb", "as", "a", "aop"),
                        Arrays.asList('U', 'D', 'B', 'B', 'F', 'P', 'S', 'A')},
        };
    }

    @Test(description = "test not null result of empty list")
    @MethodOwner(owner = "YakubT")
    public void testEmptyList() {
        Assert.assertNotNull(StreamTasksSolver.getSequenceOfCharactersSortedByInitialLengthOfString(Collections.
                emptyList()));
    }
}
