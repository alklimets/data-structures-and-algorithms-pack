package com.aklimets.challenges.neetcode.intervals.insert_interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class InsertInterval {

    /*
        Insert Interval
        You are given an array of non-overlapping intervals intervals where intervals[i] = [start_i, end_i] represents the start and the end time of the ith interval. intervals is initially sorted in ascending order by start_i.

        You are given another interval newInterval = [start, end].

        Insert newInterval into intervals such that intervals is still sorted in ascending order by start_i and also intervals still does not have any overlapping intervals. You may merge the overlapping intervals if needed.

        Return intervals after adding newInterval.

        Note: Intervals are non-overlapping if they have no common point. For example, [1,2] and [3,4] are non-overlapping, but [1,2] and [2,3] are overlapping.

        Example 1:

        Input: intervals = [[1,3],[4,6]], newInterval = [2,5]

        Output: [[1,6]]
        Example 2:

        Input: intervals = [[1,2],[3,5],[9,10]], newInterval = [6,7]

        Output: [[1,2],[3,5],[6,7],[9,10]]
        Constraints:

        0 <= intervals.length <= 1000
        newInterval.length == intervals[i].length == 2
        0 <= start <= end <= 1000
    */

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> combined = new ArrayList<>();
        for (int[] interval : intervals) {
            combined.add(interval);
        }
        combined.add(newInterval);
        intervals = combined.toArray(int[][]::new);
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> merged = new ArrayList<>();
        merged.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] lastMerged = merged.get(merged.size() - 1);
            if (lastMerged[1] >= intervals[i][0]) {
                lastMerged[1] = Math.max(lastMerged[1], intervals[i][1]);
            } else {
                merged.add(intervals[i]);
            }
        }

        return merged.toArray(int[][]::new);
    }

    // better
    public int[][] insert2(int[][] intervals, int[] newInterval) {
        List<int[]> merged = new ArrayList<>();
        for (int[] interval : intervals) {
            if (newInterval == null || interval[1] < newInterval[0]) {
                merged.add(interval);
            } else if (interval[0] > newInterval[1]) {
                merged.add(newInterval);
                merged.add(interval);
                newInterval = null;
            } else {
                newInterval[0] = Math.min(newInterval[0], interval[0]);
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            }
        }
        if (newInterval != null) merged.add(newInterval);

        return merged.toArray(int[][]::new);
    }
}
