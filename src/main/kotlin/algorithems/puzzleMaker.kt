package algorithems

import java.util.*

object puzzleMaker {
    var slide_position = intArrayOf(0, 1)
    var puzzle =
        arrayOf(intArrayOf(0, 1, 2, 3), intArrayOf(4, 5, 6, 7), intArrayOf(8, 9, 10, 11), intArrayOf(12, 13, 14, 15))

    @JvmStatic
    fun main(args: Array<String>) {
        var initial = ""
        for (i in 0..25599) {
            val positions = getPositions(puzzle, slide_position)
            positions.remove(initial)
            val direction = positions.keys.toTypedArray()[(Math.random() * positions.size).toInt()]
            println(positions)
            println(direction)
            initial = direction_reversed(direction)
            if (direction == "right") move_right((Math.random() * positions[direction]!!).toInt() + 1)
            if (direction == "left") move_left((Math.random() * positions[direction]!!).toInt() + 1)
            if (direction == "up") move_up((Math.random() * positions[direction]!!).toInt() + 1)
            if (direction == "down") move_down((Math.random() * positions[direction]!!).toInt() + 1)
            println(getPuzzle())
        }
    }

    private fun direction_reversed(direction: String): String {
        if (direction == "up") return "down"
        if (direction == "down") return "up"
        if (direction == "right") return "left"
        return if (direction == "left") "right" else direction
    }

    private fun getPuzzle(): ArrayList<Int> {
        val arrayList = ArrayList<Int>()
        for (ints in puzzle) {
            for (j in puzzle.indices) {
                arrayList.add(ints[j])
            }
        }
        return arrayList
    }

    private fun move_down(end_point: Int) {
        var i: Int
        i = slide_position[0]
        while (i < slide_position[0] + end_point) {
            val tem = puzzle[i + 1][slide_position[1]]
            puzzle[i + 1][slide_position[1]] = puzzle[i][slide_position[1]]
            puzzle[i][slide_position[1]] = tem
            i++
        }
        slide_position[0] = i
    }

    private fun move_up(end_point: Int) {
        var i: Int
        i = slide_position[0]
        while (i > slide_position[0] - end_point) {
            val tem = puzzle[i - 1][slide_position[1]]
            puzzle[i - 1][slide_position[1]] = puzzle[i][slide_position[1]]
            puzzle[i][slide_position[1]] = tem
            i--
        }
        slide_position[0] = i
    }

    private fun move_left(end_point: Int) {
        var i: Int
        i = slide_position[1]
        while (i > slide_position[1] - end_point) {
            val tem = puzzle[slide_position[0]][i - 1]
            puzzle[slide_position[0]][i - 1] = puzzle[slide_position[0]][i]
            puzzle[slide_position[0]][i] = tem
            i--
        }
        slide_position[1] = i
    }

    private fun move_right(end_point: Int) {
        var i: Int
        i = slide_position[1]
        while (i < slide_position[1] + end_point) {
            val tem = puzzle[slide_position[0]][i + 1]
            puzzle[slide_position[0]][i + 1] = puzzle[slide_position[0]][i]
            puzzle[slide_position[0]][i] = tem
            i++
        }
        slide_position[1] = i
    }

    private fun getPositions(puzzle: Array<IntArray>, pos: IntArray): TreeMap<String, Int> {
        val locations = TreeMap<String, Int>()
        //for down position
        if (pos[0] != 0) locations["up"] = pos[0]
        //for left position
        if (pos[1] != 0) locations["left"] = pos[1]
        //down position
        if (puzzle.size - 1 - pos[0] != 0) locations["down"] = puzzle.size - 1 - pos[0]
        //right position
        if (puzzle.size - 1 - pos[1] != 0) locations["right"] = puzzle.size - 1 - pos[1]
        return locations
    }
}