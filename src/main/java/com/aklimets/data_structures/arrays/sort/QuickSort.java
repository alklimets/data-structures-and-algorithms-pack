package com.aklimets.data_structures.arrays.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class QuickSort {

    public int[] sort(int[] input) {
        if (input.length <= 1) {
            return input;
        }

        int pivot = input[0];
        List<Integer> smaller = new ArrayList<>();
        List<Integer> greater = new ArrayList<>();
        for (int i = 1; i < input.length; i++) {
            if (input[i] <= pivot) smaller.add(input[i]);
            if (input[i] > pivot) greater.add(input[i]);
        }
        int[] smallerArray = smaller.stream().mapToInt(i -> i).toArray();
        int[] greaterArray = greater.stream().mapToInt(i -> i).toArray();
        return Stream.of(
                Arrays.stream(sort(smallerArray)),
                IntStream.of(pivot),
                Arrays.stream(sort(greaterArray))
        ).flatMapToInt(i -> i).toArray();
    }
}
