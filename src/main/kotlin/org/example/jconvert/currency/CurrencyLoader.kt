package org.example.jconvert.currency

import java.io.IOException
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse
import java.util.*

class CurrencyLoader {
    private val database = Database("currency")
    private val client = HttpClient.newHttpClient()
    fun reload() {
        val CURRENCY_URL = "https://open.er-api.com/v6/latest/USD"
        val request = HttpRequest.newBuilder()
            .uri(URI.create(CURRENCY_URL)).build()
        val httpResponse: HttpResponse<String>
        try {
            httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString())
            var stringTokenizer = StringTokenizer(httpResponse.body(), "{}")
            var data: String? = ""
            while (stringTokenizer.countTokens() >= 1) {
                data = stringTokenizer.nextToken()
            }
            stringTokenizer = StringTokenizer(data, ",")
            var name: String
            while (stringTokenizer.hasMoreTokens()) {
                name = stringTokenizer.nextToken()
                database.setData(name.substring(1, name.lastIndexOf('"')), name.substring(name.indexOf(':') + 1))
            }
        } catch (e: IOException) {
            System.err.println("Check your connection if you are using it for first time")
            System.err.println("If you are connected to internet most recent data is used for conversion")
        } catch (e: InterruptedException) {
            System.err.println("Check your connection if you are using it for first time")
            System.err.println("If you are connected to internet most recent data is used for conversion")
        }
    }

    fun getCurrencyValue(code: String): Double {
        return if (database.getData(code) != null) database.getData(code)!!.toDouble() else Double.NaN
    }
}
