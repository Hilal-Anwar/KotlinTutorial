package algorithems

import java.io.IOException
import java.util.*

object pattern {
    @Throws(IOException::class, InterruptedException::class)
    @JvmStatic
    fun main(args: Array<String>) {
        println("Enter the size")
        var condition = true
        val size = Scanner(System.`in`).nextInt()
        var i = 1
        while (i <= size / 2) {
            if (condition) circle(size, size - 2 * i + 1, 2 * i) else hollow(size, i)
            if (i == size / 2) {
                i = 1
                condition = !condition
            }
            Thread.sleep(200)
            clrscr()
            i++
        }
    }

    fun hollow(size: Int, begin: Int) {
        for (i in 1..size) {
            for (j in 1..size) {
                if (i == begin && j >= begin && j <= size - begin + 1) print(" * ") else if (i > begin && i < size - begin + 1 && (j == begin || j == size - begin + 1)) print(
                    " * "
                ) else if (i == size - begin + 1 && j >= begin && j <= size - begin + 1) print(" * ") else print("   ")
            }
            println()
        }
    }

    fun filled(size: Int, begin: Int) {
        for (i in 1..size) {
            for (j in 1..size) {
                if (i == begin && j >= begin && j <= size - begin + 1) print("   ") else if (i > begin && i < size - begin + 1 && (j == begin || j == size - begin + 1)) print(
                    "   "
                ) else if (i == size - begin + 1 && j >= begin && j <= size - begin + 1) print("   ") else print(" * ")
            }
            println()
        }
    }

    fun circle(size: Int, d: Int, begin: Int) {
        var k = 1
        for (i in 1..size) {
            for (j in 1..size) {
                if (i >= begin && i <= d) {
                    if (j > value(d / 2, k) && j <= cord(d / 2, k)) print(" * ") else print("   ")
                } else print("   ")
            }
            if (i in begin..d) k++
            println()
        }
    }

    @Throws(IOException::class, InterruptedException::class)
    fun clrscr() {
        ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor()
    }

    fun value(r: Int, i: Int): Int {
        return Math.round(r - Math.sqrt((r * r - (r - i) * (r - i)).toDouble())).toInt()
    }

    fun cord(r: Int, i: Int): Int {
        return Math.round(2 * Math.sqrt((r * r - (r - i) * (r - i)).toDouble())).toInt()
    }
}