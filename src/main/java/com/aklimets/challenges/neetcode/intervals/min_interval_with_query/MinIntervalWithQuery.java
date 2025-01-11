package com.aklimets.challenges.neetcode.intervals.min_interval_with_query;

import java.util.*;

public class MinIntervalWithQuery {

    /*
        Minimum Interval to Include Each Query
        You are given a 2D integer array intervals, where intervals[i] = [left_i, right_i] represents the ith interval starting at left_i and ending at right_i (inclusive).

        You are also given an integer array of query points queries. The result of query[j] is the length of the shortest interval i such that left_i <= queries[j] <= right_i. If no such interval exists, the result of this query is -1.

        Return an array output where output[j] is the result of query[j].

        Note: The length of an interval is calculated as right_i - left_i + 1.

        Example 1:

        Input: intervals = [[1,3],[2,3],[3,7],[6,6]], queries = [2,3,1,7,6,8]

        Output: [2,2,3,5,1,-1]
        Explanation:

        Query = 2: The interval [2,3] is the smallest one containing 2, it's length is 2.
        Query = 3: The interval [2,3] is the smallest one containing 3, it's length is 2.
        Query = 1: The interval [1,3] is the smallest one containing 1, it's length is 3.
        Query = 7: The interval [3,7] is the smallest one containing 7, it's length is 5.
        Query = 6: The interval [6,6] is the smallest one containing 6, it's length is 1.
        Query = 8: There is no interval containing 8.
        Constraints:

        1 <= intervals.length <= 1000
        1 <= queries.length <= 1000
        1 <= left_i <= right_i <= 10000
        1 <= queries[j] <= 10000
    */

    // BF
    public int[] minInterval(int[][] intervals, int[] queries) {
        for (int i = 0; i < queries.length; i++) {
            int min = 1_000_000;
            for (int[] interval : intervals) {
                if (queries[i] >= interval[0] && queries[i] <= interval[1]) {
                    int length = interval[1] - interval[0] + 1;
                    min = Math.min(min, length);
                }
            }
            queries[i] = min == 1_000_000 ? -1 : min;
        }
        return queries;
    }

    public int[] minInterval2(int[][] intervals, int[] queries) {
        Map<Integer, List<Integer>> indexes = new HashMap<>();
        for (int i = 0; i < queries.length; i++) {
            indexes.computeIfAbsent(queries[i], (a) -> new ArrayList<>()).add(i);
        }

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        Arrays.sort(queries);

        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });
        int[] result = new int[queries.length];
        int intInd = 0;
        for (int i = 0; i < queries.length; i++) {
            if (i != queries.length - 1 && queries[i] == queries[i + 1]) continue;
            while (intInd < intervals.length && intervals[intInd][0] <= queries[i]) {
                int length = intervals[intInd][1] - intervals[intInd][0] + 1;
                heap.offer(new int[] {length, intervals[intInd][1]});
                intInd++;
            }

            while (!heap.isEmpty() && heap.peek()[1] < queries[i]) {
                heap.poll();
            }
            int minLength = heap.isEmpty() ? -1 : heap.peek()[0];
            indexes.get(queries[i]).forEach(index -> result[index] = minLength);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new MinIntervalWithQuery().minInterval2(new int[][]{{1, 3}, {2, 3}, {3, 7}, {6, 6}}, new int[]{2, 3, 1, 7, 6, 8})));
    }
}
