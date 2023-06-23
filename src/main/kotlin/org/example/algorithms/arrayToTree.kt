package org.example.algorithms

import java.util.*

object arrayToTree {
    @JvmStatic
    fun main(args: Array<String>) {
        val a = arrayOfNulls<Int>(100)
        val b = arrayOf(arrayOf(1.0, 2.0, 4.0), arrayOf(1.0, 2.0, 4.0))
        val list = Arrays.asList(*b[0])
        println(list.size.toString() + " " + b.size)
        Arrays.setAll(a) { i: Int -> i + 1 }
        Arrays.sort(a)
        Arrays.stream(a).forEach { x: Int? -> println(x) }
        println(Arrays.binarySearch(a, 9839))
        println("done")
    }
}