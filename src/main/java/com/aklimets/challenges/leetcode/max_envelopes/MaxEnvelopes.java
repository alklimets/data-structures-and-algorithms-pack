package com.aklimets.challenges.leetcode.max_envelopes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MaxEnvelopes {

    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });
        int max = 1;
        int[] dp = new int[envelopes.length];
        Arrays.fill(dp, 1);

        for (int i = envelopes.length - 2; i >= 0; i--) {
            int maxCount = 0;
            for (int j = i + 1; j < envelopes.length; j++) {
                if (envelopes[j][0] > envelopes[i][0] && envelopes[j][1] > envelopes[i][1]) {
                    maxCount = Math.max(maxCount, dp[j]);
                }
            }
            dp[i] += maxCount;
            max = Math.max(max, dp[i]);
        }

        return max;
    }

    public int maxEnvelopes2(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });
        List<Integer> heights = new ArrayList<>();

        for (int[] envelope : envelopes) {
            int height = envelope[1];
            int pos = Collections.binarySearch(heights, height);

            if (pos < 0) pos = -pos - 1;

            if (pos < heights.size()) {
                heights.set(pos, height);
            } else {
                heights.add(height);
            }
        }

        return heights.size();
    }

    public static void main(String[] args) {
//        System.out.println(new MaxEnvelopes().maxEnvelopes2(new int[][] {{4,5},{4,6},{6,7},{2,3}}));
        System.out.println(new MaxEnvelopes().maxEnvelopes2(new int[][] {{1,10}, {4,8}}));
    }
}
