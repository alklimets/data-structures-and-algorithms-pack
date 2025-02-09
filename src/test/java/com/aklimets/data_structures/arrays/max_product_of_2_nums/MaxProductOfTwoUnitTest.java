package com.aklimets.data_structures.arrays.max_product_of_2_nums;

import com.aklimets.data_structures.arrays.neetcode.max_product_of_2_nums.MaxProductOfTwo;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static com.aklimets.helper.TestHelper.splitInputToArray;
import static org.assertj.core.api.Assertions.assertThat;

class MaxProductOfTwoUnitTest {

    private final MaxProductOfTwo cut = new MaxProductOfTwo();

    @ParameterizedTest
    @CsvFileSource(resources = "/arrays/max_product_of_two.csv", numLinesToSkip = 1)
    public void shouldPassTest_whenSolve_givenInput(String input, String expected) {
        // given
        int[] givenInput = splitInputToArray(input);
        int[] expectedValue = splitInputToArray(expected);

        // when
        int[] actual = cut.solve(givenInput);

        // then
        assertThat(actual).isEqualTo(expectedValue);
    }

}