package com.aklimets.util;

/**
 * Abstract skeleton for learning tasks.
 */
public abstract class LearningTask<T> {

    private final Generator<T> generator;

    protected LearningTask(Generator<T> generator) {
        this.generator = generator;
    }

    public final void execute() {
        System.out.println("***************  " + name() + "  ***************\n");
        description();
        T input = generator.generate();

        System.out.println("Input: ");
        print(input);

        System.out.println("Output: ");
        print(solve(input));
    }

    protected abstract String name();

    protected abstract void description();

    protected abstract T solve(T input);

    protected abstract void print(T input);
}
