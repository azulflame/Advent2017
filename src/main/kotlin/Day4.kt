package me.toddbensmiller.advent

/*
 * Created by Todd on 12/9/2020.
 */
fun day4(): Pair<Number, Number>
{
	return Pair(day4part1(ListHolder.day4), day4part2(ListHolder.day4))
}

fun day4part1(input: List<String>): Number
{
	return input.filter { x -> (x.split(" ").distinct().count() == x.split(" ").count()) }.count()
}

fun day4part2(input: List<String>): Number
{
	return input.filter { x ->
		(x.split(" ").map { it.toCharArray().sorted().joinToString() }.distinct().count() == x.split(" ")
			.map { it.toCharArray().sorted().joinToString().count() }.count())
	}.count()
}
