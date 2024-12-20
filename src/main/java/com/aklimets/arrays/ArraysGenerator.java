package com.aklimets.arrays;

import com.aklimets.util.Generator;

public class ArraysGenerator implements Generator {
    @Override
    public int[] generate() {
        return generateRandomArray();
    }
}
