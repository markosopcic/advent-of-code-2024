import kotlin.math.abs

fun main() {
    fun List<Int>.isSafe(): Boolean {
        val differences = windowed(2).map { it[1] - it[0] }
        return differences.all { it > 0 && it <= 3 } || differences.all { it < 0 && it >= -3 }
    }

    fun List<Int>.isSafeWithDampener(): Boolean {
        if (isSafe())
            return true;

        for (index in indices) {
            val withoutIndex = filterIndexed { i, _ -> i != index }
            if (withoutIndex.isSafe())
                return true
        }
        return false
    }

    fun part1(input: List<String>): Int {
        return input.map { it.split("\\s+".toRegex()).map { it.toInt() } }.count { it.isSafe() }
    }

    fun part2(input:List<String>): Int = input.map { it.split("\\s+".toRegex()).map { it.toInt() } }.count{it.isSafeWithDampener()}

    val input = readInput("Day02")
    part1(input).println()
    part2(input).println()
}
