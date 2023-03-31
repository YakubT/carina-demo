package com.qaprosoft.carina.demo.streams;

import java.util.List;
import java.util.Objects;
import java.util.TreeSet;
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

    public static List<String> getSequenceOfStringRepresentationOfOddAndSort(List<Integer> numbers) {
        return numbers.stream().filter(number -> number % 2 != 0).map(Object::toString).sorted().
                collect(Collectors.toList());
    }

    public static List<Integer> getUnionOfTwoSetsFromTask8(int d, int k, List<Integer> numbers) {
        return new TreeSet<Integer>() {
            {
                addAll(numbers.subList(k, numbers.size()));
                addAll(numbers.stream().filter(el -> el > d).collect(Collectors.toList()));
            }
        }.stream().sorted((el1, el2) -> -Integer.compare(el1, el2)).collect(Collectors.toList());
    }

    public static List<String> getSequenceOfStringsFromRuleOfTask6(List<Integer> numbers, List<String> strings) {
        return numbers.stream().filter(Objects::nonNull).map(x -> strings.stream().filter(y -> y.length() == x &&
                        y.length() > 0 && Character.isDigit(y.charAt(0))).findFirst().orElse("Not Found")).
                collect(Collectors.toList());
    }

    public static List<String> getSortedListOfElementsThatHaveFixedLengthEndingInADigit(int k, List<String> strings) {
        return strings.stream().filter(string -> string.length() == k && Character.isDigit(string.
                charAt(string.length() - 1))).sorted().collect(Collectors.toList());
    }

    public static List<String> getSequenceOfStringWithTotalLengthTask9(List<String> strings) {
        return strings.stream().map(string -> strings.stream().filter(string2 ->
                        string2.charAt(0) == string.charAt(0)).mapToInt(String::length).sum() + "-" + string.charAt(0)).
                distinct().sorted((a, b) -> (Integer.parseInt(a.substring(0, a.indexOf('-')))
                        > Integer.parseInt(b.substring(0, b.indexOf('-'))) ||
                        (Integer.parseInt(a.substring(0, a.indexOf('-'))) ==
                                Integer.parseInt(b.substring(0, b.indexOf('-'))) && a.charAt(a.length() - 1) <
                                b.charAt(b.length() - 1))) ? -1 : a.equals(b) ? 0 : 1)
                .collect(Collectors.toList());
    }

    public static List<Character> getSequenceOfCharactersSortedByInitialLengthOfString(List<String> strings) {
        return strings.stream().sorted((a, b) -> -Integer.compare(a.length(), b.length())).
                map(string -> Character.toUpperCase(string.charAt(string.length() - 1))).collect(Collectors.toList());
    }
}
