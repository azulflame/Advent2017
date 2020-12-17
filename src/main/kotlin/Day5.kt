package me.toddbensmiller.advent

/*
 * Created by Todd on 12/9/2020.
 */
fun day5(): Pair<Number, Number>
{
	return Pair(day5part1(ListHolder.day5), day5part2(ListHolder.day5))
}

fun day5part1(input: List<String>): Number
{
	var index = 0
	var count = 0
	val tape: HashMap<Int,Int> = HashMap()
	input.forEachIndexed { i,x -> tape[i] = x.toInt()}
	while(index < input.size)
	{
		count++
		val temp: Int = tape[index]!!
		tape[index] = tape[index]!!+1
		index += temp
	}
	return count
}
fun day5part2(input: List<String>): Number
{
	var index = 0
	var count = 0
	val tape: HashMap<Int,Int> = HashMap()
	input.forEachIndexed { i,x -> tape[i] = x.toInt()}
	while(index < input.size)
	{
		count++
		val temp: Int = tape[index]!!
		tape[index] = when
		{
			tape[index]!! < 3 -> tape[index]!!+1
			else -> tape[index]!!-1
		}
		index += temp
	}
	return count
}