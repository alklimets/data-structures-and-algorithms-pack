package com.aklimets.algorithms.dynamic_programming.neetcode.coins_change;

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

    public static void main(String[] args) {
        System.out.println(new CoinsChange().coinChange(new int[]{1, 5, 10}, 12));
        System.out.println(new CoinsChange().coinChange(new int[]{1, 2}, 6));
        System.out.println(new CoinsChange().coinChange(new int[]{2}, 3));
    }
}
