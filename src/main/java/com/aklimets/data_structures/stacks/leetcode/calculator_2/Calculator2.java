package com.aklimets.data_structures.stacks.leetcode.calculator_2;

import java.util.Stack;

public class Calculator2 {

    /*
        Given a string s which represents an expression, evaluate this expression and return its value.
        The integer division should truncate toward zero.
        You may assume that the given expression is always valid. All intermediate results will be in the range of [-231, 231 - 1].
        Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().

        Example 1:
        Input: s = "3+2*2"
        Output: 7

        Example 2:
        Input: s = " 3/2 "
        Output: 1

        Example 3:
        Input: s = " 3+5 / 2 "
        Output: 5


        Constraints:

        1 <= s.length <= 3 * 10^5
        s consists of integers and operators ('+', '-', '*', '/') separated by some number of spaces.
        s represents a valid expression.
        All the integers in the expression are non-negative integers in the range [0, 2^31 - 1].
        The answer is guaranteed to fit in a 32-bit integer.
    */

    public int calculate(String s) {
        s += "!";

        Stack<Integer> stack = new Stack<>();
        String sign = "+";
        int num = 0;
        for (char ch : s.toCharArray()) {
            if (ch >= '0' && ch <= '9') {
                num = num * 10 + (ch - '0');
            } else if (ch != ' ') {
                if (sign.equals("+")) {
                    stack.push(num);
                } else if (sign.equals("-")) {
                    stack.push(-num);
                } else if (sign.equals("*")) {
                    stack.push(stack.pop() * num);
                } else if (sign.equals("/")) {
                    stack.push(stack.pop() / num);
                }
                num = 0;
                if (ch != '!') {
                    sign = String.valueOf(ch);
                }
            }
        }

        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Calculator2().calculate("3+2*22"));
    }
}
