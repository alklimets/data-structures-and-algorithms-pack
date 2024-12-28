package com.aklimets.algorithms.dynamic_programming.neetcode.climbing_stairs;

public class ClimbingStairs {

    /*
        Climbing Stairs
        You are given an integer n representing the number of steps to reach the top of a staircase. You can climb with either 1 or 2 steps at a time.

        Return the number of distinct ways to climb to the top of the staircase.

        Example 1:

        Input: n = 2

        Output: 2
        Explanation:

        1 + 1 = 2
        2 = 2
        Example 2:

        Input: n = 3

        Output: 3
        Explanation:

        1 + 1 + 1 = 3
        1 + 2 = 3
        2 + 1 = 3
        Constraints:

        1 <= n <= 30
    */

    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    /*
        optimal
    */
    public int climbStairs2(int n) {
        if (n == 1 || n == 2) return n;
        int[] arr = new int[n];
        arr[0] = 1;
        arr[1] = 2;
        for (int i = 2; i < n; i++) {
            arr[i] = arr[i-1] + arr[i - 2];
        }
        return arr[n - 1];
    }

    public int climbStairs3(int n) {
        if (n == 1 || n == 2) return n;
        int one = 1, two = 1;
        for (int i = 2; i < n; i++) {
            int temp = one + two;
            one = two;
            two = temp;
        }
        return one + two;
    }
}
