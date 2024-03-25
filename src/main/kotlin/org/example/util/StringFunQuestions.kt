package org.example.util

import java.util.*

internal class StringFunQuestions:KRunnable {
    fun countWords(str: String): Long {
        return Arrays.stream(str.split("[\\s,.\\d\n]".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray())
            .filter { str: String -> isNotEmpty(str) }
            .count()
    }

    fun charFrequency(str: String): String {
        val a = str.toCharArray()
        Arrays.sort(a)
        var count = 0
        var `val`: Char = a[0]
        val va = StringBuilder()
        for (c in a) {
            if (`val` != c) {
                va.append(`val`)
                    .append("=")
                    .append(count)
                    .append(" ,")
                `val` = c
                count = 0
            }
            count++
        }
        va.append(a[a.size - 1]).
        append("=").append("1")
        return "{$va}"
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val st = StringFunQuestions()
            Util.println("Number of words in your sentence are:")
            println(st.countWords("  I love    to    code"))
            println(st.charFrequency("Pineapple"))
        }

        fun isNotEmpty(str: String): Boolean {
            return str.isNotEmpty()
        }
    }

    override fun invoke() {
        TODO("Not yet implemented")
    }
}