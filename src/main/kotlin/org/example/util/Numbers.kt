package org.example.util

import kotlin.math.sqrt

fun prime(num: Int = 0, p: (it: Int) -> Boolean): Boolean {
    return p.invoke(num)
}

fun removeDigits(number: Int, digit: Int): Int {
    var n = number
    var nu = 0.0
    var c = 0.1
    while (n > 0) {
        val r = n % 10
        if (r != digit) {
            nu = nu * 0.1 + r
            c *= 10
        }
        n /= 10;
    }
    return (nu * c).toInt()
}

fun main() {
    println(prime(131) {
        var c = 1
        val x = sqrt(it.toDouble()).toInt()
        for (i in 2..x) {
            if (it % i == 0)
                c += 1
            if (c > 2)
                break
        }
        return@prime c == 1
    })
    println(removeDigits(3496565, 5))
}