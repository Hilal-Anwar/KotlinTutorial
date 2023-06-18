package org.example.jconvert.currency

import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.IOException
import java.util.*

class Database(name: String) {
    private val properties: Properties
    private val filename: String

    init {
        properties = Properties()
        filename = System.getProperty("user.home") + "//" + name + ".dat"
        try {
            FileInputStream(filename).use { fileInputStream -> properties.load(fileInputStream) }
        } catch (e: IOException) {
            System.err.println("No such file is present")
        }
    }

    @Throws(IOException::class)
    fun setData(name: Any?, value: Any?) {
        properties[name] = value
        FileOutputStream(filename).use { fileOutputStream -> properties.store(fileOutputStream, "Currencies Rate") }
    }

    fun getData(key: Any): String? {
        return properties.getProperty(key.toString())
    }
}
