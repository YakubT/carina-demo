package com.qaprosoft.carina.demo.mytests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.qaprosoft.carina.demo.streams.StreamTasksSolver;

public class StreamsTest1 {

    @Test(description = "stream task1 general test")
    @MethodOwner(owner = "YakubT")
    public static void testFilterByFirstAndLastCharacterFromExample() {
        List<String> resultOfAlgorithm = StreamTasksSolver.filterNotOneSymbolStringsByFirstAndLastLetter
                ('a', new ArrayList<String>() {
            {
                add("Hello");
                add("qwerty");
                add("asda");
                add("asdfa");
                add("as");
                add("a");
            }
        });
        Assert.assertEquals(resultOfAlgorithm, new ArrayList<String>() {
            {
                add("asda");
                add("asdfa");
            }
        });
    }

    @Test(description = "stream task1 checking empty list")
    @MethodOwner(owner = "YakubT")
    public static void testFilterByFirstAndLastCharacterIsNotNull() {
        List<String> list = Collections.emptyList();
        Assert.assertNotNull(StreamTasksSolver.filterNotOneSymbolStringsByFirstAndLastLetter('a', list));
    }
}
