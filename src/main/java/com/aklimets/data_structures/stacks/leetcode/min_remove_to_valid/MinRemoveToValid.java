package com.aklimets.data_structures.stacks.leetcode.min_remove_to_valid;

import java.util.ArrayList;
import java.util.List;

public class MinRemoveToValid {

    /*
        Given a string s of '(' , ')' and lowercase English characters.
        Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting parentheses string is valid and return any valid string.
        Formally, a parentheses string is valid if and only if:

        It is the empty string, contains only lowercase characters, or
        It can be written as AB (A concatenated with B), where A and B are valid strings, or
        It can be written as (A), where A is a valid string.

        Example 1:
        Input: s = "lee(t(c)o)de)"
        Output: "lee(t(c)o)de"
        Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.

        Example 2:
        Input: s = "a)b(c)d"
        Output: "ab(c)d"

        Example 3:
        Input: s = "))(("
        Output: ""
        Explanation: An empty string is also valid.

        Constraints:

        1 <= s.length <= 10^5
        s[i] is either '(' , ')', or lowercase English letter.
    */

    public String minRemoveToMakeValid(String s) {
        List<Character> chars = new ArrayList<>();
        for (char ch : s.toCharArray()) {
            chars.add(ch);
        }
        int opened = 0, closed = 0;
        List<Character> charsLeft = new ArrayList<>();
        for (char ch : chars) {
            if (ch == '(') {
                opened++;
                charsLeft.add(ch);
            } else if (ch == ')') {
                if (closed < opened) {
                    closed++;
                    charsLeft.add(ch);
                }
            } else {
                charsLeft.add(ch);
            }
        }

        opened = 0;
        closed = 0;
        List<Character> charsRight = new ArrayList<>();
        for (int i = charsLeft.size() - 1; i >= 0; i--) {
            char ch = charsLeft.get(i);
            if (ch == ')') {
                closed++;
                charsRight.add(ch);
            } else if (ch == '(') {
                if (opened < closed) {
                    opened++;
                    charsRight.add(ch);
                }
            } else {
                charsRight.add(ch);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = charsRight.size() - 1; i >= 0; i--) {
            sb.append(charsRight.get(i));
        }
        return sb.toString();
    }
}
