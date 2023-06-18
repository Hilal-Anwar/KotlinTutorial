package org.example.algorithems

import java.util.*

object KickStart {
    @JvmStatic
    fun main(args: Array<String>) {
        var group = 0
        var score = 0
        var prefix_1: String
        var prefix_2: String
        val a = ArrayList<String>()
        val ho = ArrayList<String>()
        val it = ArrayList<Int>()
        println("Enter the number of elements")
        val size = Scanner(System.`in`).nextInt()
        println("Enter the elements one by one up to the number of elements entered above")
        for (x in 0 until size) a.add(Scanner(System.`in`).nextLine())
        println("Enter the group size")
        val gSize = Scanner(System.`in`).nextInt()
        for (x in a) group = Math.max(group, x.length)
        for (k in group downTo 1) {
            for (i in a.indices) {
                for (j in a.indices) {
                    if (a[i].length >= k && a[j].length >= k) {
                        prefix_1 = a[i].substring(0, k)
                        prefix_2 = a[j].substring(0, k)
                        if (i != j && prefix_1.equals(prefix_2, ignoreCase = true)) {
                            if ((!ho.contains(a[i]) || !it.contains(i)) && ho.size < gSize) {
                                ho.add(a[i])
                                it.add(i)
                            }
                            if ((!ho.contains(a[j]) || !it.contains(j)) && ho.size < gSize) {
                                ho.add(a[j])
                                it.add(j)
                            }
                        }
                    }
                }
            }
            if (gSize == ho.size) {
                for (s in ho) a.remove(s)
                println("Score  $k")
                score = score + k
                println(ho)
            }
            ho.clear()
            it.clear()
        }
        println("Total score of DataStructure.Pip is  $score")
    }
}