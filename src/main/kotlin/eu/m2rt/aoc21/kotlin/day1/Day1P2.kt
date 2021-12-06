package eu.m2rt.aoc21.kotlin.day1

import java.io.BufferedReader
import java.io.InputStreamReader

@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
fun main() {
    val bufferedInput = BufferedReader(InputStreamReader(SimpleIncreaseCounter::class.java.getResourceAsStream("input")))

    val counter = SlidingWindowIncreaseCounter()
    bufferedInput.use { input -> input.lines().forEach { counter.count(it.toInt()) } }

    println(counter.current())
}

class SlidingWindowIncreaseCounter(private val size: Int = 3) {

    private var window: List<Int> = listOf()
    private var count: Int = 0

    fun count(value: Int) {
        if (window.size < size ) {
            window = window + value
            return
        }

        val lastSum = window.sum()
        window = window.drop(1) + value
        val sum = window.sum()

        if (sum > lastSum) {
            count++
        }
    }

    fun current(): Int {
        return count
    }
}