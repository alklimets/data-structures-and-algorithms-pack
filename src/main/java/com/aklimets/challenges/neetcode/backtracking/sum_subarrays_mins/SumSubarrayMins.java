package com.aklimets.challenges.neetcode.backtracking.sum_subarrays_mins;

import com.aklimets.data_structures.stacks.minstack.MinStack;


public class SumSubarrayMins {


    public int sumSubarrayMins(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            MinStack stack = new MinStack();
            for (int j = i; j < arr.length; j++) {
                stack.push(arr[j]);
                sum += stack.getMin();
            }
        }
        return sum;
    }


    public static void main(String[] args) {
        System.out.println(new SumSubarrayMins().sumSubarrayMins(new int[]{3, 1, 2, 4}));
    }
}
