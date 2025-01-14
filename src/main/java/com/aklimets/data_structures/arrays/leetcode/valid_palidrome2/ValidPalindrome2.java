package com.aklimets.data_structures.arrays.leetcode.valid_palidrome2;

public class ValidPalindrome2 {

    public boolean validPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return isPalindrome(s.substring(l + 1, r + 1)) || isPalindrome(s.substring(l, r));
            }
            l++;
            r--;
        }

        return true;
    }

    private boolean isPalindrome (String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new ValidPalindrome2().validPalindrome("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga"));
    }
}
