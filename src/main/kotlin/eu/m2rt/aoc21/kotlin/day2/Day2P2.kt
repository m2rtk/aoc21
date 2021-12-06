package eu.m2rt.aoc21.kotlin.day2

import eu.m2rt.aoc21.kotlin.day2.Direction.*
import java.io.BufferedReader
import java.io.InputStreamReader

@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
fun main() {
    val bufferedInput = BufferedReader(InputStreamReader(AimedSubmarine::class.java.getResourceAsStream("input")))

    val submarine = AimedSubmarine()
    bufferedInput.use { input -> input.lines().map { Command.parse(it) }.forEach { submarine.move(it) } }

    println(submarine.multipliedPositions())
}


class AimedSubmarine {

    private var horizontal: Int = 0
    private var depth: Int = 0
    private var aim: Int = 0

    fun move(command: Command) = when (command.direction) {
        FORWARD -> {
            horizontal += command.speed
            depth += aim * command.speed
        }
        UP -> aim -= command.speed
        DOWN -> aim += command.speed
    }

    fun multipliedPositions(): Int {
        return horizontal * depth
    }
}