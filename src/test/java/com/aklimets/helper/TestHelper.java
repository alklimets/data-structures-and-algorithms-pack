package com.aklimets.helper;

import java.util.Arrays;

public class TestHelper {

    public static int[] splitInput(String input) {
        return Arrays.stream(input.split(","))
                .filter(s -> !s.isEmpty())
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
