package com.aklimets.data_structures.heaps.car_pooling;

import java.util.PriorityQueue;
import java.util.Queue;

public class CarPooling {

    /*
        There is a car with capacity empty seats. The vehicle only drives east (i.e., it cannot turn around and drive west).
        You are given the integer capacity and an array trips where trips[i] = [numPassengersi, fromi, toi] indicates that the ith trip has numPassengersi passengers and the locations to pick them up and drop them off are fromi and toi respectively. The locations are given as the number of kilometers due east from the car's initial location.
        Return true if it is possible to pick up and drop off all passengers for all the given trips, or false otherwise.

        Example 1:
        Input: trips = [[2,1,5],[3,3,7]], capacity = 4
        Output: false

        Example 2:
        Input: trips = [[2,1,5],[3,3,7]], capacity = 5
        Output: true

        Constraints:

        1 <= trips.length <= 1000
        trips[i].length == 3
        1 <= numPassengers[i] <= 100
        0 <= from[i] < to[i] <= 1000
        1 <= capacity <= 10^5
    */

    public boolean carPooling(int[][] trips, int capacity) {
        Queue<int[]> heap = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        for (int[] trip : trips) {
            int passengers = trip[0];
            int from = trip[1];
            int to = trip[2];
            heap.offer(new int[] {from, passengers});
            heap.offer(new int[] {to, -passengers});
        }

        int seats = 0;
        while (!heap.isEmpty()) {
            seats += heap.poll()[1];
            if (seats > capacity) {
                return false;
            }
        }
        return true;
    }
}
