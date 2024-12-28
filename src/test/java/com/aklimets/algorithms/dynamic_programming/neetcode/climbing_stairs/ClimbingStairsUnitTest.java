package com.aklimets.algorithms.dynamic_programming.neetcode.climbing_stairs;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.assertj.core.api.Assertions.assertThat;

class ClimbingStairsUnitTest {

    private final ClimbingStairs cut = new ClimbingStairs();

    @ParameterizedTest
    @CsvFileSource(resources = "/dynamic_programming/climbing_stairs.csv", numLinesToSkip = 1)
    public void shouldPassTest_whenClimbStairs_givenInput(int n, int expected) {
        // given

        // when
        long actual = cut.climbStairs(n);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/dynamic_programming/climbing_stairs.csv", numLinesToSkip = 1)
    public void shouldPassTest_whenClimbStairs2_givenInput(int n, int expected) {
        // given

        // when
        long actual = cut.climbStairs2(n);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/dynamic_programming/climbing_stairs.csv", numLinesToSkip = 1)
    public void shouldPassTest_whenClimbStairs3_givenInput(int n, int expected) {
        // given

        // when
        long actual = cut.climbStairs3(n);

        // then
        assertThat(actual).isEqualTo(expected);
    }

}