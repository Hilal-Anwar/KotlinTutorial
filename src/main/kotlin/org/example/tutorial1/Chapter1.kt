package org.example.tutorial1

import kotlin.math.*;

fun main() {
    lcm(5, 9)
    hcf(18,90)
}

fun lcm(a: Int, b: Int) {
    var a1 = a
    var b1 = b
    var lcm = 1
    var max = max(a1, b1)
    var i = 2
    while (i <= max) {
        if (a1 % i == 0 && b1 % i == 0) {
            lcm *= i
            a1 /= i
            b1 /= i
            max = max(a1, b1)
            i = 1
        }
        i++
    }
    println("The lcm of $a and $b is ${lcm * a * b}")
}
fun hcf(a:Int,b:Int){
    var max = max(a, b)
    var min= min(a,b)
    var tem=1
    while (min!=0){
        tem=min
        min=max%min
        max=tem
    }
    println("The hcf of $a and $b is $tem")
}