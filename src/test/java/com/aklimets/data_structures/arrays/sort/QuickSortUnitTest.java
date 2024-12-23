package com.aklimets.data_structures.arrays.sort;

import com.aklimets.helper.TestHelper;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.assertj.core.api.Assertions.assertThat;

class QuickSortUnitTest {

    private final QuickSort cut = new QuickSort();

    @ParameterizedTest
    @CsvFileSource(resources = "/arrays/sort/sort_array.csv", numLinesToSkip = 1)
    public void shouldPassTest_whenSort_givenInput(String input, String expected) {
        // given
        int[] givenInput = TestHelper.splitInput(input);
        int[] expectedOutput = TestHelper.splitInput(expected);

        // when
        int[] actual = cut.sort(givenInput);

        // then
        assertThat(actual).isEqualTo(expectedOutput);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/arrays/sort/sort_array.csv", numLinesToSkip = 1)
    public void shouldPassTest_whenInPlaceSort_givenInput(String input, String expected) {
        // given
        int[] givenInput = TestHelper.splitInput(input);
        int[] expectedOutput = TestHelper.splitInput(expected);

        // when
        cut.inPlaceSort(givenInput, 0, givenInput.length - 1);

        // then
        assertThat(givenInput).isEqualTo(expectedOutput);
    }

}