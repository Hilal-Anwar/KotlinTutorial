package util

import java.util.*

/**
 * @author hilal on 11-01-2023
 * @project Java_tutorials
 */
object ArrayString {
    @JvmStatic
    fun main(args: Array<String>) {
        val s = "Mahendra Singh Pansingh Dhoni"
        println(s.endsWith("Dhoni"))
        println(isAllElementsEqual(intArrayOf(5, 3), intArrayOf(3, 5)))
    }

    fun isAllElementsEqual(a: IntArray, b: IntArray): Boolean {
        Arrays.sort(a)
        Arrays.sort(b)
        return (a.size == b.size
                && Arrays.equals(a, b))
    }
}