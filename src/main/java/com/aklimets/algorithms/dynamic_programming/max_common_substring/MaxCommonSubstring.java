package com.aklimets.algorithms.dynamic_programming.max_common_substring;

public class  MaxCommonSubstring {

    public static String solve(String a, String b) {
        String res = "";
        String[][] matrix = new String[a.length()][b.length()];

        char[] aCharArray = a.toCharArray();
        char[] bCharArray = b.toCharArray();


        for (int i = 0; i < aCharArray.length; i++) {
            for (int j = 0; j < bCharArray.length; j++) {
                if (aCharArray[i] == bCharArray[j]) {
                    if (i == 0 || j == 0) {
                        matrix[i][j] = String.valueOf(aCharArray[i]);
                    } else {
                        matrix[i][j] = matrix[i-1][j-1] + aCharArray[i];
                    }
                    if (res.length() < matrix[i][j].length()) res = matrix[i][j];
                } else {
                    matrix[i][j] = "";
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(solve("fish", "kish"));
        System.out.println(solve("democracy", "cracow"));
    }
}
