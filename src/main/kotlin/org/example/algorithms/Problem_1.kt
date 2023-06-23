package org.example.algorithms

import java.util.*

object Problem_1 {
    @JvmStatic
    fun main(args: Array<String>) {
        println("Enter the total number of gene to enter")
        val n = Scanner(System.`in`).nextInt()
        val gene = arrayOfNulls<String>(n)
        val health = IntArray(n)
        println("Enter the gene codes and their health")
        for (r in 0 until n) {
            gene[r] = Scanner(System.`in`).nextLine()
        }
        println("Enter the gene codes and their health")
        for (i in 0 until n) {
            health[i] = Scanner(System.`in`).nextInt()
        }
        println("Enter the number of DNA stands")
        val stand = Scanner(System.`in`).nextInt()
        val DNACode = arrayOfNulls<String>(stand)
        var healthPoint = 0
        for (i in 0 until stand) {
            println("Enter the tutorials_3 for dna")
            val c = Scanner(System.`in`).nextLine()
            var sub = ""
            DNACode[i] = c
            println("Enter the start point of healthy gene")
            val start = Scanner(System.`in`).nextInt()
            println("Enter the end point of healthy gene")
            val end = Scanner(System.`in`).nextInt()
            for (k in 1..c.length) {
                for (l in 0..c.length - k) {
                    sub = c.substring(l, l + k)
                    for (j in start until  end)
                    {
                        if (sub == gene[j])
                            healthPoint += health[j]
                    }
                }
            }
            println(healthPoint)
        }
    }
}