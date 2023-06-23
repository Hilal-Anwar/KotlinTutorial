package org.example.algorithms

import java.util.*

object CountStrings {
    @JvmStatic
    fun main(args: Array<String>) {
        println("Enter a string")
        val string = Scanner(System.`in`).nextLine()
        var abb = ""
        var sub = ""
        val functionalValue = ArrayList<Int>()
        var point = 0
        for (i in string.indices) {
            abb = string.substring(0, i + 1)
            for (j in 0..string.length - abb.length) {
                sub = string.substring(j, j + abb.length)
                if (sub == abb) {
                    point += abb.length
                }
            }
            functionalValue.add(point)
            point = 0
        }
        println(functionalValue)
    }
}