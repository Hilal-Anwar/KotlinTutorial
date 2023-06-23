package org.example.tutorial2

open class Rectangle {
    open fun draw() {
        println("Drawing a rectangle")
    }

    val borderColor: String get() = "black"
}

class FilledRectangle : Rectangle() {
    override fun draw() {
        val filler = Filler()
        filler.drawAndFill()
    }

    inner class Filler {
        private fun fill() {
            println("Filling")
        }

        fun drawAndFill() {
            super@FilledRectangle.draw()
            fill()
            println(
                "Drawn a filled rectangle with color " +
                        super@FilledRectangle.borderColor
            )
        }
    }
}

fun main() {
    val fr = FilledRectangle()
    fr.draw()
}