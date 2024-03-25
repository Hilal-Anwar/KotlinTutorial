package org.example.util

import java.util.*

object Gender {
    @JvmStatic
    fun main(args: Array<String>) {
        val `in` = Scanner(System.`in`)
        println("Enter M for male")
        println("Enter F for female")
        println("Enter your choice")
        val ch: Char
        ch = `in`.next()[0]
        when (ch) {
            'M' -> println("Your are male")
            'F' -> {
                println("Your are female")
            }

            else -> println("Unknown gender")
        }
    }
}
