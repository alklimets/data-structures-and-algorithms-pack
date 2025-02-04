package com.aklimets.data_structures.arrays.leetcode.backspace_compare;

import java.util.Stack;

public class BackspaceCompare {

    /*
        Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character.
        Note that after backspacing an empty text, the text will continue empty.

        Example 1:
        Input: s = "ab#c", t = "ad#c"
        Output: true
        Explanation: Both s and t become "ac".

        Example 2:
        Input: s = "ab##", t = "c#d#"
        Output: true
        Explanation: Both s and t become "".

        Example 3:
        Input: s = "a#c", t = "b"
        Output: false
        Explanation: s becomes "c" while t becomes "b".

        Constraints:

        1 <= s.length, t.length <= 200
        s and t only contain lowercase letters and '#' characters.


        Follow up: Can you solve it in O(n) time and O(1) space?
    */

    public boolean backspaceCompare(String s, String t) {
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '#' && !stack1.isEmpty()) {
                stack1.pop();
            } else {
                stack1.push(ch);
            }
        }

        for (char ch : t.toCharArray()) {
            if (ch == '#' && !stack2.isEmpty()) {
                stack2.pop();
            } else {
                stack2.push(ch);
            }
        }

        return stack1.equals(stack2);
    }

    public static void main(String[] args) {
        System.out.println(new BackspaceCompare().backspaceCompare("y#fo##f", "y#f#o##f"));
    }
}
