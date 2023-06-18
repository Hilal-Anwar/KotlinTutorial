package org.example.algorithems

import java.io.IOException

object Lines {
    @Throws(IOException::class, InterruptedException::class)
    @JvmStatic
    fun main(args: Array<String>) {
        var slope = 1
        var x = -10
        var y = -10
        while (true) {
            x = (Math.random() * 80 - 1).toInt()
            y = (Math.random() * 30 - 1).toInt()
            draw_line(80, 30, x, y, slope.toDouble())
            Thread.sleep(200)
            cls()
            slope = (Math.random() * 2 - 1).toInt()
        }
    }

    @Throws(IOException::class, InterruptedException::class)
    private fun cls() {
        ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor()
    }

    fun draw_line(xLimit: Int, yLimit: Int, x: Int, y: Int, slope: Double) {
        var x = x
        var y = y
        x = x + xLimit / 2
        y = y + yLimit / 2
        val str = StringBuilder()
        var ch = if (slope < 0) "/" else "\\"
        if (slope == 0.0) ch = "-"
        if (java.lang.Double.isNaN(slope)) ch = "|"
        for (i in 1..yLimit) {
            for (j in 1..xLimit) {
                if (j == xLimit / 2) str.append("|") else if (i == yLimit / 2) str.append("-")
                else if (java.lang.Double.isNaN(
                        slope
                    ) && j == x || (i - y).toDouble() == slope * (j - x)
                ) str.append(ch) else str.append(" ")
            }
            str.append("\n")
        }
        println(str)
    }
}