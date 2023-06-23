package org.example.algorithms

import java.util.*

object BuildString {
    @JvmStatic
    fun main(args: Array<String>) {
        var str = StringBuffer()
        var sub = ""
        println("Enter the number of test cases")
        val cases = Scanner(System.`in`).nextInt()
        var sr = ""
        for (k in 1..cases) {
            println("Enter a s ")
            val s = Scanner(System.`in`).nextLine()
            println("Enter the price for entering a s at end")
            val a = Scanner(System.`in`).nextInt()
            var TotalScore = 0
            println("Enter the price for entering te substring at end")
            val b = Scanner(System.`in`).nextInt()
            var i = 0
            while (i < s.length) {
                for (j in i until s.length) {
                    sr += s[j]
                    if (str.toString().contains(sr)) sub = sr else {
                        sr = ""
                        break
                    }
                }
                if (sub.length > 1) {
                    TotalScore += b
                    str.append(sub)
                    i = i + sub.length - 1
                } else {
                    TotalScore += a
                    if (sub == "") str.append(s[i]) else {
                        str.append(sub)
                    }
                }
                sub = ""
                i++
            }
            println(TotalScore)
            sr = ""
            sub = ""
            str = StringBuffer()
        }
    }
}