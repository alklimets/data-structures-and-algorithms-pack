package com.aklimets.challenges.neetcode.binary_search.coco_eats_bananas;

import java.util.Arrays;

public class CocoEatsBananas {

    /*
        Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.
        Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas,
        she eats all of them instead and will not eat any more bananas during this hour.
        Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
        Return the minimum integer k such that she can eat all the bananas within h hours.

        Example 1:
        Input: piles = [3,6,7,11], h = 8
        Output: 4

        Example 2:
        Input: piles = [30,11,23,4,20], h = 5
        Output: 30

        Example 3:
        Input: piles = [30,11,23,4,20], h = 6
        Output: 23

        Constraints:

        1 <= piles.length <= 10^4
        piles.length <= h <= 10^9
        1 <= piles[i] <= 10^9
    */

    public int minEatingSpeed(int[] piles, int h) {
        int l = 1, r = Arrays.stream(piles).max().getAsInt();
        int res = h;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int hours = 0;
            for (int pile : piles) {
                hours += (pile - 1) / mid + 1;
            }

            if (hours > 0 && hours <= h) {
                res = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return res;
    }

    public static void main(String[] args) {
//        System.out.println(new CocoEatsBananas().minEatingSpeed(new int[]{1,1,1,999999999}, 10));
        System.out.println(new CocoEatsBananas().minEatingSpeed(new int[]{805306368, 805306368, 805306368}, 1000000000));
    }
}
