package com.aklimets.challenges.neetcode.binary_search.find_in_mount_array;

public class FindInMountArray {

    /*
        (This problem is an interactive problem.)
        You may recall that an array arr is a mountain array if and only if:

        arr.length >= 3
        There exists some i with 0 < i < arr.length - 1 such that:
        arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
        arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
        Given a mountain array mountainArr, return the minimum index such that mountainArr.get(index) == target. If such an index does not exist, return -1.

        You cannot access the mountain array directly. You may only access the array using a MountainArray interface:

        MountainArray.get(k) returns the element of the array at index k (0-indexed).
        MountainArray.length() returns the length of the array.
        Submissions making more than 100 calls to MountainArray.get will be judged Wrong Answer. Also, any solutions that attempt to circumvent the judge will result in disqualification.

        Example 1:
        Input: mountainArr = [1,2,3,4,5,3,1], target = 3
        Output: 2
        Explanation: 3 exists in the array, at index=2 and index=5. Return the minimum index, which is 2.

        Example 2:
        Input: mountainArr = [0,1,2,4,2,1], target = 3
        Output: -1
        Explanation: 3 does not exist in the array, so we return -1.

        Constraints:

        3 <= mountainArr.length() <= 104
        0 <= target <= 109
        0 <= mountainArr.get(index) <= 109
    */

    interface MountainArray {
        public int get(int index);

        public int length();
    }

    public int findInMountainArray(int target, MountainArray mountainArr) {
        int size = mountainArr.length();
        int top = -1;
        int l = 0, r = size - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            int midVal = mountainArr.get(mid);
            int lVal = mid > 0 ? mountainArr.get(mid - 1) : Integer.MIN_VALUE;
            int rVal = (mid < size - 1) ? mountainArr.get(mid + 1) : Integer.MIN_VALUE;
            if (lVal < midVal && midVal > rVal) {
                top = mid;
                break;
            }

            if (lVal <= midVal && midVal <= rVal) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        l = 0;
        r = top;
        while (l < r) {
            int mid = (l + r) / 2;
            if (mountainArr.get(mid) == target) {
                return mid;
            }
            if (target < mountainArr.get(mid)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        if (mountainArr.get(l) == target) {
            return l;
        }


        l = top;
        r = size - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (mountainArr.get(mid) == target) {
                return mid;
            }
            if (target > mountainArr.get(mid)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return mountainArr.get(l) == target ? l : -1;

    }
}
