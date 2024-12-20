package com.aklimets.arrays;

import com.aklimets.util.Generator;
import com.aklimets.util.LearningTask;

public abstract class AbstractArraysLearningTask extends LearningTask<int[]> {

    public AbstractArraysLearningTask(Generator generator) {
        super(generator, a -> a);
    }

}
