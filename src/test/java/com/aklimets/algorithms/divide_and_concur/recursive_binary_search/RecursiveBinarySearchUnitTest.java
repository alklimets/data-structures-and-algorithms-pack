package com.aklimets.algorithms.divide_and_concur.recursive_binary_search;

import com.aklimets.helper.TestHelper;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.assertj.core.api.Assertions.assertThat;

class RecursiveBinarySearchUnitTest {

    private final RecursiveBinarySearch cut = new RecursiveBinarySearch();

    @ParameterizedTest
    @CsvFileSource(resources = "/search/search_array.csv", numLinesToSkip = 1)
    public void shouldPassTest_whenSearch_given_input(String input, int item, int expected) {
        // given
        int[] givenInput = TestHelper.splitInput(input);

        // when
        int actual = cut.search(givenInput, 0, givenInput.length - 1, item);

        // then
        assertThat(actual).isEqualTo(expected);
    }

}