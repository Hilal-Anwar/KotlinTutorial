package org.example.algorithems

object circle {
    @JvmStatic
    fun main(args: Array<String>) {
        for (i in 0..50) {
            for (j in 0..50) {
                if (j > value(2, i) && j <= cord(2, i)) print(" . ") else print("   ")
            }
            println()
        }
    }

    fun value(r: Int, i: Int): Int {
        return Math.round(r - Math.sqrt((r * r - (r - i) * (r - i)).toDouble())).toInt()
    }

    fun cord(r: Int, i: Int): Int {
        return Math.round(2 * Math.sqrt((r * r - (r - i) * (r - i)).toDouble())).toInt()
    }
}