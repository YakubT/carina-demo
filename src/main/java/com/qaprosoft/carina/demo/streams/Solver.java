package com.qaprosoft.carina.demo.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Solver {

    public static final Logger LOGGER = LogManager.getLogger(Solver.class);

    public static List<String> solveTask1(char c, List<String> strings) {
        return strings.stream().filter((string) -> string.charAt(0) == c
                && string.charAt(string.length() - 1) == c && string.length() > 1).collect(Collectors.toList());
    }

    public static void main(String args[]) {
        solveTask1('a', new ArrayList<String>() {
            {
                add("Hello");
                add("qwerty");
                add("asda");
                add("asdfa");
                add("as");
                add("a");
            }
        }).forEach((string) -> System.out.println(string));
    }
}
