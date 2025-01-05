package com.aklimets.algorithms.dynamic_programming.neetcode.coin_change_2;

public class CoinChange2 {

    /*
        Coin Change II
        You are given an integer array coins representing coins of different denominations (e.g. 1 dollar, 5 dollars, etc) and an integer amount representing a target amount of money.

        Return the number of distinct combinations that total up to amount. If it's impossible to make up the amount, return 0.

        You may assume that you have an unlimited number of each coin and that each value in coins is unique.

        Example 1:

        Input: amount = 4, coins = [1,2,3]

        Output: 4
        Explanation:

        1+1+1+1 = 4
        1+1+2 = 4
        2+2 = 4
        1+3 = 4
        Example 2:

        Input: amount = 7, coins = [2,4]

        Output: 0
        Constraints:

        1 <= coins.length <= 100
        1 <= coins[i] <= 1000
        0 <= amount <= 1000
    */

    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount + 1];
        for (int i = 0; i < coins.length; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= amount; i++) {
            dp[0][i] = i % coins[0] == 0 ? 1 : 0;
        }

        for (int i = 1; i < coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j < coins[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    int prev = dp[i - 1][j];
                    int rest = dp[i][j - coins[i]];
                    dp[i][j] = prev + rest;
                }
            }
        }

        return dp[coins.length - 1][amount];
    }

    public static void main(String[] args) {
        System.out.println(new CoinChange2().change(7, new int[]{2, 4}));
    }
}
