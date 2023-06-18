package org.example.util

import java.io.File
import java.io.IOException
import javax.imageio.ImageIO

object ImageReaderExample {
    @JvmStatic
    fun main(args: Array<String>) {
        try {
            val image = ImageIO.read(File("/tmp/input.jpg"))
            image.graphics.drawLine(1, 1, image.width - 1, image.height - 1)
            image.graphics.drawLine(1, image.height - 1, image.width - 1, 1)
            ImageIO.write(image, "png", File("/tmp/output.png"))
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}