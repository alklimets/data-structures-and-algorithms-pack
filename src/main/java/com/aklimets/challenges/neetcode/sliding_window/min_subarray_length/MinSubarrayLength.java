package com.aklimets.challenges.neetcode.sliding_window.min_subarray_length;

public class MinSubarrayLength {

    /*
        Given an array of positive integers nums and a positive integer target, return the minimal length of a subarray
        whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.
        Example 1:

        Input: target = 7, nums = [2,3,1,2,4,3]
        Output: 2
        Explanation: The subarray [4,3] has the minimal length under the problem constraint.
        Example 2:

        Input: target = 4, nums = [1,4,4]
        Output: 1
        Example 3:

        Input: target = 11, nums = [1,1,1,1,1,1,1,1]
        Output: 0

        Constraints:

        1 <= target <= 109
        1 <= nums.length <= 105
        1 <= nums[i] <= 104


        Follow up: If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log(n)).
    */

    public int minSubArrayLen(int target, int[] nums) {
        int min = Integer.MAX_VALUE;
        int[] prefix = new int[nums.length + 1];
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i - 1] + nums[i - 1];
        }

        int l = 1, r = 1;
        while (r < prefix.length) {
            if (prefix[r] - prefix[l - 1] >= target) {
                min = Math.min(min, r - l + 1);
                l++;
            } else {
                r++;
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public int minSubArrayLen2(int target, int[] nums) {
        int min = Integer.MAX_VALUE;
        int current = 0;
        int l = 0, r = 0;
        while (r <= nums.length) {
            while (current >= target) {
                min = Math.min(min, r - l);
                current -= nums[l++];
            }
            if (r < nums.length) {
                current += nums[r];
            }
            r++;

        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public static void main(String[] args) {
        System.out.println(new MinSubarrayLength().minSubArrayLen(7, new int[] {2,3,1,2,4,3}));
        System.out.println(new MinSubarrayLength().minSubArrayLen2(7, new int[] {2,3,1,2,4,3}));
    }
}
