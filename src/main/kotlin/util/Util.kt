package util

import java.util.*

object Util {
    fun print(`object`: Any?) {
        kotlin.io.print(`object`)
    }

    fun println(`object`: Any?) {
        kotlin.io.println(`object`)
    }

    fun println(objects: Array<Any?>?) {
        kotlin.io.println(Arrays.toString(objects))
    }

    fun println(objects: Array<Array<Any?>?>?) {
        kotlin.io.println(Arrays.deepToString(objects))
    }

    fun getRow(a: Array<IntArray?>, index: Int): IntArray? {
        return a[index]
    }

    fun getColumn(a: Array<IntArray>?, index: Int): IntArray {
        return Arrays.stream(a).mapToInt { ints: IntArray -> ints[index] }.toArray()
    }

    fun findMax(a: IntArray): Element<Int> {
        return _find_max(a, 0, a.size, 0, 0)
    }

    fun findMaxFrom(a: IntArray, from: Int): Element<Int> {
        return _find_max(a, from, a.size, a[from], from)
    }

    fun findMaxInBetween(a: IntArray, from: Int, to: Int): Element<Int> {
        var to = to
        to = if (to < a.size) to + 1 else to
        return _find_max(a, from, to, a[from], from)
    }

    fun findMin(a: IntArray): Element<Int> {
        return _find_min(a, 0, a.size, a[0], 0)
    }

    fun findMinFrom(a: IntArray, from: Int): Element<Int> {
        return _find_min(a, from, a.size, a[from], from)
    }

    fun findMinInBetween(a: IntArray, from: Int, to: Int): Element<Int> {
        var to = to
        to = if (to < a.size) to + 1 else to
        return _find_min(a, from, to, a[from], to)
    }

    private fun _find_max(a: IntArray, index: Int, endIndex: Int, max: Int, max_index: Int): Element<Int> {
        return if (index < endIndex) _find_max(
            a, index + 1, endIndex, Math.max(a[index], max),
            if (a[max_index] < a[index]) index else max_index
        ) else Element<Int>(max, max_index)
    }

    private fun _find_min(a: IntArray, index: Int, endIndex: Int, min: Int, min_index: Int): Element<Int> {
        return if (index < endIndex) _find_min(
            a, index + 1, endIndex, Math.min(a[index], min),
            if (a[min_index] > a[index]) index else min_index
        ) else Element<Int>(min, min_index)
    }

    fun getRow(a: Array<LongArray?>, index: Int): LongArray? {
        return a[index]
    }

    fun getColumn(a: Array<LongArray>?, index: Int): LongArray {
        return Arrays.stream(a).mapToLong { ints: LongArray -> ints[index] }.toArray()
    }

    fun findMax(a: LongArray): Element<Long> {
        return _find_max(a, 0, a.size, 0, 0)
    }

    fun findMaxFrom(a: LongArray, from: Int): Element<Long> {
        return _find_max(a, from, a.size, a[from], from)
    }

    fun findMaxInBetween(a: LongArray, from: Int, to: Int): Element<Long> {
        var to = to
        to = if (to < a.size) to + 1 else to
        return _find_max(a, from, to, a[from], from)
    }

    fun findMin(a: LongArray): Element<Long> {
        return _find_min(a, 0, a.size, a[0], 0)
    }

    fun findMinFrom(a: LongArray, from: Int): Element<Long> {
        return _find_min(a, from, a.size, a[from], from)
    }

    fun findMinInBetween(a: LongArray, from: Int, to: Int): Element<Long> {
        var to = to
        to = if (to < a.size) to + 1 else to
        return _find_min(a, from, to, a[from], to)
    }

    private fun _find_max(a: LongArray, index: Int, endIndex: Int, max: Long, max_index: Int): Element<Long> {
        return if (index < endIndex) _find_max(
            a, index + 1, endIndex, Math.max(a[index], max),
            if (a[max_index] < a[index]) index else max_index
        ) else Element<Long>(max, max_index)
    }

    private fun _find_min(a: LongArray, index: Int, endIndex: Int, min: Long, min_index: Int): Element<Long> {
        return if (index < endIndex) _find_min(
            a, index + 1, endIndex, Math.min(a[index], min),
            if (a[min_index] > a[index]) index else min_index
        ) else Element<Long>(min, min_index)
    }
}