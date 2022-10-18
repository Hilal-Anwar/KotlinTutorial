package algorithems

import java.util.*

object Palindrome {
    @JvmStatic
    fun main(args: Array<String>) {
        println("Enter the first   string")
        val a = Scanner(System.`in`).nextLine()
        println("Enter the second   string")
        val b = Scanner(System.`in`).nextLine()
        var max = ""
        var min = ""
        if (a.length == b.length) {
            max = a
            min = b
        }
        if (a.length != b.length) {
            max = if (a.length > b.length) a else b
            min = if (a.length < b.length) a else b
        }
        var S_a: String
        var S_b: String
        var S = ""
        var len_1 = 1
        var len_2 = 2
        while (len_1 <= min.length && len_2 <= max.length) {
            for (i in 0..min.length - len_1) {
                S_a = min.substring(i, i + len_1)
                for (j in 0..max.length - len_2) {
                    S_b = max.substring(j, j + len_2)
                    if (Reverse(S_a + S_b) == S_a + S_b) {
                        S = S_a + S_b
                    } else if (Reverse(S_b + S_a) == S_b + S_a) S = S_b + S_a
                    println(S)
                }
            }
            len_1++
            len_2++
        }
    }

    fun Reverse(s: String?): String {
        return StringBuilder(s).reverse().toString()
    }
}