package com.aklimets.data_structures.stacks.leetcode.remove_dupl_letters;

import java.util.Stack;

public class RemoveDuplicateLetters {

    /*
        Given a string s, remove duplicate letters so that every letter appears once and only once. You must make sure your result is
        the smallest in lexicographical order  among all possible results.

        Example 1:
        Input: s = "bcabc"
        Output: "abc"

        Example 2:
        Input: s = "cbacdcbc"
        Output: "acdb"

        Constraints:

        1 <= s.length <= 10^4
        s consists of lowercase English letters.
    */

    public String removeDuplicateLetters(String s) {
        Stack<Integer> stack = new Stack<>();
        boolean[] seen = new boolean[26];
        int[] lastIndex = new int[26];
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            lastIndex[charArray[i] - 'a'] = i;
        }
        for (int i = 0; i < charArray.length; i++) {
            int curr = charArray[i] - 'a';
            if (seen[curr]) continue;
            while (!stack.isEmpty() && stack.peek() >= curr && i < lastIndex[stack.peek()]) {
                seen[stack.pop()] = false;
            }
            stack.push(curr);
            seen[curr] = true;

        }
        return String.join("", stack.stream().map(i -> String.valueOf((char)('a' + i))).toList());
    }

    public static void main(String[] args) {
        System.out.println(new RemoveDuplicateLetters().removeDuplicateLetters("cacbca"));
    }
}
