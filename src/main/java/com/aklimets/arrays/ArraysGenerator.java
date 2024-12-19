package com.aklimets.arrays;

import com.aklimets.util.Generator;

public class ArraysGenerator implements Generator<int[]> {
    @Override
    public int[] generate() {
        return generateArray();
    }
}
