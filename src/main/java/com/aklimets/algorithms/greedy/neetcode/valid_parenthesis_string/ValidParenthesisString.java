package com.aklimets.algorithms.greedy.neetcode.valid_parenthesis_string;

public class ValidParenthesisString {

    /*
        Valid Parenthesis String
        You are given a string s which contains only three types of characters: '(', ')' and '*'.

        Return true if s is valid, otherwise return false.

        A string is valid if it follows all of the following rules:

        Every left parenthesis '(' must have a corresponding right parenthesis ')'.
        Every right parenthesis ')' must have a corresponding left parenthesis '('.
        Left parenthesis '(' must go before the corresponding right parenthesis ')'.
        A '*' could be treated as a right parenthesis ')' character or a left parenthesis '(' character, or as an empty string "".
        Example 1:

        Input: s = "((**)"

        Output: true
        Explanation: One of the '*' could be a ')' and the other could be an empty string.

        Example 2:

        Input: s = "(((*)"

        Output: false
        Explanation: The string is not valid because there is an extra '(' at the beginning, regardless of the extra '*'.

        Constraints:

        1 <= s.length <= 100
    */

    public boolean checkValidString(String s) {
        int leftMax = 0, leftMin = 0;
        char[] chars = s.toCharArray();
        for (char ch : chars) {
            if (ch == '(') {
                leftMin++;
                leftMax++;
            } else if (ch == ')') {
                leftMin--;
                leftMax--;
            } else {
                leftMin--;
                leftMax++;
            }
            if (leftMax < 0) return false;
            if (leftMin < 0) leftMin = 0;
        }
        return leftMin == 0;
    }

    public static void main(String[] args) {
        System.out.println(new ValidParenthesisString().checkValidString("(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())"));
    }
}
