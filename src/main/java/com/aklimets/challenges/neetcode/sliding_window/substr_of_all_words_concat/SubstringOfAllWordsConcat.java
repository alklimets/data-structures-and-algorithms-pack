package com.aklimets.challenges.neetcode.sliding_window.substr_of_all_words_concat;

import java.util.*;

public class SubstringOfAllWordsConcat {

    /*
        You are given a string s and an array of strings words. All the strings of words are of the same length.
        A concatenated string is a string that exactly contains all the strings of any permutation of words concatenated.
        For example, if words = ["ab","cd","ef"], then "abcdef", "abefcd", "cdabef", "cdefab", "efabcd", and "efcdab" are all concatenated strings. "acdbef" is not a concatenated string because it is not the concatenation of any permutation of words.
        Return an array of the starting indices of all the concatenated substrings in s. You can return the answer in any order.

        Example 1:
        Input: s = "barfoothefoobarman", words = ["foo","bar"]
        Output: [0,9]
        Explanation:
        The substring starting at 0 is "barfoo". It is the concatenation of ["bar","foo"] which is a permutation of words.
        The substring starting at 9 is "foobar". It is the concatenation of ["foo","bar"] which is a permutation of words.

        Example 2:
        Input: s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
        Output: []
        Explanation:
        There is no concatenated substring.

        Example 3:
        Input: s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
        Output: [6,9,12]

        Explanation:

        The substring starting at 6 is "foobarthe". It is the concatenation of ["foo","bar","the"].
        The substring starting at 9 is "barthefoo". It is the concatenation of ["bar","the","foo"].
        The substring starting at 12 is "thefoobar". It is the concatenation of ["the","foo","bar"].
    */

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        int wordSize = words[0].length();

        Set<String> dict = new HashSet<>(Arrays.asList(words).stream().toList());
        Map<String, Integer> desired = new HashMap<>();

        for (String word : words) {
            desired.compute(word, (k, v) -> v == null ? 1 : v + 1);
        }
        int desiredMatches = dict.size();

        for (int i = 0; i < wordSize; i++) {
            int l = i, r = i, count = 0;
            Map<String, Integer> window = new HashMap<>();

            while (r + wordSize <= s.length()) {
                String sub = s.substring(r, r + wordSize);
                r += wordSize;
                if (!dict.contains(sub)) {
                    l = r;
                    window.clear();
                    count = 0;
                } else {
                    window.compute(sub, (k, v) -> v == null ? 1 : v + 1);

                    if (window.get(sub).equals(desired.get(sub))) count++;

                    while (window.get(sub) > desired.get(sub)) {
                        String left = s.substring(l, l + wordSize);
                        if (window.get(left).equals(desired.get(left))) count--;
                        window.compute(left, (k, v) -> v - 1);
                        l += wordSize;
                    }

                    if (count == desiredMatches) res.add(l);
                }
            }
        }



        return res;
    }

    public static void main(String[] args) {
        System.out.println(new SubstringOfAllWordsConcat().findSubstring("bcabbcaabbccacacbabccacaababcbb", new String[] {"c","b","a","c","a","a","a","b","c"}));
        System.out.println(new SubstringOfAllWordsConcat().findSubstring("abaababbaba", new String[] {"ab", "ab", "ba", "ba"}));
        System.out.println(new SubstringOfAllWordsConcat().findSubstring("ababaab", new String[] {"ab", "ba", "ba"}));
    }

}
