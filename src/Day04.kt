fun main() {

    fun part1(input: List<String>): Int {
        return input.size
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    val testInput = readInput("Day04_test")
    checkAnswer(expected = 1, actual = part1(testInput), part = 1)
    checkAnswer(expected = 1, actual = part2(testInput), part = 2)

    val input = readInput("Day03")
    "🤠part 1: ${part1(input)} 🤠".println()
    "🤪part 2: ${part2(input)} 🤪".println()
}
