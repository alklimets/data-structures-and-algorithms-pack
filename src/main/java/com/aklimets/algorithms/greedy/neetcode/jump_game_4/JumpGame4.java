package com.aklimets.algorithms.greedy.neetcode.jump_game_4;

import java.io.IOException;

public class JumpGame4 {

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
