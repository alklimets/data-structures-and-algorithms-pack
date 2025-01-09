package com.aklimets.algorithms.greedy.neetcode.jump_game_2;

public class JumpGame2 {

    /*
        Jump Game II
        You are given an array of integers nums, where nums[i] represents the maximum length of a jump towards the right from index i. For example, if you are at nums[i], you can jump to any index i + j where:

        j <= nums[i]
        i + j < nums.length
        You are initially positioned at nums[0].

        Return the minimum number of jumps to reach the last position in the array (index nums.length - 1). You may assume there is always a valid answer.

        Example 1:

        Input: nums = [2,4,1,1,1,1]

        Output: 2
        Explanation: Jump from index 0 to index 1, then jump from index 1 to the last index.

        Example 2:

        Input: nums = [2,1,2,1,0]

        Output: 2
        Constraints:

        1 <= nums.length <= 1000
        0 <= nums[i] <= 100
    */

    public int jump(int[] nums) {
        int ind = nums.length - 2, goal = ind + 1;
        int res = 0;
        while (ind >= 0) {
            int minIndex = ind;
            for (int i = ind; i >= 0; i--) {
                if (nums[i] >= goal - i && i < minIndex) {
                    minIndex = i;
                }
            }
            res++;
            goal = minIndex;
            ind = goal - 1;
        }
        return res;
    }

    public int jump2(int[] nums) {
        int l = 0, r = 0, count = 0;
        while (r < nums.length - 1) {
            count++;
            int farest = r, border = r;
            for (int i = l; i <= r; i++) {
                farest = Math.max(farest, i + nums[i]);
            }
            l = border + 1;
            r = farest;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new JumpGame2().jump2(new int[]{6, 5, 1, 1, 4, 1, 2, 3}));
    }
}
