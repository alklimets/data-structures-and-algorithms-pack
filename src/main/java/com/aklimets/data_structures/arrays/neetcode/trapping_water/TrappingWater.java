package com.aklimets.data_structures.arrays.neetcode.trapping_water;

public class TrappingWater {

    /*
        Trapping Rain Water
        You are given an array non-negative integers height which represent an elevation map. Each value height[i] represents the height of a bar, which has a width of 1.

        Return the maximum area of water that can be trapped between the bars.

        Example 1:
        Input: height = [0,2,0,3,1,0,1,3,2,1]

        Output: 9
        Constraints:

        1 <= height.length <= 1000
        0 <= height[i] <= 1000

    */

    public int trap(int[] height) {
        int l = 0, r = 1;
        while (height[l] == 0) {
            l++;
            r++;
        }
        int res = 0;
        while (l < height.length - 1) {
            int value = height[l];
            int indexOfMax = -1, max = -1;
            while (r < height.length && height[r] <= value) {
                if (max < height[r]) {
                    indexOfMax = r;
                    max = height[r];
                }
                r++;
            }
            if (r == height.length) r = indexOfMax;
            while (++l < r) {
                res += Math.min(value, height[r]) - height[l];
            }
            r++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new TrappingWater().trap(new int[] {0,2,0,3,1,0,1,3,2,1}));
    }

}
