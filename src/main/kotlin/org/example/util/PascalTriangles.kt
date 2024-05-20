package org.example.util

/**
 * @author hilal on 29-01-2023
 * @project Java_tutorials
 */
object PascalTriangles {
    @JvmStatic
    fun main(args: Array<String>) {
        drawPascalTriangle(10)
        drawPascalTriangle(25)
    }

    private fun drawPascalTriangle(size: Int) {
        var start = size
        var end = size
        var `val` = longArrayOf()
        val max = ("" + pascal(longArrayOf(1), 0, size)[size / 2]).length
        for (i in 0..size) {
            var c = 0
            var k = 0
            `val` = pascal(`val`, 0, 0)
            for (j in 0..end) {
                if (j >= start) {
                    if (c == 0) {
                        print(adjustSpace("" + `val`[k], max))
                        c = 1
                        k++
                    } else {
                        print(adjustSpace(" ", max))
                        c = 0
                    }
                } else print(adjustSpace(" ", max))
            }
            start -= 1
            end += 1
            println()
        }
    }

    private fun adjustSpace(s: String, max: Int): String {
        return s + " ".repeat(max - s.length)
    }

    private fun pascal(a: LongArray, index: Int, maxSize: Int): LongArray {
        val tem = LongArray(a.size + 1)
        tem[0] = 1
        for (i in 1..<a.size) {
            tem[i] = a[i - 1] + a[i]
        }
        tem[a.size] = 1
        return if (index < maxSize) pascal(tem, index + 1, maxSize) else tem
    }
}