package org.example.algorithms

import java.util.*

fun main() {
    var month: Int
    Scanner(System.`in`).use { `in` ->
        month = `in`.nextInt()
        val season = when (month) {
            12, 1, 2 -> "Winter"
            3, 4, 5 -> "Spring"
            6, 7, 8 -> "Summer"
            9, 10, 11 -> "Autumn"
            else -> "Bogus Month"
        }
        print("It is $season")
    }
}