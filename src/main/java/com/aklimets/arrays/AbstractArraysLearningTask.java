package com.aklimets.arrays;

import com.aklimets.util.Generator;
import com.aklimets.util.LearningTask;

import java.util.Arrays;

public abstract class AbstractArraysLearningTask extends LearningTask<int[]> {

    public AbstractArraysLearningTask(Generator<int[]> generator) {
        super(generator);
    }

    @Override
    protected void print(int[] input) {
        Arrays.stream(input).forEach(i -> System.out.print(i + " "));
        System.out.println("\n");
    }

}
