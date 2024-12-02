import kotlin.math.abs

fun main() {
    fun part1(input: List<String>): Long {
        val (first, second) = input.map { it.split("\\s+".toRegex()).withIndex() }.flatten().groupBy { it.index }
            .map { it.value.map { it.value.toLong() }.sorted() }
        return first.zip(second).sumOf { abs(it.first - it.second) }
    }

    fun part2(input: List<String>): Long {
        val (first, second) = input.map { it.split("\\s+".toRegex()).withIndex() }.flatten().groupBy { it.index }
            .map { it.value.map { it.value.toLong() } }

        val secondMap = mutableMapOf<Long, Int>()
        for(num in second){
            secondMap[num] = secondMap.getOrDefault(num, 0) + 1
        }
        return first.sumOf { it * secondMap.getOrDefault(it, 0) }
    }

    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}
