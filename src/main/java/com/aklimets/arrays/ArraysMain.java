package com.aklimets.arrays;

import com.aklimets.arrays.max_product_of_2_nums.MaxProductOfTwo;
import com.aklimets.util.LearningTask;

import java.util.List;

public class ArraysMain {

    public static void main(String[] args) {
        ArraysGenerator generator = new ArraysGenerator();
        List.of(
                new MaxProductOfTwo(generator)
        ).forEach(LearningTask::execute);
    }
}
