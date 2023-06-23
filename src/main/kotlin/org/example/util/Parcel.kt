package org.example.util

import org.example.algorithms.User
import java.util.*


fun main() {
    val `in` = Scanner(System.`in`)
    println("Enter the mass in gram")
    val mass = `in`.nextInt()
    var charger = 0.0

    charger = if (mass <= 500) 500.0 else 500 + (mass - 500) / 200.0 * 25
    println("Total charge = $charger")
}
