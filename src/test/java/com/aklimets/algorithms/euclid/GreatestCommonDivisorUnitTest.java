package com.aklimets.algorithms.euclid;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.assertj.core.api.Assertions.assertThat;

class GreatestCommonDivisorUnitTest {

    private final GreatestCommonDivisor cut = new GreatestCommonDivisor();


    @ParameterizedTest
    @CsvFileSource(resources = "/euclid/GCD_data.csv", numLinesToSkip = 1)
    public void shouldPassTest_whenSolve_given_input(int a, int b, int expected) {
        // given
        // when
        int actual = cut.solve(a, b);

        // then
        assertThat(actual).isEqualTo(expected);
    }

}