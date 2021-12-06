package eu.m2rt.aoc21.kotlin.day3

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class Day3P1Test {

    @Test
    fun asd1() {
        test(
            5,
            listOf(
                0b00100,
                0b11110,
                0b10110,
                0b10111,
                0b10101,
                0b01111,
                0b00111,
                0b11100,
                0b10000,
                0b11001,
                0b00010,
                0b01010
            ),
            198
        )
    }

    private fun test(
        bits: Int,
        input: List<Int>,
        expected: Int
    ) {
        val report = PowerConsumption(bits)

        input.forEach { report.feed(it) }

        assertEquals(
            expected,
            report.get()
        )
    }
}