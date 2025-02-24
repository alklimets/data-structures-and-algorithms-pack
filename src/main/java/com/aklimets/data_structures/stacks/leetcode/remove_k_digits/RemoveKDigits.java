package com.aklimets.data_structures.stacks.leetcode.remove_k_digits;

import java.util.Stack;

public class RemoveKDigits {

    /*
        Given string num representing a non-negative integer num, and an integer k, return the smallest possible integer after removing k digits from num.

        Example 1:

        Input: num = "1432219", k = 3
        Output: "1219"
        Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
        Example 2:

        Input: num = "10200", k = 1
        Output: "200"
        Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
        Example 3:

        Input: num = "10", k = 2
        Output: "0"
        Explanation: Remove all the digits from the number and it is left with nothing which is 0.

        Constraints:

        1 <= k <= num.length <= 10^5
        num consists of only digits.
        num does not have any leading zeros except for the zero itself.
    */

    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();

        for (char digit : num.toCharArray()) {
            while (k > 0 && !stack.isEmpty() && stack.peek() > digit) {
                stack.pop();
                k--;
            }
            stack.push(digit);
        }

        while (k-- > 0) {
            stack.pop();
        }

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        result.reverse();
        while (result.length() > 0 && result.charAt(0) == '0') {
            result.deleteCharAt(0);
        }

        return result.length() == 0 ? "0" : result.toString();
    }

    public static void main(String[] args) {
        System.out.println(new RemoveKDigits().removeKdigits("1234567890", 9));
    }
}
