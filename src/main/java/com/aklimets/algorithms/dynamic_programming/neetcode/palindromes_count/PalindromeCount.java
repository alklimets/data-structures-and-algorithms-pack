package com.aklimets.algorithms.dynamic_programming.neetcode.palindromes_count;

import java.util.*;

public class PalindromeCount {



    public int countSubstrings(String s) {
        int res = 0;
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            int l = i, r = i;
            while (l >= 0 && r <= charArray.length - 1) {
                if (charArray[l] != charArray[r]) {
                    break;
                }
                res++;
                l--;
                r++;
            }
        }

        for (int i = 0; i < charArray.length; i++) {
            int l = i, r = i + 1;
            while (l >= 0 && r <= charArray.length - 1) {
                if (charArray[l] != charArray[r]) {
                    break;
                }
                res++;
                l--;
                r++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new PalindromeCount().countSubstrings("abbaabbaabbaabbaabbaabbaabbaabbaabbaabbaabbaabba"));
    }
}
