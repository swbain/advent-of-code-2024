fun main() {
    fun part1(input: List<String>): Int {
        return input.size
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    val testInput = readInput("Day03_test")
    checkAnswer(2, part1(testInput), 1)

    val input = readInput("Day03")
    "🤠part 1: ${part1(input)} 🤠".println()
    "🤪part 2: ${part2(input)} 🤪".println()
}
