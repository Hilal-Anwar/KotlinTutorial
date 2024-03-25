package org.example.tutorial2

fun interface IntPe {
    fun app(i: Int): Boolean
}

val isEven = IntPe { i -> i % 2 == 0 }

fun main() {
   ::isEven.get().app(5)
}


