package org.example.tutorial2

data class Counter(val dayIndex: Int) {
    operator fun plus(increment: Int): Counter {
        return Counter(dayIndex + increment)
    }


    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val c = Counter(5);
            println(c.plus(4564))
        }
    }
}