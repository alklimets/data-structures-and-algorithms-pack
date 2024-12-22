package com.aklimets.data_structures.arrays.max_product_of_2_nums;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class MaxProductOfTwoUnitTest {

    private final MaxProductOfTwo cut = new MaxProductOfTwo();

    @ParameterizedTest
    @CsvFileSource(resources = "/arrays/max_product_of_two.csv", numLinesToSkip = 1)
    public void shouldPassTest_whenSolve_given_input(String input, String expected) {
        // given
        int[] givenInput = splitInput(input);
        int[] expectedValue = splitInput(expected);

        // when
        int[] actual = cut.solve(givenInput);

        // then
        assertThat(actual).isEqualTo(expectedValue);
    }

    private int[] splitInput(String input) {
        return Arrays.stream(input.split(","))
                .filter(s -> !s.isEmpty())
                .mapToInt(Integer::parseInt)
                .toArray();
    }

}