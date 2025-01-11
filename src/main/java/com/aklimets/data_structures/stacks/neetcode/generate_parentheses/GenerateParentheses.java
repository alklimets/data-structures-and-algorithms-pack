package com.aklimets.data_structures.stacks.neetcode.generate_parentheses;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    /*
        Generate Parentheses
        You are given an integer n. Return all well-formed parentheses strings that you can generate with n pairs of parentheses.

        Example 1:

        Input: n = 1

        Output: ["()"]
        Example 2:

        Input: n = 3

        Output: ["((()))","(()())","(())()","()(())","()()()"]
        You may return the answer in any order.

        Constraints:

        1 <= n <= 7
    */

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        dfs(0, 0, n, new StringBuilder(), result);
        return result;
    }

    public void dfs(int opened, int closed, int limit, StringBuilder value, List<String> result) {
        if (opened == limit && closed == limit) {
            result.add(value.toString());
            return;
        }

        if (opened < limit) {
            value.append("(");
            dfs(opened + 1, closed, limit, value, result);
            value.deleteCharAt(value.length() - 1);
        }
        if (closed < opened) {
            value.append(")");
            dfs(opened, closed + 1, limit, value, result);
            value.deleteCharAt(value.length() - 1);
        }
    }
}
