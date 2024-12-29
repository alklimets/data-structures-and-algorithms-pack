package com.aklimets.algorithms.dynamic_programming.neetcode.longest_palindromic_substr;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestPalindromicSubstring {

    /*
        Longest Palindromic Substring
        Given a string s, return the longest substring of s that is a palindrome.

        A palindrome is a string that reads the same forward and backward.

        If there are multiple palindromic substrings that have the same length, return any one of them.

        Example 1:

        Input: s = "ababd"

        Output: "bab"
        Explanation: Both "aba" and "bab" are valid answers.

        Example 2:

        Input: s = "abbc"

        Output: "bb"
        Constraints:

        1 <= s.length <= 1000
        s contains only digits and English letters.
    */

    private Set<String> palindromes = new HashSet<>();

    /*
        Not optimal
     */
    public String longestPalindrome(String s) {
        if (s.length() == 1) return s;
        if (palindromes.contains(s)) return s;
        if (isPalindrome(s)) {
            palindromes.add(s);
            return s;
        }
        String str1 = longestPalindrome(s.substring(0, s.length() - 1));
        String str2 = longestPalindrome(s.substring(1));

        return str1.length() > str2.length() ? str1 : str2;
    }

    private boolean isPalindrome(String s) {
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length / 2; i++) {
            if (charArray[i] != charArray[charArray.length - 1 - i]) return false;
        }
        return true;
    }


    public String longestPalindrome2(String s) {
        String longest = "";

        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            int l = i, r = i;
            while (l >= 0 && r <= charArray.length - 1) {
                if (charArray[l] != charArray[r]) {
                    break;
                }
                l--;
                r++;
            }
            String palindrome = s.substring(l + 1, r);
            if (palindrome.length() > longest.length()) longest = palindrome;
        }

        for (int i = 0; i < charArray.length; i++) {
            int l = i, r = i + 1;
            while (l >= 0 && r <= charArray.length - 1) {
                if (charArray[l] != charArray[r]) {
                    break;
                }
                l--;
                r++;
            }
            String palindrome = s.substring(l + 1, r);
            if (palindrome.length() > longest.length()) longest = palindrome;
        }

        return longest;
    }



    public static void main(String[] args) {
        System.out.println(new LongestPalindromicSubstring().longestPalindrome2("ACAACD"));
    }
}
