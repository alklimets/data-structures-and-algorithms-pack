package com.aklimets.data_structures.stacks.neetcode.largest_rect_in_histogram;

import java.util.Stack;

public class LargestRectangleInHistogram {

    /*
        Largest Rectangle In Histogram
        You are given an array of integers heights where heights[i] represents the height of a bar. The width of each bar is 1.

        Return the area of the largest rectangle that can be formed among the bars.

        Note: This chart is known as a histogram.

        Example 1:

        Input: heights = [7,1,7,2,2,4]

        Output: 8
        Example 2:

        Input: heights = [1,3,7]

        Output: 7
        Constraints:

        1 <= heights.length <= 1000.
        0 <= heights[i] <= 1000
    */

    // BF
    public int largestRectangleArea(int[] heights) {
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            int l = i, r = i;
            while (l >= 0 && heights[l] >= heights[i]) {
                l--;
            }
            while (r < heights.length && heights[r] >= heights[i]) {
                r++;
            }
            max = Math.max(max, (r - l - 1) * heights[i]);
        }
        return max;
    }

    public int largestRectangleArea1(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int max = -1;
        for (int i = 0; i <= heights.length; i++) {
            while (!stack.isEmpty() && (i == heights.length || heights[stack.peek()] >= heights[i])) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                max = Math.max(max, height * width);
            }
            stack.push(i);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new LargestRectangleInHistogram().largestRectangleArea1(new int[]{7, 1, 7, 2, 2, 4}));
        System.out.println(new LargestRectangleInHistogram().largestRectangleArea1(new int[]{0, 3, 1, 1, 1, 1, 1}));
        System.out.println(new LargestRectangleInHistogram().largestRectangleArea(new int[]{6, 7}));
    }
}
