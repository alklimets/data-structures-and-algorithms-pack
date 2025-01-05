package com.aklimets.data_structures.arrays.neetcode.container_with_most_water;

public class ContainerWithMostWater {

    /*
        Container With Most Water
        You are given an integer array heights where heights[i] represents the height of the bar.

        You may choose any two bars to form a container. Return the maximum amount of water a container can store.

        Example 1:

        Input: height = [1,7,2,5,4,7,3,6]

        Output: 36
        Example 2:

        Input: height = [2,2,2]

        Output: 4
    */

    public int maxArea(int[] heights) {
        int max = 0;
        int l = 0, r = heights.length - 1;
        while (l < r) {
            int vol = (r - l) * Math.min(heights[r], heights[l]);
            max = Math.max(vol, max);
            if (heights[l] < heights[r]) {
                l++;
            } else {
                r--;
            }
        }
        return max;
    }
}
