package com.aklimets.data_structures.stacks.leetcode.longest_valid_parentheses;

import java.util.Stack;

public class LongestValidParentheses {

    /*
        Given a string containing just the characters '(' and ')', return the length of the longest valid (well-formed) parentheses
        substring

        Example 1:
        Input: s = "(()"
        Output: 2
        Explanation: The longest valid parentheses substring is "()".

        Example 2:
        Input: s = ")()())"
        Output: 4
        Explanation: The longest valid parentheses substring is "()()".

        Example 3:
        Input: s = ""
        Output: 0

        Constraints:

        0 <= s.length <= 3 * 10^4
        s[i] is '(', or ')'.
    */

    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxLength = Math.max(maxLength, i - stack.peek());
                }
            }
        }
        return maxLength;
    }
}
