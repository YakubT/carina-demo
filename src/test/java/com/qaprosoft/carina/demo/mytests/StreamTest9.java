package com.qaprosoft.carina.demo.mytests;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.streams.StreamTasksSolver;

public class StreamTest9 implements IAbstractTest {

    @Test(description = "Tests using dataProvider", dataProvider = "dataProvider")
    public void testNotEmptyList(List<String> input, List<String> expectedRes) {
        Assert.assertEquals(StreamTasksSolver.getSequenceOfStringWithTotalLengthTask9(input), expectedRes);
    }

    @DataProvider(name = "dataProvider")
    public Object[][] dataProvider() {
        return new Object[][]{
                {Arrays.asList("ABC", "A", "BCD", "D"), Arrays.asList("4-A", "3-B", "1-D")},
                {Arrays.asList("ABC", "A", "BCD", "B"), Arrays.asList("4-A", "4-B")}
        };
    }

    @Test(description = "testEmptyList")
    public void testEmptyList() {
        Assert.assertNotNull(StreamTasksSolver.getSequenceOfStringWithTotalLengthTask9(Collections.emptyList()));
    }
}
