package org.example.util

/**
 * @author hilal on 01-02-2023
 * @project Java_tutorials
 */
object Maps {
    @JvmStatic
    fun main(args: Array<String>) {
        val m: MutableMap<Int, String> = HashMap()
        m[5] = "ds"
        m[15] = "ds"
        m[50] = "ds"
        m[-5] = "ds"
        m[59] = "ds"
        println(m)
        val linkedHashMap = LinkedHashMap<Int, String>()
        linkedHashMap.putAll(m)
        println(m)
    }
}