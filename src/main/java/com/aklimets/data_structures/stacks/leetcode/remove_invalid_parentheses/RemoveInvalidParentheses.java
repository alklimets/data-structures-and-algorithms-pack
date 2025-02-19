package com.aklimets.data_structures.stacks.leetcode.remove_invalid_parentheses;

import java.util.*;

public class RemoveInvalidParentheses {

    /*
        Given a string s that contains parentheses and letters, remove the minimum number of invalid parentheses to make the input string valid.
        Return a list of unique strings that are valid with the minimum number of removals. You may return the answer in any order.

        Example 1:
        Input: s = "()())()"
        Output: ["(())()","()()()"]

        Example 2:
        Input: s = "(a)())()"
        Output: ["(a())()","(a)()()"]

        Example 3:
        Input: s = ")("
        Output: [""]


        Constraints:

        1 <= s.length <= 25
        s consists of lowercase English letters and parentheses '(' and ')'.
        There will be at most 20 parentheses in s.
    */

    public List<String> removeInvalidParentheses(String s) {
        Queue<String> queue = new LinkedList<>();
        queue.offer(s);
        Set<String> res = new HashSet<>();
        Set<String> visited = new HashSet<>();
        boolean found = false;
        while (!queue.isEmpty() && !found) {
            for (int q = queue.size(); q > 0; q--) {
                String item = queue.poll();
                if (isValid(item)) {
                    res.add(item);
                    found = true;
                }

                for (int i = 0; i < item.length(); i++) {
                    String offer = item.substring(0, i) + item.substring(i + 1);
                    if (!visited.contains(offer)) {
                        queue.offer(offer);
                        visited.add(offer);
                    }
                }
            }
        }
        return new ArrayList<>(res);

    }

    boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
