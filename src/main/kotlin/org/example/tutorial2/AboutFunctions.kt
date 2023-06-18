package org.example.tutorial2


fun foo(
    bar: Int = 0,
    baz: Int = 1,
    qux: () -> String,
) {
    var z = qux.invoke()
}

fun printHello(name: String?) {
    if (name != null)
        println("Hello $name")
    else
        println("Hi there!")
// `return Unit` or `return` is optional
}

fun Printer(block: () -> Unit): Printer = object : Printer {
    override fun print() = block()
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
        "kjhjkhkj"
    }) // Uses both default values bar = 0 and baz = 1
    foo {
        println("hello")
        ",.kjkl;j;"
    }
    printHello("Helal")
    println(isEven.accept(5))
    var pr = Printer { println("from the printer Interface") }
    pr.print()
}

fun interface IntPredicate {
    fun accept(i: Int): Boolean
}

interface Printer {
    fun print()
}
