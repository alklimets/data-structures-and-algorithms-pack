package com.aklimets.algorithms.divide_and_concur.euclid;

import com.aklimets.algorithms.divide_and_concur.euclid.GreatestCommonDivisor;

public class LargestSquareFitsIntoRectangle {

    /*
     * Given a rectangle with dimensions a × b, find the side length of the largest square that can perfectly tile
     * the entire rectangle without leaving any empty space.
     *
     * The largest square side length that can tile the rectangle is the GCD of a and b. Euclid’s algorithm can be
     * used to efficiently compute the GCD, which gives the size of the largest square that can fit within the given
     * dimensions of the rectangle.
     */

    public int solve(int a, int b) {
        return new GreatestCommonDivisor().solve(a, b);
    }
}
