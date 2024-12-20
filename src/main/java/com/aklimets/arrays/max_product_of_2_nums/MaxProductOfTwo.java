package com.aklimets.arrays.max_product_of_2_nums;

import com.aklimets.util.Generator;
import com.aklimets.util.LearningTask;

public class MaxProductOfTwo extends LearningTask<int[]> {

    public MaxProductOfTwo() {
    }

    public MaxProductOfTwo(Generator generator) {
        super(generator, a -> a);
    }

    @Override
    protected void description() {
        System.out.println("""
                You are given an array of integers.
                Write a function to find the maximum product that can be obtained by multiplying any two distinct numbers in the array.
                     
                For the array arr = [1, 4, 3, 6, 7, 0]:
                The maximum product can be achieved by multiplying 6 and 7, which gives 42.
                """);
    }

    @Override
    protected String name() {
        return "Max product of two numbers";
    }

    @Override
    protected int[] solve(int[] input) {
        if (input.length < 2) {
            return new int[]{0};
        }
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE;

        for (int item : input) {
            if (item <= min1) {
                min2 = min1;
                min1 = item;
            } else if (item <= min2) {
                min2 = item;
            }

            if (item >= max1) {
                max2 = max1;
                max1 = item;
            } else if (item >= max2) {
                max2 = item;
            }
        }

        return new int[]{Math.max(min1 * min2, max1 * max2)};
    }
}
