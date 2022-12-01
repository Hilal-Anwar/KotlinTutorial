package tutorial1

import java.util.*

internal class HeapAlgo {
    fun printArr(a: IntArray?, n: Int) {
        /*for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();*/
    }

    // Generating permutation using Heap Algorithm
    fun heapPermutation(a: IntArray, size: Int) {
        if (size == 1) println(a.contentToString()) else {
            for (i in 0 until size) {
                heapPermutation(a, size - 1)
                var temp: Int
                if (size % 2 != 0) {
                    temp = a[0]
                    a[0] = a[size - 1]
                } else {
                    temp = a[i]
                    a[i] = a[size - 1]
                }
                a[size - 1] = temp
            }
        }
    }

    companion object {
        // Driver tutorials_3
        @JvmStatic
        fun main(args: Array<String>) {
            val obj = HeapAlgo()
            val a = intArrayOf(1, 2, 3, 4)
            val start = System.currentTimeMillis()
            obj.heapPermutation(a, a.size)
            println(System.currentTimeMillis() - start)
        }
    }
}