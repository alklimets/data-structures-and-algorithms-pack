package com.aklimets.algorithms.dynamic_programming.neetcode.coins_change;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CoinsChange {

    Map<Integer, Integer> memo = new HashMap<>();

    public int dfs(int amount, int[] coins) {
        if (amount == 0) return 0;
        if (memo.containsKey(amount)) {
            return memo.get(amount);
        }

        int min = 1_000_000;
        for (int coin : coins) {
            if (amount >= coin) {
                int res = dfs(amount - coin, coins);
                min = Math.min(min, 1 + res);
            }
        }

        memo.put(amount, min);
        return min;
    }

    public int coinChange(int[] coins, int amount) {
        int minCoins = dfs(amount, coins);
        return minCoins == 1_000_000 ? -1 : minCoins;
    }

    public int coinChange2(int[] coins, int amount) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        Arrays.fill(dp[0], 1_000_000);
        for (int i = 1; i <= coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                if (coins[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    int prev = dp[i][j - coins[i - 1]];
                    if (j - coins[i - 1] == 0 || prev > 0) {
                        dp[i][j] = Math.min(1 + prev, dp[i - 1][j]);
                    }
                }
            }
        }
        return dp[coins.length][amount] == 1_000_000 ? -1 : dp[coins.length][amount];
    }

    public int coinChange3(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int j = 1; j <= amount; j++) {
            for (int coin : coins) {
                if (j >= coin) {
                    dp[j] = Math.min(dp[j], 1 + dp[j - coin]);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        System.out.println(new CoinsChange().coinChange2(new int[]{1, 5, 10, 2}, 27));
        System.out.println(new CoinsChange().coinChange2(new int[]{1, 2}, 6));
        System.out.println(new CoinsChange().coinChange2(new int[]{2}, 3));
        System.out.println(new CoinsChange().coinChange3(new int[]{1, 5, 10, 2}, 27));
        System.out.println(new CoinsChange().coinChange3(new int[]{1, 2}, 6));
        System.out.println(new CoinsChange().coinChange3(new int[]{2}, 3));
    }
}
