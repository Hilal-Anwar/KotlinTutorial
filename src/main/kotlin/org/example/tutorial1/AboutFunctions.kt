package org.example.tutorial1


fun foo(bar: Int = 0, baz: Int = 1, qux: () -> String) {
    var z = qux.invoke()
}

fun printHello(name: String?) {
    if (name != null)
        println("Hello $name")
    else
        println("Hi there!")
}


val isEven = IntPredicate(fun(it: Int): Boolean {
    return it % 2 == 0
})

fun main() {
    foo(1) {
        println("hjkgjkhkhkl")
        "jhjkh"
    } // Uses the default value baz = 1
    foo(qux = {
        println("hello")
        println()
        println()
        "kjhjkhkj"
    }) // Uses both default values bar = 0 and baz = 1
    foo(bar = 52) {
        println("hello")
        ",.kjkl;j;"
    }
    printHello("Helal")
    println(isEven.accept(5))
    var pr = object : Printer {
        override fun pri(x: Int) {
            println("from the printer Interface")
            var A = 6.25
        }
    }
    var er = IntPredicate { it % 2 == 0 }
    println("val is this ${Printer::pri.invoke(pr, 6)}")
    pr.pri(6)
    println(er.accept(5))
}


fun interface IntPredicate {
    fun accept(i: Int): Boolean
}

interface Printer {
    fun pri(x: Int)
}

