package com.aklimets.algorithms.dynamic_programming.leetcode.palindrome_partitioning_2;

public class PalindromePartitioning2 {

    public int minCut(String s) {
        int n, min;
        n = s.length();

        //cut[i] represents minimum number of cuts from String 0 to i
        int[] cut = new int[n];

        //p[i][j] represents String i to j is a palindrome or not
        boolean[][] p = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            min = i;  // Max number of cuts is i for string length i+1
            for (int j = 0; j <= i; j++) {
                if (s.charAt(j) == s.charAt(i) && (i - j < 3 || p[j + 1][i - 1])) {
                    // Its a palindrome as Ci == Cj and String[j+1...i-1] is a palindrome
                    p[j][i] = true;
                    // j == 0 because String from j to i is a palindrome and it starts from first character so means no cuts needed
                    // Else I need a cut at jth location and it will be cuts encountered till j-1 + 1
                    min = j == 0 ? 0 : Math.min(min, cut[j - 1] + 1);
                }
            }
            cut[i] = min;
        }
        return cut[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(new PalindromePartitioning2().minCut("aaaaaa"));
    }
}
