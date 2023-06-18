package org.example.jconvert

import org.example.jconvert.currency.CurrencyLoader
import org.example.jconvert.quantities.Currencies
import org.example.jconvert.quantities.Metric
import org.example.jconvert.quantities.Temperature
import java.lang.reflect.InvocationTargetException
import java.util.*

class JConverter {
    private val currencyLoader: CurrencyLoader = CurrencyLoader()

    init {
        Thread(currencyLoader::reload).start()
    }

    private val allCurrency: TreeMap<String, String>
        get() {
            val value: Array<Currencies> = Currencies.values()
            val allCurrency: TreeMap<String, String> = TreeMap<String, String>()
            for (currencies in value) {
                try {
                    if (Currency.getAvailableCurrencies().contains(Currency.getInstance(currencies.toString()))) {
                        allCurrency[Currency.getInstance(currencies.toString()).displayName] =
                            Currency.getInstance(currencies.toString()).currencyCode
                    }
                } catch (e: Exception) {
                    allCurrency[currencies.toString()] = currencies.toString()
                }
            }
            return allCurrency
        }
    val allCurrencyName: Array<Any>
        get() = allCurrency.keys.toTypedArray()

    fun convertCurrency(amount: Double, currencies1: Currencies, currencies2: Currencies): Double {
        val x: Double = currencyLoader.getCurrencyValue(currencies1.v)
        val y: Double = currencyLoader.getCurrencyValue(currencies2.v)
        return amount * y / x
    }

    fun <T : Enum<T>> convertTo(value: Double, unit1: T, unit2: T): Double {
        var x = 0.0
        var y = 0.0
        return if (unit1 !is Temperature) {
            try {
                x = unit1.declaringJavaClass.getMethod("v").invoke(unit1) as Double;
                y = unit2.declaringJavaClass.getMethod("v").invoke(unit2) as Double
            } catch (e: IllegalAccessException) {
                e.printStackTrace()
            } catch (e: InvocationTargetException) {
                e.printStackTrace()
            } catch (e: NoSuchMethodException) {
                e.printStackTrace()
            }
            value * y / x
        } else temperatureConversion(
            value,
            unit1 as Temperature, unit2 as Temperature
        )
    }

    fun <T : Enum<T>> convertTo(value: Double, u1: Metric, unit1: T, u2: Metric, unit2: T): Double {
        var x = 0.0
        var y = 0.0
        return if (unit1 !is Temperature) {
            try {
                x = unit1.declaringJavaClass.getMethod("v").invoke(unit1) as Double
                y = unit2.declaringJavaClass.getMethod("v").invoke(unit2) as Double
            } catch (e: IllegalAccessException) {
                e.printStackTrace()
            } catch (e: InvocationTargetException) {
                e.printStackTrace()
            } catch (e: NoSuchMethodException) {
                e.printStackTrace()
            }
            value * (u2.v * y) / (u1.v * x)
        } else u2.v / u1.v * temperatureConversion(value, unit1 as Temperature, unit2 as Temperature)
    }

    private fun temperatureConversion(value: Double, o1: Temperature, o2: Temperature): Double {
        return when {
            o1 == Temperature.degree_Celsius && o2 == Temperature.kelvin -> 273 + value
            o1 == Temperature.kelvin && o2 == Temperature.degree_Celsius -> value - 273
            o1 == Temperature.degree_Celsius && o2 == Temperature.degree_Fahrenheit -> value * 9 / 5 + 32
            o1 == Temperature.degree_Fahrenheit && o2 == Temperature.degree_Celsius -> (value - 32) * 5 / 9
            o1 == Temperature.kelvin && o2 == Temperature.degree_Fahrenheit -> value * 9 / 5 + 32 + 273
            o1 == Temperature.degree_Fahrenheit && o2 == Temperature.kelvin -> (value - 273) * 9 / 5 + 32
            o1 == Temperature.degree_Celsius && o2 == Temperature.degree_Rankine -> (value + 273.15) * 9 / 5
            o1 == Temperature.degree_Rankine && o2 == Temperature.degree_Celsius -> value * 9 / 5 - 273.15
            o1 == Temperature.degree_Fahrenheit && o2 == Temperature.degree_Rankine -> ((value - 32) * 5 / 9 + 273.15) * 9 / 5
            o1 == Temperature.degree_Rankine && o2 == Temperature.degree_Fahrenheit -> (value * 5 / 9 - 273.15) * 9 / 5 + 32
            o1 == Temperature.kelvin && o2 == Temperature.degree_Rankine -> value * 1.8
            o1 == Temperature.degree_Rankine && o2 == Temperature.kelvin -> value / 1.8
            else -> value
        }
    }

    fun reloadCurrency() {
        Thread(currencyLoader::reload).start()
    }
}
