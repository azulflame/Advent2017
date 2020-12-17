package me.toddbensmiller.advent

fun day2(): Pair<Number, Number>
{
	return Pair(day2part1(ListHolder.day2), day2part2(ListHolder.day2))
}

fun day2part1(input: List<String>): Number
{
	return input.map { a -> a.split("\t").map { b -> b.toInt() } }
		.sumOf { c -> c.maxOf { d -> d } - c.minOf { e -> e } }
}

fun day2part2(input: List<String>): Number
{
	val i = input.map { a -> a.split("\t").map { b -> b.toInt() } }.sumBy { getRowVal(it) }
	return i
}

fun getRowVal(row: List<Int>): Int
{
	for (x in row.indices)
	{
		for (y in row.indices.minus(x))
		{
			if ((row[x] % row[y] == 0) && (row[x] / row[y] > 1))
			{
				return row[x] / row[y]
			}
		}
	}
	throw Exception()
	return 0
}