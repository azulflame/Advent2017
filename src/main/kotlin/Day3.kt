package me.toddbensmiller.advent

import java.lang.Math.abs

/*
 * Created by Todd on 12/9/2020.
 */

val NORTH = 0
val SOUTH = 1
val EAST = 2
val WEST = 3

fun day3(): Pair<Number, Number>
{
	return Pair(day3part1(ListHolder.day3), day3part2(ListHolder.day3))
}

// entry point is 1 above the bottom right corner
// moving clockwise
// each "square" contains (2k+1)^2 elements inside of it
fun day3part1(input: List<String>): Number
{
	val arr = Array(10001) { Array(10001) { false } }
	val center = 5000
	arr[center][center] = true
	var xlast = center
	var ylast = center
	var x = center + 1
	var y = center
	var lastDirection = NORTH
	for (a in 2..input.first().toInt())
	{
		xlast = x
		ylast = y
		arr[x][y] = true
		if (lastDirection == WEST)
		{
			when (arr[x][y - 1])
			{
				true -> x--
				false ->
				{
					y--
					lastDirection = SOUTH
				}
			}
		} else if (lastDirection == NORTH)
		{
			when (arr[x - 1][y])
			{
				true -> y++
				false ->
				{
					x--
					lastDirection = WEST
				}
			}
		} else if (lastDirection == EAST)
		{
			when (arr[x][y + 1])
			{
				true -> x++
				false ->
				{
					y++
					lastDirection = NORTH
				}
			}
		} else if (lastDirection == SOUTH)
		{
			when (arr[x + 1][y])
			{
				true -> y--
				false ->
				{
					x++
					lastDirection = EAST
				}
			}
		}
	}
	return kotlin.math.abs(xlast - center) + kotlin.math.abs(ylast-center)
}

fun day3part2(input: List<String>): Number
{
	val arr = Array(10001) { Array(10001) { 0 } }
	val center = 5000
	arr[center][center] = 1
	var xlast = center
	var ylast = center
	var x = center + 1
	var y = center
	var lastDirection = NORTH
	while(arr[xlast][ylast]  in 1..input.first().toInt())
	{
		xlast = x
		ylast = y
		arr[x][y] = sumOfSurrounding(arr,x,y).toInt()
		if (lastDirection == WEST)
		{
			when (arr[x][y - 1] != 0)
			{
				true -> x--
				false ->
				{
					y--
					lastDirection = SOUTH
				}
			}
		} else if (lastDirection == NORTH)
		{
			when (arr[x - 1][y] != 0)
			{
				true -> y++
				false ->
				{
					x--
					lastDirection = WEST
				}
			}
		} else if (lastDirection == EAST)
		{
			when (arr[x][y + 1] != 0)
			{
				true -> x++
				false ->
				{
					y++
					lastDirection = NORTH
				}
			}
		} else if (lastDirection == SOUTH)
		{
			when (arr[x + 1][y] != 0)
			{
				true -> y--
				false ->
				{
					x++
					lastDirection = EAST
				}
			}
		}
	}
	return arr[xlast][ylast]
}

fun sumOfSurrounding(board: Array<Array<Int>>, x: Int, y: Int): Number
{
	var sum = 0
	for(xmod in -1..1)
	{
		for(ymod in -1..1)
		{
			if(xmod != 0 || ymod != 0)
			{
				sum += board[x+xmod][y+ymod]
			}
		}
	}
	return sum
}