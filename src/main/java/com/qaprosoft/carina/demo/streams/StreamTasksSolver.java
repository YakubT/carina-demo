package com.qaprosoft.carina.demo.streams;

import java.util.List;
import java.util.Objects;
import java.util.TreeSet;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qaprosoft.carina.demo.streams.models.Entrant;
import com.qaprosoft.carina.demo.streams.models.NumberPair;
import com.qaprosoft.carina.demo.streams.models.YearSchoolStat;

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

    public static List<NumberPair> getNumberPairsThatEndsOnTheSameDigit(List<Integer> integerList1, List<Integer> integerList2) {
        return integerList1.stream().map(integer1 -> integerList2.stream().filter(
                                integer2 -> integer2 % 10 == integer1 % 10).map(el -> new NumberPair(integer1, el)).
                        collect(Collectors.toList())).flatMap(List::stream)
                .sorted((numbPair1, numberPair2) ->
                        numbPair1.getFirstInt() != numberPair2.getFirstInt() ? Integer.compare(
                                numbPair1.getFirstInt(), numberPair2.getFirstInt()) :
                                Integer.compare(
                                        numbPair1.getSecondInt(), numberPair2.getSecondInt())).collect(Collectors.toList());
    }

    public static List<YearSchoolStat> getDataAboutTheNumberOfDiffSchoolsInTheSameYear(List<Entrant> entrants) {
        return entrants.stream().
                map(entrant -> new YearSchoolStat(entrant.getYearOfEntering(),
                        (int) entrants.stream().filter(innerEntrant -> innerEntrant.getYearOfEntering()
                                == entrant.getYearOfEntering()).map
                                (Entrant::getSchoolNumber).distinct().count())).distinct().sorted(
                        (a, b) -> a.getNumberOfSchools() < b.getNumberOfSchools() ||
                                (a.getNumberOfSchools() == b.getNumberOfSchools() &&
                                        a.getYearOfEntering() < b.getYearOfEntering()) ? -1 :
                                (a.getNumberOfSchools() == b.getNumberOfSchools() &&
                                        a.getYearOfEntering() == b.getYearOfEntering()) ? 0 : 1).
                collect(Collectors.toList());
    }

    public static List<YearSchoolStat> getDataAboutTheNumberOfDiffSchoolsInTheSameYearFromList(List<Integer> yearList,
                                                                                               List<Entrant> entrants) {
        return yearList.stream().map(year -> new YearSchoolStat(year, (int) entrants.stream().filter(
                        entrant -> entrant.getYearOfEntering() == year).map(Entrant::getSchoolNumber).distinct().count()))
                .sorted((a, b) -> a.getNumberOfSchools() == b.getNumberOfSchools() ? Integer.compare
                        (a.getYearOfEntering(), b.getYearOfEntering()) : Integer.compare(a.getNumberOfSchools(), b.getNumberOfSchools()))
                .collect(Collectors.toList());
    }
}
