package com.aklimets.challenges.neetcode.sliding_window.k_closest;

import java.util.LinkedList;
import java.util.List;

public class KClosest {

    /*
        Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array. The result should also be sorted in ascending order.
        An integer a is closer to x than an integer b if:

        |a - x| < |b - x|, or
        |a - x| == |b - x| and a < b

        Example 1:
        Input: arr = [1,2,3,4,5], k = 4, x = 3
        Output: [1,2,3,4]

        Example 2:
        Input: arr = [1,1,2,3,4,5], k = 4, x = -1
        Output: [1,1,2,3]

        Constraints:

        1 <= k <= arr.length
        1 <= arr.length <= 104
        arr is sorted in ascending order.
        -104 <= arr[i], x <= 104
    */


    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        LinkedList<Integer> res = new LinkedList<>();
        int l = 0;
        int r = arr.length - 1;
        while (r - l >= k) {
            if (Math.abs(arr[r] - x) >= Math.abs(arr[l] - x)) {
                r--;
            } else {
                l++;
            }
        }

        for (int i = l; i <= r; i++) {
            res.add(arr[i]);
        }
        return res;
    }

}
