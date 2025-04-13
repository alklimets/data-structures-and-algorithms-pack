package com.aklimets.data_structures.heaps.k_smallest_in_sorted_matrix;

import java.util.PriorityQueue;
import java.util.Queue;

public class KSmallestInSortedMatrix {

    /*
        Given an n x n matrix where each of the rows and columns is sorted in ascending order, return the kth smallest element in the matrix.
        Note that it is the kth smallest element in the sorted order, not the kth distinct element.
        You must find a solution with a memory complexity better than O(n2).

        Example 1:
        Input: matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
        Output: 13
        Explanation: The elements in the matrix are [1,5,9,10,11,12,13,13,15], and the 8th smallest number is 13

        Example 2:
        Input: matrix = [[-5]], k = 1
        Output: -5

        Constraints:

        n == matrix.length == matrix[i].length
        1 <= n <= 300
        -10^9 <= matrix[i][j] <= 10^9
        All the rows and columns of matrix are guaranteed to be sorted in non-decreasing order.
        1 <= k <= n^2
    */

    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        Queue<int[]> heap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < n; i++) {
            heap.offer(new int[] {matrix[i][0], i, 0});
        }

        int res = 0;
        for (int i = 0; i < k; i++) {
            int[] poll = heap.poll();
            res = poll[0];
            if (poll[2] == n - 1) {
                continue;
            }
            int ii = poll[1];
            int jj = poll[2] + 1;
            heap.offer(new int[] {matrix[ii][jj], ii, jj});
        }
        return res;
    }
}
