package com.aklimets.algorithms.divide_and_conquer.euclid;

public class GreatestCommonDivisor {

    public int solve(int a, int b) {
        int min = Math.min(a, b);
        int max = Math.max(a, b);
        int rest = -1;
        while (rest != 0) {
            rest = max % min;
            max = min;
            min = rest;
        }
        return max;
    }

}
