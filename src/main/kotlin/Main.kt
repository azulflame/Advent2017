/*
 * Created by Todd on 12/9/2020.
 */
package me.toddbensmiller.advent

fun main(args: Array<String>)
{
	runAll().forEachIndexed { i, x ->
		println("Day ${i + 1}")
		println("Part 1: ${x.first}")
		println("Part 2: ${x.second}")
	}
}

fun runAll(): List<Pair<Number, Number>>
{
	return listOf(
		day1(),
		day2(),
		day3(),
		day4(),
		day5(),
		day6()
	)
}