package me.toddbensmiller.advent

/*
 * Created by Todd on 12/9/2020.
 */
fun day6(): Pair<Number, Number>
{
	return Pair(day6part1(ListHolder.day6), day6part2(ListHolder.day6))
}

fun day6part1(input: List<String>): Number
{
	val arr: Array<Int> = input.first().split("\t").map { it.toInt() }.toTypedArray()
	val seen: MutableList<List<Int>> = mutableListOf()
	while (!hasDuplicate(seen))
	{
		val biggest = arr.indexOf(arr.maxOf { it })
		var index = (biggest + 1) % arr.size
		var remaining = arr[biggest]
		arr[biggest] = 0
		while (remaining > 0)
		{
			arr[index] = arr[index] + 1
			remaining--
			index = (index + 1) % arr.size
		}
		seen.add(arr.toList())
	}
	return seen.size
}

fun day6part2(input: List<String>): Number
{
	val arr: Array<Int> = input.first().split("\t").map { it.toInt() }.toTypedArray()
	val seen: MutableList<List<Int>> = mutableListOf()
	while (!hasDuplicate(seen))
	{
		val biggest = arr.indexOf(arr.maxOf { it })
		var index = (biggest + 1) % arr.size
		var remaining = arr[biggest]
		arr[biggest] = 0
		while (remaining > 0)
		{
			arr[index] = arr[index] + 1
			remaining--
			index = (index + 1) % arr.size
		}
		seen.add(arr.toList())
	}
	val a = seen.size
	val firstduplicate = arr.clone()
	var count = 0
	do
	{
		val biggest = arr.indexOf(arr.maxOf { it })
		var index = (biggest + 1) % arr.size
		var remaining = arr[biggest]
		arr[biggest] = 0
		while (remaining > 0)
		{
			arr[index] = arr[index] + 1
			remaining--
			index = (index + 1) % arr.size
		}
		count++
	}while (!firstduplicate.contentEquals(arr))
	return count
}

fun hasDuplicate(list: List<List<Int>>): Boolean
{
	if(list.size < 2)
	{
		return false
	}
	val lastList = list.last()
	for (x in list.dropLast(1))
	{
		if (x.foldIndexed(true) { i, a, b -> a && x[i] == lastList[i] })
		{
			return true
		}
	}
	return false
}