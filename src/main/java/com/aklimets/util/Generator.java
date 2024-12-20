package com.aklimets.util;

public interface Generator {

    default int[] generateRandomArray() {
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 100) - 50;
        }
        return array;
    }

    int[] generate();
}
