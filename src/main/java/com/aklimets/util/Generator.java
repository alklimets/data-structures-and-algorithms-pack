package com.aklimets.util;

public interface Generator<T> {

    default int[] generateArray() {
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 100) - 50;
        }
        return array;
    }

    T generate();
}
