package com.aklimets.challenges.neetcode.backtracking.expression_add_operators;

import java.util.ArrayList;
import java.util.List;

public class ExpressionsAddOperators {

    /*
        Given a string num that contains only digits and an integer target, return all possibilities to insert the binary operators '+', '-', and/or '*' between the digits of num so that the resultant expression evaluates to the target value.
        Note that operands in the returned expressions should not contain leading zeros.

        Example 1:

        Input: num = "123", target = 6
        Output: ["1*2*3","1+2+3"]
        Explanation: Both "1*2*3" and "1+2+3" evaluate to 6.
        Example 2:

        Input: num = "232", target = 8
        Output: ["2*3+2","2+3*2"]
        Explanation: Both "2*3+2" and "2+3*2" evaluate to 8.
        Example 3:

        Input: num = "3456237490", target = 9191
        Output: []
        Explanation: There are no expressions that can be created from "3456237490" to evaluate to 9191.

        Constraints:

        1 <= num.length <= 10
        num consists of only digits.
        -2^31 <= target <= 2^31 - 1
    */

    List<String> result = new ArrayList<>();
    public List<String> addOperators(String num, int target) {
        backtrack(num, target, "", 0,0, 0);
        return result;
    }

    void backtrack(String num, int target, String path, long current, long prev, int start) {
        if (start == num.length()) {
            if (current == target) {
                result.add(path);
            }
            return;
        }

        for (int i = start; i < num.length(); i++) {
            if (i != start && num.charAt(start) == '0') return;

            long number = Long.parseLong(num.substring(start, i + 1));
            if (start == 0) {
                backtrack(num, target, "" + number, number, number, i + 1);
            } else {
                backtrack(num, target, path + "+" + number, current + number, number, i + 1);
                backtrack(num, target, path + "-" + number, current - number, -number, i + 1);
                backtrack(num, target, path + "*" + number, current - prev + number * prev, number * prev, i + 1);
            }
        }
    }
}
