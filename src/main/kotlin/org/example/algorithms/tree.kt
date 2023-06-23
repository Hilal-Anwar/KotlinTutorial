package org.example.algorithms

object tree {
    @JvmStatic
    fun main(args: Array<String>) {
        val a = 6
        val b = 6
        val data = arrayOf(
            arrayOf(" 1 ", " 2 ", " 3 ", " 4 ", " 5 ", " 6 "),
            arrayOf(" 7 ", " 8 ", " 9 ", " 10 ", " 11 ", " 12 "),
            arrayOf(" 13 ", " 14 ", " 15 ", " 16 ", " 17 ", " 18 "),
            arrayOf(" 19 ", " 20 ", " 21 ", " 22 ", " 23 ", " 24 "),
            arrayOf(" 25 ", " 26 ", " 27 ", " 28 ", " 29 ", " 30 "),
            arrayOf(" 31 ", " 32 ", " 33 ", " 34 ", " 35 ", " 36 ")
        )
        var M = a
        var N = b
        var x = a
        var y = b
        var k_1 = 0
        var k_2 = 0
        while (M > 1 && N > 1) {
            rectangle(data, k_1, k_2, x, y)
            k_1++
            k_2++
            x--
            y--
            M = M - 2
            N = N - 2
        }
        for (i in 0..5) {
            for (j in 0..5) {
                print(data[i][j])
            }
            println()
        }
    }

    fun rectangle(ar: Array<Array<String>>, k1: Int, k2: Int, x: Int, y: Int) {
        var i: Int
        var j: Int
        var l: Int
        var m: Int
        var tem1: String
        var tem2: String
        tem1 = ar[k1][k2]
        ar[k1][k2] = ar[k1][k2 + 1]
        i = k2 + 1
        while (i < y) {
            tem2 = ar[i][k1]
            ar[i][k1] = tem1
            tem1 = tem2
            i++
        }
        i--
        j = k1 + 1
        while (j < x) {
            tem2 = ar[i][j]
            ar[i][j] = tem1
            tem1 = tem2
            j++
        }
        j--
        l = y - 1
        while (l > k2) {
            tem2 = ar[l][j]
            ar[l][j] = tem1
            tem1 = tem2
            l--
        }
        m = x - 1
        while (m > k1) {
            tem2 = ar[l][m]
            ar[l][m] = tem1
            tem1 = tem2
            m--
        }
    }
}
