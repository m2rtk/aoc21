package eu.m2rt.aoc21.kotlin.day1

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class Day1P2Test {

    @ParameterizedTest
    @CsvSource(value = [
        "1, 0",
        "1;2, 0",
        "1;1, 0",
        "2;1, 0",
        "1;2;3;4, 1",
        "4;3;2;1, 0",
        "1;2;2;4, 1",
        "1;2;2;2, 1",
        "199;200;208;210;200;207;240;269;260;263, 5"
    ])
    fun asd(input: String, expected: Int) {
        val values = input.split(";").map { it.toInt() }.toList()

        assertEquals(expected, countIncreases(values))
    }

    private fun countIncreases(values: Iterable<Int>): Int {
        val counter = SlidingWindowIncreaseCounter()

        values.forEach { counter.count(it) }

        return counter.current()
    }
}