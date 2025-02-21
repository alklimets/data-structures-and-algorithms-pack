package com.aklimets.challenges.neetcode.intervals.employee_free_time;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class EmployeeFreeTime {

    /*
        We are given a list of Interval objects representing the working hours of each employee.
        Each employee has a list of intervals during which they are busy. Your task is to find all the free time intervals
        for all employees. A free time interval is defined as a time period where no employee is busy.

        Example:
        Input:
        Employee 1: \[(1, 3), (6, 7)\]
        Employee 2: \[(2, 4)\]
        Employee 3: \[(2, 3), (9, 12)\]

        Output:
        \[(4, 6), (7, 9)\]
    */

    public List<int[]> freeTime(List<List<int[]>> workTimes) {
        List<int[]> times = workTimes.stream().flatMap(Collection::stream).sorted((a, b) -> a[0] - b[0]).toList();
        List<int[]> result = new ArrayList<>();
        int lastTime = Integer.MIN_VALUE;
        for (int[] interval : times) {
            if (lastTime == Integer.MIN_VALUE || interval[0] < lastTime) {
                lastTime = Math.max(lastTime, interval[1]);
            } else {
                result.add(new int[]{lastTime, interval[0]});
                lastTime = interval[1];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<int[]> ints = new EmployeeFreeTime().freeTime(List.of(
                List.of(new int[]{1, 3}, new int[]{6, 7}),
                List.of(new int[]{2, 4}),
                List.of(new int[]{2, 3}, new int[]{9, 12})
        ));

        ints.forEach(a -> System.out.println(Arrays.toString(a)));
    }
}
