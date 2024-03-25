package org.example.tutorial2

class CurrencyNotes(private var amount: Int) {
    fun getMaxPossibleNotesType(): Map<String, Int> {
        val map = mutableMapOf<String, Int>()
        val currencyNotes = listOf(500, 200, 100, 50, 20, 10, 5, 2, 1)
        for (i in currencyNotes) {
            val z = amount / i
            map["₹$i"] = z
            amount %= i
        }
        return map;
    }

    fun getMaxPossibleNotesType(limit: Map<CurrencyType, Int>): Map<String, Int> {
        if (limit.isEmpty())
            return getMaxPossibleNotesType()
        else {
            val map = mutableMapOf<String, Int>()
            val currencyNotes = listOf(500, 200, 100, 50, 20, 10, 5, 2, 1)
            for (i in currencyNotes) {
                val z = amount / i
                if (limit.containsKey(CurrencyType(i)) && z > limit[CurrencyType(i)]!!) {
                    map["₹$i"] = limit[CurrencyType(i)]!!
                    amount -= (i * limit[CurrencyType(i)]!!)
                } else {
                    map["₹$i"] = z
                    amount %= i
                }
            }
            return map
        }
    }
}

fun main() {
    val money = CurrencyNotes(543659874);
    //println(money.getMaxPossibleNotesType())
    var x = money.getMaxPossibleNotesType(
        mapOf(
            CurrencyType(500) to 23,

            CurrencyType(50) to 12
        )
    )
    println(x)
}

data class CurrencyType(val value: Int) {}
