package com.aklimets.algorithms.search;

public class BinarySearch implements SearchTask  {

    @Override
    public int search(int[] input, int item) {
        if (input.length == 0) return -1;
        int left = 0, right = input.length - 1;
        while (left != right) {
            int middle = (left + right) / 2;
            if (input[middle] == item) return middle;

            if (item < input[middle]) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return input[left] == item ? left : -1;
    }
}
