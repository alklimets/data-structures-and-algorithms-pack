package com.aklimets.algorithms.greedy.neetcode.max_subarray.jump_game;

public class JumpGame {

    /*
        Jump Game
        You are given an integer array nums where each element nums[i] indicates your maximum jump length at that position.

        Return true if you can reach the last index starting from index 0, or false otherwise.

        Example 1:

        Input: nums = [1,2,0,1,0]

        Output: true
        Explanation: First jump from index 0 to 1, then from index 1 to 3, and lastly from index 3 to 4.

        Example 2:

        Input: nums = [1,2,1,0,1]

        Output: false
        Constraints:

        1 <= nums.length <= 1000
        0 <= nums[i] <= 1000
    */

    public boolean canJump(int[] nums) {
        if (nums.length > 1 && nums[0] == 0) return false;
        int ind = nums.length - 2, goal = ind + 1;
        while (ind >= 0) {
            if (nums[ind] >= goal - ind) {
                goal = ind;
            }
            ind--;
        }
        return goal == 0;
    }

    public static void main(String[] args) {
        System.out.println(new JumpGame().canJump(new int[]{1, 2, 0, 1, 0}));
        System.out.println(new JumpGame().canJump(new int[]{5, 0, 2, 0, 0, 1, 0}));
    }
}
