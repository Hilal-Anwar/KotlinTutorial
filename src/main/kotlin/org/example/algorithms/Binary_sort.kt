package org.example.algorithms

import java.util.*

object Binary_sort {
    @JvmStatic
    fun main(args: Array<String>) {
        val b = org.example.algorithms.Binary_sort.randomArray(100000)
        org.example.algorithms.Binary_sort.tree_sort(b)
        println(Arrays.toString(b))
        println("ddd")
    }

    private fun tree_sort(a: IntArray) {
        val dummy = arrayOfNulls<IntArray>(2 * a.size)
        var start = a.size
        var end = a.size
        dummy[start] = intArrayOf(a[0])
        for (i in 1 until a.size) {
            if (dummy[start]!![0] > a[i]) {
                start--
                dummy[start] = intArrayOf(a[i])
            } else if (dummy[end]!![0] < a[i]) {
                end++
                dummy[end] = intArrayOf(a[i])
            }
        }
        //System.out.println(Arrays.deepToString(dummy));
    }

    private fun randomArray(n: Int): IntArray {
        val a = IntArray(n)
        for (j in 0 until n) {
            val con = (Math.random() * (n - j) + 2).toInt()
            a[j] = con
        }
        println("Array is filled")
        return a
    }
}