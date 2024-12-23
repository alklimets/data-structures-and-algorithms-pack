package com.aklimets.algorithms.divide_and_concur.recursive_biggest_number;

import com.aklimets.helper.TestHelper;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.assertj.core.api.Assertions.assertThat;

class RecursiveBiggestNumberUnitTest {

    private final RecursiveBiggestNumber cut = new RecursiveBiggestNumber();

    @ParameterizedTest
    @CsvFileSource(resources = "/arrays/biggest_number.csv", numLinesToSkip = 1)
    public void shouldPassTest_whenSolve_givenInput(String input, int expected) {
        // given
        int[] inputArray = TestHelper.splitInput(input);

        // when
        int actual = cut.solve(inputArray);

        // then
        assertThat(actual).isEqualTo(expected);
    }

}