package eu.m2rt.aoc21.kotlin.day2

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class Day2P2Test {

    @Test
    fun asd1() {
        test(
            """
            forward 5
            """.trimIndent(),
            0
        )
    }

    @Test
    fun asd2() {
        test(
            """
            forward 5
            down 5
            """.trimIndent(),
            0
        )
    }

    @Test
    fun asd3() {
        test(
            """
            forward 5
            down 5
            forward 8
            up 3
            down 8
            forward 2
            """.trimIndent(),
            900
        )
    }

    private fun test(input: String, expected: Int) {
        val submarine = AimedSubmarine()

        input.split("\n").map { Command.parse(it) }.forEach { submarine.move(it) }

        assertEquals(
            expected,
            submarine.multipliedPositions()
        )
    }
}