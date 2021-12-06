package eu.m2rt.aoc21.kotlin.day3

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.pow

@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
fun main() {
    val bufferedInput = BufferedReader(InputStreamReader(PowerConsumption::class.java.getResourceAsStream("input")))

    val powerConsumption = PowerConsumption(12)
    bufferedInput.use { input -> input.lines().map { it.toInt(2) }.forEach { powerConsumption.feed(it) } }

    println(powerConsumption.get())
}

infix fun Int.toThePowerOf(exponent: Int): Int = toDouble().pow(exponent).toInt()

class PowerConsumption(private val bits: Int) {

    private var gammaCounter = mutableListOf<Int>()

    init {
        for (i in 0 until bits) {
            gammaCounter.add(i, 0)
        }
    }

    fun feed(number: Int) {

        for (i in 0 until bits) {
            val bit = 2 toThePowerOf i
            val result = (number and bit) == bit
            if (result) print(1) else print(0)

            if (result) {
                gammaCounter[bits - 1 - i] += 1
            } else {
                gammaCounter[bits - 1 - i] -= 1
            }
        }

        println()
    }

    fun get(): Int {
        val gamma = gammaCounter.map { if (it > 0) 1 else 0  }.joinToString("").toInt(2)
        val epsilon = gammaCounter.map { if (it > 0) 0 else 1  }.joinToString("").toInt(2)

        return  gamma * epsilon
    }
}