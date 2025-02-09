package com.aklimets.algorithms.divide_and_conquer.recursive_binary_search;

public class RecursiveBinarySearch {

    public int search(int[] input, int start, int finish, int item) {
        if (input.length == 0) return -1;
        if (start != finish) {
            int middle = (start + finish) / 2;
            if (input[middle] == item) return middle;

            if (item < input[middle]) {
                return search(input, start, middle - 1, item);
            } else {
                return search(input, middle + 1, finish, item);
            }
        }
        return input[start] == item ? start : -1;
    }

}
