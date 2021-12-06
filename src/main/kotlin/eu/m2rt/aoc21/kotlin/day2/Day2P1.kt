package eu.m2rt.aoc21.kotlin.day2

import eu.m2rt.aoc21.kotlin.day2.Direction.*
import java.io.BufferedReader
import java.io.InputStreamReader

@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
fun main() {
    val bufferedInput = BufferedReader(InputStreamReader(Submarine::class.java.getResourceAsStream("input")))

    val submarine = Submarine()
    bufferedInput.use { input -> input.lines().map { Command.parse(it) }.forEach { submarine.move(it) } }

    println(submarine.multipliedPositions())
}


class Submarine {

    private var horizontal: Int = 0
    private var depth: Int = 0

    fun move(command: Command) = when (command.direction) {
        FORWARD -> horizontal += command.speed
        UP -> depth -= command.speed
        DOWN -> depth += command.speed
    }

    fun multipliedPositions(): Int {
        return horizontal * depth
    }
}

enum class Direction { FORWARD, UP, DOWN }

data class Command(val direction: Direction, val speed: Int) {
    companion object {
        fun parse(string: String): Command {
            val pieces = string.split(" ")
            return Command(
                valueOf(pieces[0].uppercase()),
                pieces[1].toInt()
            )
        }
    }
}