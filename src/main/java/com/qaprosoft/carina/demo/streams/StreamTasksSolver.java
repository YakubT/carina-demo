package com.qaprosoft.carina.demo.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StreamTasksSolver {

    public static final Logger LOGGER = LogManager.getLogger(StreamTasksSolver.class);

    public static List<String> filterNotOneSymbolStringsByFirstAndLastLetter(char c, List<String> strings) {
        return strings.stream().filter((string) -> string.charAt(0) == c
                && string.charAt(string.length() - 1) == c && string.length() > 1).collect(Collectors.toList());
    }

    public static List<Integer> getSortedListOfLengths(List<String> strings) {
        return strings.stream().map(String::length).sorted().collect(Collectors.toList());
    }

    public static List<String> getListFromFirstAndLastLettersOfStrings(List<String> strings) {
        return strings.stream().map(element -> element.charAt(0) + element.substring(element.length() - 1)).
                collect(Collectors.toList());
    }

    public static List<Integer> getSymmetricalDifferenceLastWithoutKAndEven(int k, List<Integer> integerList) {
        //res = (A/B) U (B/A)
        return new ArrayList<Integer>() {
            {
                addAll(integerList.subList(k, integerList.size()).stream().filter(elSet1 -> (integerList.stream().
                                filter(elementSet2 -> elementSet2 % 2 == 0)).noneMatch(elementSet2 -> elementSet2.equals(elSet1))).
                        collect(Collectors.toList()));
                addAll(integerList.stream().filter(elementSet2 -> elementSet2 % 2 == 0).
                        filter(elementSet2 -> integerList.subList(k, integerList.size()).
                                stream().noneMatch(elSet1 -> elSet1.equals(elementSet2))).collect(Collectors.toList()));
            }
        }.stream().sorted((el1, el2) -> Integer.compare(el1, el2) * (-1)).collect(Collectors.toList());
    }
}
