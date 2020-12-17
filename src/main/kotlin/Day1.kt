/*
 * Created by Todd on 12/9/2020.
 */
package me.toddbensmiller.advent
fun day1(): Pair<Number, Number>
{
	return Pair(day1part1(ListHolder.day1), day1part2(ListHolder.day1))
}

fun day1part1(input: List<String>): Number
{
	val tempList = input.first().toCharArray().map { it.toInt() - 48}
	return tempList.filterIndexed{ i,x -> x == tempList[(i+1)%tempList.size]}.sumOf { it}
}

fun day1part2(input: List<String>): Number
{
	val tempList = input.first().toCharArray().map { it.toInt() - 48}
	val jump = tempList.size / 2
	return tempList.filterIndexed{ i,x -> x == tempList[(i+jump)%tempList.size]}.sumOf { it}
}