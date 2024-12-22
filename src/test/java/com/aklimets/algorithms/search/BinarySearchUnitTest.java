package com.aklimets.algorithms.search;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class BinarySearchUnitTest {

    private final BinarySearch cut = new BinarySearch();

    @ParameterizedTest
    @CsvFileSource(resources = "/search/search_array.csv", numLinesToSkip = 1)
    public void shouldPassTest_whenSearch_given_input(String input, int item, int expected) {
        // given
        int[] givenInput = splitInput(input);

        // when
        int actual = cut.search(givenInput, item);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    private int[] splitInput(String input) {
        return Arrays.stream(input.split(","))
                .filter(s -> !s.isEmpty())
                .mapToInt(Integer::parseInt)
                .toArray();
    }

}