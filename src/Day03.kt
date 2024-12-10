fun main() {
    fun String.pair(): Pair<Int, Int> {
        return removePrefix("mul(")
            .removeSuffix(")")
            .split(",")
            .let { nums -> nums.first().toInt() to nums.last().toInt() }
    }

    fun part1(input: String): Int {
        val regex = Regex("""mul\(\d{1,3},\d{1,3}\)""")
        return regex.findAll(input).map { it.value.pair() }.toList().sumOf { (a, b) -> a * b }
    }

    fun part2(input: String): Int {
        val regex = Regex("""mul\(\d{1,3},\d{1,3}\)|do\(\)|don't\(\)""")
        val commands = regex.findAll(input).map { it.value }
        val pairs = mutableListOf<Pair<Int, Int>>()
        var shouldAdd = true
        for (command in commands) {
            if (command == "don't()") {
                shouldAdd = false
            } else if (command == "do()") {
                shouldAdd = true
            } else if (shouldAdd) {
                pairs.add(command.pair())
            }
        }

        return pairs.sumOf { (a, b) -> a * b }
    }

    val testInput = readFullInput("Day03_test")
    checkAnswer(expected = 161, actual = part1(testInput), part = 1)

    val testInput2 = readFullInput("Day03_test2")
    checkAnswer(expected = 48, actual = part2(testInput2), part = 2)

    val input = readFullInput("Day03")
    "🤠part 1: ${part1(input)} 🤠".println()
    "🤪part 2: ${part2(input)} 🤪".println()
}
