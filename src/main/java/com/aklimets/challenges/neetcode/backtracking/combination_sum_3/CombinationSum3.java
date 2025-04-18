package com.aklimets.challenges.neetcode.backtracking.combination_sum_3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum3 {

    /*
        Find all valid combinations of k numbers that sum up to n such that the following conditions are true:

        Only numbers 1 through 9 are used.
        Each number is used at most once.
        Return a list of all possible valid combinations. The list must not contain the same combination twice, and the combinations may be returned in any order.

        Example 1:
        Input: k = 3, n = 7
        Output: [[1,2,4]]
        Explanation:
        1 + 2 + 4 = 7
        There are no other valid combinations.

        Example 2:
        Input: k = 3, n = 9
        Output: [[1,2,6],[1,3,5],[2,3,4]]
        Explanation:
        1 + 2 + 6 = 9
        1 + 3 + 5 = 9
        2 + 3 + 4 = 9
        There are no other valid combinations.

        Example 3:
        Input: k = 4, n = 1
        Output: []
        Explanation: There are no valid combinations.
        Using 4 different numbers in the range [1,9], the smallest sum we can get is 1+2+3+4 = 10 and since 10 > 1, there are no valid combination.

        Constraints:

        2 <= k <= 9
        1 <= n <= 60
    */

    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        backtrack(1, 0, k, n, new LinkedList<>());
        return res;
    }

    void backtrack(int start, int used, int k, int target, LinkedList<Integer> curr) {
        if (used == k && target == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }

        if (used == k) return;

        for (int i = start; i <= 9; i++) {
            if (i <= target) {
                curr.add(i);
                backtrack(i + 1, used + 1, k, target - i, curr);
                curr.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new CombinationSum3().combinationSum3(3, 9));
    }
}
