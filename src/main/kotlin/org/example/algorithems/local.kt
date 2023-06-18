package org.example.algorithems

object local {
    @JvmStatic
    fun main(args: Array<String>) {
        val a = arrayOf(arrayOf("*", "*", "*"), arrayOf("*", "*", "*"), arrayOf("*", "*", "*"))
        val b = arrayOf(arrayOf("*", "*", "*"), arrayOf("*", "*", "*"), arrayOf("*", "*", "*"))
        val x = ArrayList<Array<Array<String>>>()
        x.add(a)
        x.add(b)
        var r = 0
        var l = 0
        val ab = Array(3) { arrayOfNulls<String>(6) }
        for (i in 0..2) {
            for (j in 0..5) {
                val k = x[r]
                ab[i][j] = k[i][l]
                if ((j + 1) % 3 == 0) {
                    l = 0
                    r++
                } else l++
            }
            r = 0
        }
        for (i in 0..2) {
            for (j in 0..5) {
                print(ab[i][j] + " ")
            }
            println()
        }
    }
}