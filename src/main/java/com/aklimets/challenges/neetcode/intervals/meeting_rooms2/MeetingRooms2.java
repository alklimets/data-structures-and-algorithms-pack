package com.aklimets.challenges.neetcode.intervals.meeting_rooms2;

import java.util.List;
import java.util.PriorityQueue;

public class MeetingRooms2 {

    /*
        Meeting Rooms II
        Given an array of meeting time interval objects consisting of start and end times [[start_1,end_1],[start_2,end_2],...] (start_i < end_i), find the minimum number of days required to schedule all meetings without any conflicts.

        Example 1:

        Input: intervals = [(0,40),(5,10),(15,20)]

        Output: 2
        Explanation:
        day1: (0,40)
        day2: (5,10),(15,20)

        Example 2:

        Input: intervals = [(4,9)]

        Output: 1
        Note:

        (0,8),(8,10) is not considered a conflict at 8
        Constraints:

        0 <= intervals.length <= 500
        0 <= intervals[i].start < intervals[i].end <= 1,000,000
    */

    public class Interval {
        public int start, end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public int minMeetingRooms(List<Interval> intervals) {
        if (intervals.size() == 0) return 0;
        intervals.sort((a, b) -> a.start - b.start);
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (Interval interval : intervals) {
            if (!heap.isEmpty() && heap.peek() <= interval.start) {
                heap.poll();
            }
            heap.offer(interval.end);
        }

        return heap.size();
    }
}
