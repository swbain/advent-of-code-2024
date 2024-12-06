import kotlin.math.absoluteValue

fun main() {
    fun input(input: List<String>): List<List<Int>> = input.map { line ->
        line.split(" ").map { it.toInt() }
    }

    fun List<Int>.isSafe(): Boolean {
        val windows = windowed(2).map { it.first() to it.last() }
        var previousDiff = 0
        for ((a, b) in windows) {
            val diff = a - b
            when {
                diff == 0 -> return false
                diff.absoluteValue > 3 -> return false
                diff * previousDiff < 0 -> return false
                else -> previousDiff = diff
            }
        }
        return true
    }

    fun part1(input: List<String>): Int {
        return input(input).count { it.isSafe() }
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    // Or read a large test input from the `src/Day02_test.txt` file:
    val testInput = readInput("Day02_test")
    checkAnswer(2, part1(testInput), 1)

    // Read the input from the `src/Day02.txt` file.
    val input = readInput("Day02")
    "🤠part 1: ${part1(input)} 🤠".println()
    "🤪part 2: ${part2(input)} 🤪".println()
}
