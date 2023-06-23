package org.example.algorithms

import java.util.*

object Pip {
    @JvmStatic
    fun main(args: Array<String>) {
        val a = TreeSet<String>()
        println("Enter the elements")
        println("Enter /e to exit")
        var Temp: String
        do {
            Temp = Scanner(System.`in`).nextLine()
            if (!Temp.equals("/e", ignoreCase = true)) a.add(Temp)
        } while (!Temp.equals("/e", ignoreCase = true))
        var c = 0
        var g = 1
        val group = ArrayList<Int>()
        for (value in a) {
            for (s in a) {
                if (value.length >= g && s.length > g && value.substring(0, g) == s.substring(0, g)) c++
            }
            if (c > 1) {
                group.add(g)
            }
            g++
        }
        println(group)
        println(g)
    }
}