package com.aklimets.algorithms.dynamic_programming.leetcode.perfect_squares;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PerfectSquares {

    /*
        Topics
        Companies
        Given an integer n, return the least number of perfect square numbers that sum to n.
        A perfect square is an integer that is the square of an integer; in other words, it is the product of some integer with itself. For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.

        Example 1:
        Input: n = 12
        Output: 3
        Explanation: 12 = 4 + 4 + 4.

        Example 2:
        Input: n = 13
        Output: 2
        Explanation: 13 = 4 + 9.

        Constraints:

        1 <= n <= 10^4
    */

    public int numSquares(int n) {
        return dfs(n);
    }
    Map<Integer, Integer> memo = new HashMap<>();
    private int dfs(int target) {
        if (target == 0) return 0;
        if (memo.containsKey(target)) return memo.get(target);

        int res = target;
        for (int i = 1; i * i <= target; i++) {
            res = Math.min(res, 1 + dfs(target - i * i));
        }

        memo.put(target, res);
        return res;
    }

    public int numSquares2(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, n);
        dp[0] = 0;

        for (int target = 1; target <= n; target++) {
            for (int s = 1; s * s <= target; s++) {
                dp[target] = Math.min(dp[target], 1 + dp[target - s * s]);
            }
        }

        return dp[n];
    }
}
