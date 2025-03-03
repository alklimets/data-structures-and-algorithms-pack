package com.aklimets.data_structures.arrays.neetcode.trapping_water;

import java.util.Stack;

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

    // optimal
    public int trap2(int[] height) {
        int l = 0, r = height.length - 1, lMax = 0, rMax = 0;
        int water = 0;
        while (l < r) {
            if (height[l] < height[r]) {
                lMax = Math.max(height[l], lMax);
                water += lMax - height[l];
                l++;
            } else {
                rMax = Math.max(height[r], rMax);
                water += rMax - height[r];
                r--;
            }
        }
        return water;
    }

    public int trap3(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int water = 0;
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                int bottom = stack.pop();
                if (stack.isEmpty()) break;

                int left = stack.peek();
                int width = i - left - 1;
                int h = Math.min(height[left], height[i]) - height[bottom];
                water += width * h;
            }
            stack.push(i);
        }
        return water;
    }

    public static void main(String[] args) {
        System.out.println(new TrappingWater().trap(new int[] {0,2,0,3,1,0,1,3,2,1}));
        System.out.println(new TrappingWater().trap2(new int[] {0,2,0,3,1,0,1,3,2,1}));
        System.out.println(new TrappingWater().trap3(new int[] {0,2,0,3,1,0,1,3,2,1}));
    }

}
