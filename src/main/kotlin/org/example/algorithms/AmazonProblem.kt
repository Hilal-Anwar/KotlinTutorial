package org.example.algorithms

import java.util.*

object AmazonProblem {
    @JvmStatic
    fun main(args: Array<String>) {
        println("Enter the natural number")
        val number = Scanner(System.`in`).nextInt()
        println(org.example.algorithms.AmazonProblem.Num_Way(number))
    }

    private fun Num_Way(number: Int): Int {
        var way = 0
        for (i in 1..number) {
            for (j in 0..number) {
                if (i + j * 2 == number) way++
            }
        }
        return way
    }
}
