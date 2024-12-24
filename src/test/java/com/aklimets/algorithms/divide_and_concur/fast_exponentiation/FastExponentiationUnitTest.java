package com.aklimets.algorithms.divide_and_concur.fast_exponentiation;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.assertj.core.api.Assertions.assertThat;

class FastExponentiationUnitTest {

    private final FastExponentiation cut = new FastExponentiation();

    @ParameterizedTest
    @CsvFileSource(resources = "/general/exponentiation.csv", numLinesToSkip = 1)
    public void shouldPassTest_whenPowRecursive_givenInput(long base, long power, long expected) {
        // given

        // when
        long actual = cut.powRecursive(base, power);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/general/exponentiation.csv", numLinesToSkip = 1)
    public void shouldPassTest_whenPowNonRecursive_givenInput(long base, long power, long expected) {
        // given

        // when
        long actual = cut.powNonRecursive(base, power);

        // then
        assertThat(actual).isEqualTo(expected);
    }

}