package com.aklimets.algorithms.divide_and_conquer.fast_exponentiation;

public class FastExponentiation {

    public long powRecursive(long base, long power) {
        if (power == 2) return base * base;
        if (power % 2 == 1) {
            return base * powRecursive(base, power - 1);
        }
        long val = powRecursive(base, power / 2);
        return val * val;
    }

    public long powNonRecursive(long base, long power) {
        long res = 1;
        while (power > 1) {
            if (power % 2 == 1) {
                res *= base;
            }
            base *= base;
            power /= 2;
        }
        return res * base;
    }
}
