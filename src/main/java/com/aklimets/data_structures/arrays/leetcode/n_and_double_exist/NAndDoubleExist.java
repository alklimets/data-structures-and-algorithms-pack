package com.aklimets.data_structures.arrays.leetcode.n_and_double_exist;

import java.util.HashSet;
import java.util.Set;

public class NAndDoubleExist {

    /*
        Given an array arr of integers, check if there exist two indices i and j such that :

        i != j
        0 <= i, j < arr.length
        arr[i] == 2 * arr[j]


        Example 1:

        Input: arr = [10,2,5,3]
        Output: true
        Explanation: For i = 0 and j = 2, arr[i] == 10 == 2 * 5 == 2 * arr[j]
        Example 2:

        Input: arr = [3,1,7,11]
        Output: false
        Explanation: There is no i and j that satisfy the conditions.


        Constraints:

        2 <= arr.length <= 500
        -103 <= arr[i] <= 103
    */

    public boolean checkIfExist(int[] arr) {
        Set<Integer> visited = new HashSet<>();
        Set<Integer> doubles = new HashSet<>();
        for (int num : arr) {
            if (visited.contains(num * 2) || doubles.contains(num)) {
                return true;
            }
            visited.add(num);
            doubles.add(num * 2);
        }
        return false;
    }
}
