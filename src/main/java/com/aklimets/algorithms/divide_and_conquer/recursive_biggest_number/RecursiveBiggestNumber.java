package com.aklimets.algorithms.divide_and_conquer.recursive_biggest_number;

import java.util.Arrays;

public class RecursiveBiggestNumber {

    public int solve(int[] input) {
        if (input.length == 1) {
            return input[0];
        }

        int[] left = Arrays.copyOfRange(input, 0, input.length / 2);
        int[] right = Arrays.copyOfRange(input, (input.length / 2), input.length);
        return Math.max(solve(left), solve(right));
    }
}
