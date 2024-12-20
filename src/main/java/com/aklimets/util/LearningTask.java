package com.aklimets.util;

import java.util.Arrays;

/**
 * Abstract skeleton for learning tasks.
 */
public abstract class LearningTask<T> {

    private final Generator generator;
    private final Converter<T> converter;

    public LearningTask() {
        generator = null;
        converter = null;
    }

    protected LearningTask(Generator generator, Converter<T> converter) {
        this.generator = generator;
        this.converter = converter;
    }

    public final void execute() {
        System.out.println("***************  " + name() + "  ***************\n");
        description();
        int[] input = generator.generate();

        System.out.println("Input: ");
        print(input);

        System.out.println("Output: ");
        print(solve((input)));
    }

    protected abstract String name();

    protected abstract void description();

    protected int[] solve(int[] input) {
        return solve(converter.convert(input));
    }

    protected abstract int[] solve(T input);

    protected void print(int[] input) {
        Arrays.stream(input).forEach(i -> System.out.print(i + " "));
        System.out.println("\n");
    }
}
