package com.qaprosoft.carina.demo.mytests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.streams.StreamTasksSolver;
import com.qaprosoft.carina.demo.streams.models.Entrant;
import com.qaprosoft.carina.demo.streams.models.YearSchoolStat;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;

public class StreamTest13 implements IAbstractTest {

    @Test(description = "test not empty list", dataProvider = "dataProvider")
    @MethodOwner(owner = "YakubT")
    public void testNotEmptyList(List<Integer> years, List<Entrant> entrants,
                                 List<YearSchoolStat> expectedRes) {
        Assert.assertEquals(StreamTasksSolver.getDataAboutTheNumberOfDiffSchoolsInTheSameYearFromList(years,
                entrants), expectedRes);
    }

    @DataProvider(name = "dataProvider")
    @MethodOwner(owner = "YakubT")
    public Object[][] dataProvider() {
        return new Object[][]{
                {Arrays.asList(2001, 1999, 2000, 2002, 2003),
                        Arrays.asList(new Entrant(11, 2003, "Ivanov"),
                                new Entrant(11, 2001, "Petrov"),
                                new Entrant(11, 2001, "Pupkin"),
                                new Entrant(10, 1999, "Zobkin"),
                                new Entrant(10, 1999, "Zabkin"),
                                new Entrant(10, 1999, "Ivanov"),
                                new Entrant(10, 2000, "Petrov"),
                                new Entrant(14, 2001, "Pupkin"),
                                new Entrant(15, 2000, "Zobkin"),
                                new Entrant(10, 2000, "Ivanov"),
                                new Entrant(12, 2003, "Petrov"),
                                new Entrant(11, 2003, "Pupkin"),
                                new Entrant(10, 2003, "Zobkin")),
                        Arrays.asList(new YearSchoolStat(2002, 0),
                                new YearSchoolStat(1999, 1),
                                new YearSchoolStat(2000, 2),
                                new YearSchoolStat(2001, 2),
                                new YearSchoolStat(2003, 3))},
        };
    }

    @Test(description = "test not null result of empty list")
    @MethodOwner(owner = "YakubT")
    public void testEmptyLists() {
        Assert.assertNotNull(StreamTasksSolver.getDataAboutTheNumberOfDiffSchoolsInTheSameYearFromList(Collections.emptyList(),
                Collections.emptyList()));
    }
}
