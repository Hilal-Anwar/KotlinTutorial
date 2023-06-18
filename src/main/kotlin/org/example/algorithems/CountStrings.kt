package org.example.algorithems

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
        for (i in 0 until string.length) {
            abb = string.substring(0, i + 1)
            for (j in 0..string.length - abb.length) {
                sub = string.substring(j, j + abb.length)
                if (sub == abb) {
                    point = point + abb.length
                }
            }
            functionalValue.add(point)
            point = 0
        }
        println(functionalValue)
    }
}