import kotlin.math.absoluteValue

fun main() {
    fun getLists(input: List<String>): Pair<List<Int>, List<Int>> {
        val first = mutableListOf<Int>()
        val second = mutableListOf<Int>()
        input.forEach {
            val split = it.split(" ").filterNot { item -> item.isEmpty() }
            first.add(split.first().toInt())
            second.add(split.last().toInt())
        }
        return first to second
    }

    fun part1(input: List<String>): Int {
        val (first, second) = getLists(input)
        return first.sorted().zip(second.sorted()).fold(0) { acc, (a, b) -> acc + (a - b).absoluteValue }
    }

    fun part2(input: List<String>): Int {
        val (first, second) = getLists(input)
        val map = first.associateWith { 0 }.toMutableMap()
        second.forEach {
            if (map.containsKey(it)) {
                map[it] = map.getValue(it) + 1
            }
        }
        return first.fold(0) { acc, item -> acc + item * map.getValue(item) }
    }

    // Or read a large test input from the `src/Day01_test.txt` file:
    val testInput = readInput("Day01_test")
    println("test output = ${part1(testInput)}")
    check(part1(testInput) == 11)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day01")
    part1(input).println()

    println("test2 output = ${part2(testInput)}")
    check(part2(testInput) == 31)
    part2(input).println()
}
