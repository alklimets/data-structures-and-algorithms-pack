package com.aklimets.helper;

import java.util.Arrays;
import java.util.List;

public class TestHelper {

    public static int[] splitInputToArray(String input) {
        return Arrays.stream(input.split(","))
                .filter(s -> !s.isEmpty())
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    public static List<Integer> splitInputToList(String input) {
        return Arrays.stream(input.split(","))
                .filter(s -> !s.isEmpty())
                .mapToInt(Integer::parseInt)
                .boxed()
                .toList();
    }
}
