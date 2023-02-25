package util

/**
 * @author hilal on 31-01-2023
 * @project Java_tutorials
 */
object SierpinskiTriangle {
    @JvmStatic
    fun main(args: Array<String>) {
        val value = args[0].toInt()
        println(sierpinski_triangle(value))
    }

    fun sierpinski_triangle(size: Int): String {
        var start = size
        var end = size
        val s = StringBuilder()
        var `val` = longArrayOf()
        var t = 0
        for (i in 0..size) {
            var c = 0
            var k = 0
            `val` = pascal(`val`)
            for (j in 0..end) {
                if (j >= start) {
                    if (c == 0) {
                        val num = `val`[k]
                        s.append(if (num == 1.toLong()) getColor(t) + num + "\u001b[0m" else " ")
                        c = 1
                        k++
                    } else {
                        s.append(" ")
                        c = 0
                    }
                } else s.append(" ")
            }
            if ((i + 1) % 4 == 0) {
                t = if (t == 7) 0 else t + 1
            }
            start = start - 1
            end = end + 1
            s.append('\n')
        }
        return s.toString()
    }

    fun pascal(a: LongArray): LongArray {
        val tem = LongArray(a.size + 1)
        tem[0] = 1
        for (i in 1 until a.size) {
            tem[i] = (a[i - 1] + a[i]) % 2
        }
        tem[a.size] = 1
        return tem
    }

    fun getColor(i: Int): String {
        val color = arrayOf(
            "\u001b[0;31m", "\u001b[0;32m",
            "\u001b[0;33m", "\u001b[0;34m", "\u001b[0;35m",
            "\u001b[0;36m", "\u001b[0;97m", "\u001b[0;96m"
        )
        return color[i]
    }
}