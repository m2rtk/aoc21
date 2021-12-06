package eu.m2rt.aoc21.kotlin.day1

import java.io.BufferedReader
import java.io.InputStreamReader

@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
fun main() {
    val bufferedInput = BufferedReader(InputStreamReader(SimpleIncreaseCounter::class.java.getResourceAsStream("input")))

    val counter = SimpleIncreaseCounter()
    bufferedInput.use { input -> input.lines().forEach { counter.count(it.toInt()) } }

    println(counter.current())
}

class SimpleIncreaseCounter {

    private var last: Int? = null
    private var count: Int = 0

    fun count(value: Int) {
        if (last == null) {
            last = value
            return
        }

        if (value > last!!) { // !! because null was checked and last is effectively final
            count++
        }

        last = value
    }

    fun current(): Int {
        return count
    }
}