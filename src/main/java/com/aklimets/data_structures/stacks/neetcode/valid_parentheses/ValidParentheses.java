package com.aklimets.data_structures.stacks.neetcode.valid_parentheses;

import java.util.LinkedList;
import java.util.Stack;

public class ValidParentheses {

    /*
        Valid Parentheses
        You are given a string s consisting of the following characters: '(', ')', '{', '}', '[' and ']'.

        The input string s is valid if and only if:

        Every open bracket is closed by the same type of close bracket.
        Open brackets are closed in the correct order.
        Every close bracket has a corresponding open bracket of the same type.
        Return true if s is a valid string, and false otherwise.

        Example 1:

        Input: s = "[]"

        Output: true
        Example 2:

        Input: s = "([{}])"

        Output: true
        Example 3:

        Input: s = "[(])"

        Output: false
        Explanation: The brackets are not closed in the correct order.

        Constraints:

        1 <= s.length <= 1000
    */

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (aChar == '(' || aChar == '{' || aChar == '[') {
                stack.push(aChar);
            } else {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if (aChar == ')' && top != '(') return false;
                if (aChar == '}' && top != '{') return false;
                if (aChar == ']' && top != '[') return false;
            }
        }
        return stack.size() == 0;

    }
}
