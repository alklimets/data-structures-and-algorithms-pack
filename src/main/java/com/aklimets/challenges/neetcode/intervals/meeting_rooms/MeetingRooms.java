package com.aklimets.challenges.neetcode.intervals.meeting_rooms;

import java.util.Arrays;
import java.util.List;

public class MeetingRooms {

    /*
        Meeting Rooms
        Given an array of meeting time interval objects consisting of start and end times [[start_1,end_1],[start_2,end_2],...] (start_i < end_i), determine if a person could add all meetings to their schedule without any conflicts.

        Example 1:

        Input: intervals = [(0,30),(5,10),(15,20)]

        Output: false
        Explanation:

        (0,30) and (5,10) will conflict
        (0,30) and (15,20) will conflict
        Example 2:

        Input: intervals = [(5,8),(9,15)]

        Output: true
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

    public boolean canAttendMeetings(List<Interval> intervals) {
        Interval[] array = intervals.toArray(Interval[]::new);
        Arrays.sort(array, (a, b) -> a.start - b.start);
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i].end > array[i + 1].start) return false;
        }
        return true;
    }

}
