package com.aklimets.algorithms.greedy.neetcode.jump_game_4;

import java.io.IOException;

public class JumpGame4 {

    /*
        You are given a 0-indexed binary string s and two integers minJump and maxJump. In the beginning, you are standing at index 0, which is equal to '0'. You can move from index i to index j if the following conditions are fulfilled:

        i + minJump <= j <= min(i + maxJump, s.length - 1), and
        s[j] == '0'.
        Return true if you can reach index s.length - 1 in s, or false otherwise.

        Example 1:
        Input: s = "011010", minJump = 2, maxJump = 3
        Output: true
        Explanation:
        In the first step, move from index 0 to index 3.
        In the second step, move from index 3 to index 5.

        Example 2:
        Input: s = "01101110", minJump = 2, maxJump = 3
        Output: false

        Constraints:

        2 <= s.length <= 10^5
        s[i] is either '0' or '1'.
        s[0] == '0'
        1 <= minJump <= maxJump < s.length
    */

    public boolean canReach(String s, int minJ, int maxJ) {
        int n = s.length(), pre = 0;
        boolean[] dp = new boolean[n];
        dp[0] = true;
        for (int i = 1; i < n; ++i) {
            if (i >= minJ && dp[i - minJ]) {
                pre++;
            }
            if (i > maxJ && dp[i - maxJ - 1]) {
                pre--;
            }
            dp[i] = pre > 0 && s.charAt(i) == '0';
        }
        return dp[n - 1];
    }

    public static void main(String[] args) throws IOException {
        System.out.println(new JumpGame4().canReach("0111000101110", 5, 6));
    }
}
