package com.aklimets.challenges.neetcode.intervals.merge_intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

    /*
        Merge Intervals
        Given an array of intervals where intervals[i] = [start_i, end_i], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

        You may return the answer in any order.

        Note: Intervals are non-overlapping if they have no common point. For example, [1, 2] and [3, 4] are non-overlapping, but [1, 2] and [2, 3] are overlapping.

        Example 1:

        Input: intervals = [[1,3],[1,5],[6,7]]

        Output: [[1,5],[6,7]]
        Example 2:

        Input: intervals = [[1,2],[2,3]]

        Output: [[1,3]]
        Constraints:

        1 <= intervals.length <= 1000
        intervals[i].length == 2
        0 <= start <= end <= 1000
    */

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> merged = new ArrayList<>();

        merged.add(intervals[0]);
        int pointer = 1;
        while (pointer < intervals.length) {
            int[] lastMergedInterval = merged.get(merged.size() - 1);
            if (lastMergedInterval[1] >= intervals[pointer][0]) {
                lastMergedInterval[1] = Math.max(intervals[pointer][1], lastMergedInterval[1]);
            } else {
                merged.add(intervals[pointer]);
            }
            pointer++;
        }

        return merged.toArray(int[][]::new);
    }
}
