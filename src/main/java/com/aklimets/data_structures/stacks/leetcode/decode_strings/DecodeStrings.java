package com.aklimets.data_structures.stacks.leetcode.decode_strings;

import java.util.Stack;

public class DecodeStrings {

    /*
            Given an encoded string, return its decoded string.
        The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
        You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc. Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].
        The test cases are generated so that the length of the output will never exceed 105.

        Example 1:
        Input: s = "3[a]2[bc]"
        Output: "aaabcbc"

        Example 2:
        Input: s = "3[a2[c]]"
        Output: "accaccacc"

        Example 3:
        Input: s = "2[abc]3[cd]ef"
        Output: "abcabccdcdcdef"

        Constraints:

        1 <= s.length <= 30
        s consists of lowercase English letters, digits, and square brackets '[]'.
        s is guaranteed to be a valid input.
        All the integers in s are in the range [1, 300].
    */

    public String decodeString(String s) {
        char[] array = s.toCharArray();
        Stack<String> stack = new Stack<>();
        String num = "";
        for (char ch : array) {
            if (ch == ']') {
                String temp = "";
                while (!stack.peek().equals("[")) {
                    temp = stack.pop() + temp;
                }
                stack.pop();
                int amount = Integer.parseInt(stack.pop());
                stack.push(temp.repeat(amount));
            } else if ('0' <= ch && ch <= '9') {
                num += String.valueOf(ch);
            } else if (ch == '[') {
                stack.push(num);
                num = "";
                stack.push(String.valueOf(ch));
            } else {
                stack.push(String.valueOf(ch));
            }
        }
        return String.join("", stack);
    }

    public static void main(String[] args) {
        System.out.println(new DecodeStrings().decodeString("10[leet]"));
        System.out.println(new DecodeStrings().decodeString("3[a]2[bc]"));
    }
}
