package com.qaprosoft.carina.demo.mytests;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.streams.StreamTasksSolver;
import com.qaprosoft.carina.demo.streams.models.Entrant;
import com.qaprosoft.carina.demo.streams.models.YearSchoolStat;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;

public class StreamTest11 implements IAbstractTest {

    @Test(description = "testNotEmptyList", dataProvider = "dataProvider")
    @MethodOwner(owner = "YakubT")
    public void testNotEmptyList(List<Entrant> input, List<YearSchoolStat> expectedRes) {
        Assert.assertEquals(StreamTasksSolver.getDataAboutTheNumberOfDiffSchoolsInTheSameYear(input), expectedRes);
    }

    @DataProvider(name = "dataProvider")
    public Object[][] dataProvider() {
        return new Object[][]{
                {
                        Arrays.asList(
                                new Entrant(1, 1993, "Ivanov"),
                                new Entrant(2, 1992, "Petrov"),
                                new Entrant(3, 1993, "Pupkin"),
                                new Entrant(3, 2000, "Zobkin"),
                                new Entrant(3, 2000, "Zabkin")
                        ),
                        Arrays.asList(
                                new YearSchoolStat(1992, 1),
                                new YearSchoolStat(2000, 1),
                                new YearSchoolStat(1993, 2)
                        )
                }
        };
    }

    @Test(description = "test not null res of empty list")
    @MethodOwner(owner = "YakubT")
    public void testEmptyList() {
        Assert.assertNotNull(StreamTasksSolver.getDataAboutTheNumberOfDiffSchoolsInTheSameYear(Collections.emptyList()));
    }

}
