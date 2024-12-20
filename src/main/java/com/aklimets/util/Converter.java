package com.aklimets.util;

public interface Converter<T> {
    T convert(int[] input);
}
