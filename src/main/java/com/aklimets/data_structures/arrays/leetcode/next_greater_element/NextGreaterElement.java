package com.aklimets.data_structures.arrays.leetcode.next_greater_element;

import java.util.*;

public class NextGreaterElement {

    /*
        496. Next Greater Element I
        Easy
        Topics
        Companies
        The next greater element of some element x in an array is the first greater element that is to the right of x in the same array.

        You are given two distinct 0-indexed integer arrays nums1 and nums2, where nums1 is a subset of nums2.

        For each 0 <= i < nums1.length, find the index j such that nums1[i] == nums2[j] and determine the next greater element of nums2[j] in nums2. If there is no next greater element, then the answer for this query is -1.

        Return an array ans of length nums1.length such that ans[i] is the next greater element as described above.



        Example 1:

        Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
        Output: [-1,3,-1]
        Explanation: The next greater element for each value of nums1 is as follows:
        - 4 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
        - 1 is underlined in nums2 = [1,3,4,2]. The next greater element is 3.
        - 2 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
        Example 2:

        Input: nums1 = [2,4], nums2 = [1,2,3,4]
        Output: [3,-1]
        Explanation: The next greater element for each value of nums1 is as follows:
        - 2 is underlined in nums2 = [1,2,3,4]. The next greater element is 3.
        - 4 is underlined in nums2 = [1,2,3,4]. There is no next greater element, so the answer is -1.


        Constraints:

        1 <= nums1.length <= nums2.length <= 1000
        0 <= nums1[i], nums2[i] <= 104
        All integers in nums1 and nums2 are unique.
        All the integers of nums1 also appear in nums2.

    */

    public static int[] nextGreaterElement(int[] findNums, int[] nums) {
        Map<Integer, Integer> nextGreater = new HashMap<>();
        Deque<Integer> stack = new LinkedList<>();
        for (int num : nums) {
            while (!stack.isEmpty() && stack.peek() < num) {
                nextGreater.put(stack.pop(), num);
            }
            stack.push(num);
        }
        for (int i = 0; i < findNums.length; i++) {
            findNums[i] = nextGreater.getOrDefault(findNums[i], -1);
        }
        return findNums;
    }

    public static int[] nextGreaterElement(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                res[stack.pop()] = nums[i];
            }
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString( nextGreaterElement(new int[] {1,3,4,2,5})));
        System.out.println(Arrays.toString( nextGreaterElement(new int[] {1,2,5,4,3})));
        System.out.println(Arrays.toString( nextGreaterElement(new int[] {1,2,5,4,3, 6})));
    }
}
