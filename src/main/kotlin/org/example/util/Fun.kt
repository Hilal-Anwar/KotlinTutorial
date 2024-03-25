package org.example.util

fun main() {
    val a = 8
    print("hello $a")
    val str = "abcd 123"
    println(str)
    val text = """
       |Tell me and I forget.
       |Teach me and I remember.
       |Involve me and I learn.
       |(Benjamin Franklin)
        """.trimMargin()
    val price = """
        ${'$'}9.99
        """.trimIndent()
    println(price)
    val asc = Array(5) {
        i -> (i * i).toString()
    }
    asc.forEach { println(it) }
    var rt = KRunnable { TODO("Not yet implemented") }

}