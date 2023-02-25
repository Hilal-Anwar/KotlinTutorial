package util

import java.math.BigInteger

/**
 * @author hilal on 28-01-2023
 * @project Java_tutorials
 */
object Pattern {
    @JvmStatic
    fun main(args: Array<String>) {
        val size = 12
        var start = size
        var end = size
        //System.out.println(combination(BigInteger.valueOf(size), BigInteger.valueOf(size / 2)));
        val max = combination(BigInteger.valueOf(size.toLong()), BigInteger.valueOf((size / 2).toLong())).length
        for (i in 0..size) {
            var c = 0
            var k = 0
            for (j in 0..2 * size) {
                if (j >= start && j <= end) {
                    if (c == 0) {
                        print(
                            adjustSpace(
                                "" + combination(
                                    BigInteger.valueOf(i.toLong()),
                                    BigInteger.valueOf(k.toLong())
                                ), max
                            )
                        )
                        c = 1
                        k++
                    } else {
                        print(adjustSpace(" ", max))
                        c = 0
                    }
                } else if (j <= end) print(adjustSpace(" ", max)) else break
            }
            start = start - 1
            end = end + 1
            println()
            println()
            println()
            println()
            println()
            println()
        }
    }

    fun adjustSpace(s: String, max: Int): String {
        return s + " ".repeat(max - s.length)
    }

    fun combination(a: BigInteger, b: BigInteger): String {
        var f1 = BigInteger.ONE
        var f2 = BigInteger.ONE
        var k = b
        var i = a
        while (i.subtract(a.subtract(b)) != BigInteger.ZERO) {
            f1 = f1.multiply(i)
            f2 = f2.multiply(k)
            k = if (k.max(BigInteger.ONE) == k && k != BigInteger.ONE) k.subtract(BigInteger.ONE) else k
            i = i.subtract(BigInteger.ONE)
        }
        return f1.divide(f2).toString()
    }
}