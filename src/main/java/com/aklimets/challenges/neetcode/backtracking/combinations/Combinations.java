package com.aklimets.challenges.neetcode.backtracking.combinations;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Combinations {

    /*
        Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].
        You may return the answer in any order.

        Example 1:

        Input: n = 4, k = 2
        Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
        Explanation: There are 4 choose 2 = 6 total combinations.
        Note that combinations are unordered, i.e., [1,2] and [2,1] are considered to be the same combination.
        Example 2:

        Input: n = 1, k = 1
        Output: [[1]]
        Explanation: There is 1 choose 1 = 1 total combination.

        Constraints:

        1 <= n <= 20
        1 <= k <= n
    */

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        LinkedList<Integer> cur = new LinkedList<>();
        backtrack(1, n, k, cur);
        return res;
    }

    private void backtrack(int ind, int n, int k, LinkedList<Integer> cur) {
        if (cur.size() == k) {
            res.add(new ArrayList<>(cur));
            return;
        }

        for (int i = ind; i <= n; i++) {
            cur.add(i);
            backtrack(i + 1, n, k, cur);
            cur.removeLast();
        }
    }

    public static void main(String[] args) {
        System.out.println(new Combinations().combine(4, 2));
    }
}
