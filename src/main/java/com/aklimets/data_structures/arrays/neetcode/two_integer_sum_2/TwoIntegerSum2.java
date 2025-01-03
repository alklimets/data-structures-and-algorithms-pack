package com.aklimets.data_structures.arrays.neetcode.two_integer_sum_2;

public class TwoIntegerSum2 {

    /*
        Two Integer Sum II
        Given an array of integers numbers that is sorted in non-decreasing order.

        Return the indices (1-indexed) of two numbers, [index1, index2], such that they add up to a given target number target and index1 < index2. Note that index1 and index2 cannot be equal, therefore you may not use the same element twice.

        There will always be exactly one valid solution.

        Your solution must use
        O(1) additional space.

        Example 1:

        Input: numbers = [1,2,3,4], target = 3

        Output: [1,2]
        Explanation:
        The sum of 1 and 2 is 3. Since we are assuming a 1-indexed array, index1 = 1, index2 = 2. We return [1, 2].

        Constraints:

        2 <= numbers.length <= 1000
        -1000 <= numbers[i] <= 1000
        -1000 <= target <= 1000

    */

    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r = 1;
        while (numbers[l] + numbers[r] != target) {
            int sum = numbers[l] + numbers[r];
            if (r < numbers.length - 1 && sum < target) {
                r++;
            } else {
                l++;
                while (numbers[l] + numbers[r] > target) {
                    r--;
                }
            }
        }

        return new int[] {l + 1, r + 1};
    }

    // better
    public int[] twoSum2(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;
        while (numbers[l] + numbers[r] != target) {
            int sum = numbers[l] + numbers[r];
            if (sum > target) {
                r--;
            } else {
                l++;
            }
        }

        return new int[] {l + 1, r + 1};
    }
}
