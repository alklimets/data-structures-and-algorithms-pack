package com.aklimets.data_structures.arrays.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class QuickSort {

    // recursive example with additional memory usage
    public int[] sort(int[] input) {
        if (input.length <= 1) {
            return input;
        }

        int pivotIndex = new Random().nextInt(input.length);
        int pivot = input[pivotIndex];
        List<Integer> smaller = new ArrayList<>();
        List<Integer> greater = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            if (i == pivotIndex) continue;
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

    // in place sort with efficient memory usage
    public void inPlaceSort(int[] input, int left, int right) {
        if (left < right) {
            int pivot = partition(input, left, right);
            inPlaceSort(input, left, pivot - 1);
            inPlaceSort(input, pivot + 1, right);
        }
    }

    private int partition(int[] input, int left, int right) {
        int i = left;
        int pivot = input[right];
        for (int j = left; j < right; j++) {
            if (input[j] <= pivot) {
                swap(input, j, i++);
            }
        }
        swap(input, i, right);
        return i;
    }

    private void swap(int[] input, int a, int b) {
        int buff = input[a];
        input[a] = input[b];
        input[b] = buff;
    }

}
