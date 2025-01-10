package com.aklimets.challenges.neetcode.sliding_window.buy_sell_stock;

public class BuySellStock {

    /*
        Best Time to Buy and Sell Stock
        You are given an integer array prices where prices[i] is the price of NeetCoin on the ith day.

        You may choose a single day to buy one NeetCoin and choose a different day in the future to sell it.

        Return the maximum profit you can achieve. You may choose to not make any transactions, in which case the profit would be 0.

        Example 1:

        Input: prices = [10,1,5,6,7,1]

        Output: 6
        Explanation: Buy prices[1] and sell prices[4], profit = 7 - 1 = 6.

        Example 2:

        Input: prices = [10,8,7,5,2]

        Output: 0
        Explanation: No profitable transactions can be made, thus the max profit is 0.

        Constraints:

        1 <= prices.length <= 100
        0 <= prices[i] <= 100
    */

    public int maxProfit(int[] prices) {
        int max = 0;
        int l = 0, r = 1;
        while (r < prices.length) {
            if (prices[l] >= prices[r]) {
                l = r++;
            } else {
                max = Math.max(max, prices[r++] - prices[l]);
            }
        }
        return max;
    }

}
