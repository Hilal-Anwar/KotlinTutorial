package org.example.util

class RotateInnerRectangle {
    fun randomMatrix(size: Int, b: IntArray): Array<Array<String?>> {
        val a = Array(size) { arrayOfNulls<String>(size) }
        for (i in 0 until size) {
            for (j in 0 until size) {
                val x = (Math.random() * 57 + 65).toInt().toChar()
                if (!isValidPoint(b, i, j, size)) a[i][j] = getText("██") else a[i][j] = "  "
            }
        }
        return a
    }

    fun isValidPoint(a: IntArray, i: Int, j: Int, len: Int): Boolean {
        for (k in a.indices) {
            if (j >= a[k] && j <= len - 1 - a[k] &&
                i >= a[k] && i <= len - 1 - a[k])
                if (a[k] == j || a[k] + j == len - 1 || a[k] == i || a[k] + i == len - 1)
                    return false
        }
        return true
    }

    fun printArray(arr: Array<Array<String?>>) {
        val s = StringBuilder()
        for (i in arr.indices) {
            for (j in arr[0].indices) {
                s.append(arr[i][j])
            }
            s.append('\n')
        }
        System.out.println(s)
    }

    fun rotate(a: Array<Array<String?>>, layer: Int) {
        val column = a[0].size - layer - 1
        var tem = swap_along_x(a, layer, column, layer, a[layer][layer])
        tem = swap_along_y(a, layer, column, column, tem)
        tem = swap_along_x(a, column, layer, column, tem)
        swap_along_y(a, column, layer, layer, tem)
    }

    fun swap_along_x(a: Array<Array<String?>>, start: Int, end: Int, y: Int, tem: String?): String? {
        var tem = tem
        var tem1: String? = ""
        if (start < end) {
            for (i in start + 1..end) {
                tem1 = a[y][i]
                a[y][i] = tem
                tem = tem1
            }
        } else {
            for (i in start - 1 downTo end) {
                tem1 = a[y][i]
                a[y][i] = tem
                tem = tem1
            }
        }
        return tem1
    }

    fun swap_along_y(a: Array<Array<String?>>, start: Int, end: Int, x: Int, tem: String?): String? {
        var tem = tem
        var tem1: String? = ""
        if (start < end) {
            for (i in start + 1..end) {
                tem1 = a[i][x]
                a[i][x] = tem
                tem = tem1
            }
        } else {
            for (i in start - 1 downTo end) {
                tem1 = a[i][x]
                a[i][x] = tem
                tem = tem1
            }
        }
        return tem1
    }

    companion object {
        @Throws(InterruptedException::class)
        @JvmStatic
        fun main(args: Array<String>) {
            val a = RotateInnerRectangle()
            val size = 100
            val b = IntArray(size / 2)
            var i = 1
            while (i < size / 2) {
                b[i] = i
                i = i + 2
            }
            val x = a.randomMatrix(size, b)
            while (true) {
                for (i in 0 until size / 2) {
                    a.rotate(x, i)
                }
                Thread.sleep(15)
                print("\u001b[H\u001b[J")
                a.printArray(x)
            }
        }

        fun getText(s: String): String {
            return  /*Color.valueOf("" +
                        Color.values()[(int) (Math.random() * 8)])
                .getColor() + s + "\33[0m"*/getTextColor((Math.random() * 8).toInt(), s)
        }

        fun getTextColor(code: Int, s: String): String {
            return "\u001b[38;5;" + code + "m" + s + "\u001b[0m"
        }
    }
}

internal enum class Color(val color: String) {
    RED("\u001b[0;31m"),  // RED
    GREEN("\u001b[0;32m"),  // GREEN
    YELLOW("\u001b[0;33m"),  // YELLOW
    BLUE("\u001b[0;34m"),  // BLUE
    PURPLE("\u001b[0;35m"),  // PURPLE
    CYAN("\u001b[0;36m"),  // CYAN
    WHITE("\u001b[0;97m"),  // WHITE
    CYAN_BRIGHT("\u001b[0;96m")

}