package org.example.util

object Test {
    @JvmStatic
    fun main(args: Array<String>) {
        var st: String
        var code: String
        var k = 0
        for (i in 0..15) {
            for (j in 0..15) {
                code = "" + (i * 16 + j)
                st = "\u001b[38;5;" + code + "m"
                st = "$st$k\u001b[0m  "
                val s = adjustSpace(st, code)
                print(s)
                k++
            }
            println()
        }
    }

    fun adjustSpace(s: String, s1: String): String {
        return s + " ".repeat(3 - s1.length)
    }
}