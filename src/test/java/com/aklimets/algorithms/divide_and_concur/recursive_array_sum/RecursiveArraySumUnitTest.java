package com.aklimets.algorithms.divide_and_concur.recursive_array_sum;

import com.aklimets.helper.TestHelper;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.assertj.core.api.Assertions.assertThat;

class RecursiveArraySumUnitTest {

    private final RecursiveArraySum cut = new RecursiveArraySum();


    @ParameterizedTest
    @CsvFileSource(resources = "/arrays/array_sum.csv", numLinesToSkip = 1)
    public void shouldPassTest_whenSolve_givenInput(String input, int expected) {
        // given
        int[] inputArray = TestHelper.splitInput(input);

        // when
        int actual = cut.solve(inputArray);

        // then
        assertThat(actual).isEqualTo(expected);
    }

}