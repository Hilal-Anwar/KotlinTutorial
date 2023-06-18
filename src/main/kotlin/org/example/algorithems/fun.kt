package org.example.algorithems

object `fun` {
    fun fab(a: Long, b: Long, len: Long): Long {
        if (len >= 1) print(fab(b, a + b, len - 1).toString() + ",")
        return a + b
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println(fab(0, 1, 10))
    }
}