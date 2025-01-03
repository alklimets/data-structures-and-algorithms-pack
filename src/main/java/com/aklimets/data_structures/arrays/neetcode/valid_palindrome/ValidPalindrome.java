package com.aklimets.data_structures.arrays.neetcode.valid_palindrome;

public class ValidPalindrome {

    /*
        Valid Palindrome
        Given a string s, return true if it is a palindrome, otherwise return false.

        A palindrome is a string that reads the same forward and backward. It is also case-insensitive and ignores all non-alphanumeric characters.

        Example 1:

        Input: s = "Was it a car or a cat I saw?"

        Output: true
        Explanation: After considering only alphanumerical characters we have "wasitacaroracatisaw", which is a palindrome.

        Example 2:

        Input: s = "tab a cat"

        Output: false
        Explanation: "tabacat" is not a palindrome.

        Constraints:

        1 <= s.length <= 1000
        s is made up of only printable ASCII characters.

    */

    public boolean isPalindrome(String s) {
        int[] arr =  s.toLowerCase().chars().filter(a -> (a >= 'a' && a <= 'z') ||  (a >= 'A' && a <= 'Z')||  (a >= '0' && a <= '9') ).toArray();
        for (int i = 0; i < arr.length / 2; i++) {
            if (arr[i] != arr[arr.length - 1 - i]) return false;
        }
        return true;
    }
}
