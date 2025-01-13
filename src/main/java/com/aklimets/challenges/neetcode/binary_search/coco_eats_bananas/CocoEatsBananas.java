package com.aklimets.challenges.neetcode.binary_search.coco_eats_bananas;

import java.util.Arrays;

public class CocoEatsBananas {

    public int minEatingSpeed(int[] piles, int h) {
        int l = 1, r = Arrays.stream(piles).max().getAsInt();
        int res = h;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int hours = 0;
            for (int pile : piles) {
                hours += (pile - 1)/mid + 1;
            }

            if (hours <= h) {
                res = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new CocoEatsBananas().minEatingSpeed(new int[]{1,1,1,999999999}, 10));
    }
}
