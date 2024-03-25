package org.example.algorithms

import java.util.UUID

open class User(var name: String, var age: Int, var gender: Gender) {

    lateinit var a: circle

    var uId: String
        get() = UUID.randomUUID().toString()
        set(value) {

        }

    fun about() {
        println(toString())
    }

    override fun toString(): String {
        return "User(name='$name', age=$age, gender=$gender, uId='$uId')"
    }

}

class Example {
    fun printFunctionType() {
        println("Class method")
    }

    fun some_info_of_funtion(): String {
        return "This function does nothing"
    }


}

fun Example.printFunctionType(i: Int) {
    println("Extension function #$i")
    fun Example.some_info_of_funtion(): String = ""


}


fun main() {
    val u1 = User("helal", 25, Gender.Male)
    println(u1.name)

    u1.uId = UUID.randomUUID().toString();
    println(u1)
    Example().printFunctionType(1)

}