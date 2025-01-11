package com.aklimets.data_structures.arrays.leetcode.valid_mountain;

public class ValidMountain {

    public boolean validMountainArray(int[] arr) {

        int l = 0, r = arr.length - 1;
        while (l < r) {
            if (arr[l] < arr[r]) {
                if (arr[l] >= arr[l + 1]) return false;
                l++;
            } else {
                if (arr[r] >= arr[r - 1]) return false;
                r--;
            }
        }
        return l != 0 && r != arr.length - 1;
    }

    public static void main(String[] args) {
        System.out.println(new ValidMountain().validMountainArray(new int[] {0,3,2,1}));
    }
}
