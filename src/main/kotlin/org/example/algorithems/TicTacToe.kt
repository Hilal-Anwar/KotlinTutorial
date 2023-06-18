package org.example.algorithems

import java.util.*

internal class TicTacToe : Buttons {
    private var count = 0
    private var col = 0
    private var row = 0
    private var arrays = Array(7) { arrayOfNulls<String>(16) }
    private var `val` = "X"
    fun start() {
        var k: Int
        val w = option()
        box()
        for (i in 1..9) {
            when (w) {
                "Computer" -> {
                    board(w)
                    deviceTurn(Buttons.
                    y[row - 1], Buttons.x[col - 1])
                }

                else -> board(w)
            }
            show()
            k = check()
            when {
                k == 3 && count == 9 -> {
                    println("The game is draw")
                    thank()
                    break
                }

                k == 1 -> {
                    if (w == "Computer")
                        println("You lose")
                    else println("$w player won")
                    thank()
                    break
                }

                k == 2 -> {
                    if (w == "Computer")
                        println("You won")
                    else println("$w player won")
                    thank()
                    break
                }
            }
        }
    }

    private fun deviceTurn(b: Int, a: Int) {
        var z = 0
        val condition = checkWinO()
        if (!condition) {
            z = defence(b, a)
            if (z == 0) {
                count++
            }
        }
        if (z == 1 && count < 8) action(b, a)
    }

    private fun action(n: Int, m: Int) {
        count++
        var q: Int
        val algorithm = (Math.random() * 2 + 1).toInt()
        if ((n == Buttons.y[1] && m == Buttons.x[2] || n == Buttons.y[2] && m == Buttons.x[1]) && arrays[Buttons.y[0]][Buttons.x[0]] == " ") arrays[Buttons.y[0]][Buttons.x[0]] =
            "0" else if (algorithm == 1 && (n != Buttons.y[1] && m != Buttons.x[2] || n != Buttons.y[2] && m != Buttons.x[1]) && arrays[Buttons.y[1]][Buttons.x[1]] == " " && count <= 2) arrays[Buttons.y[1]][Buttons.x[1]] =
            "0" else if (algorithm == 2 && arrays[Buttons.y[1]][Buttons.x[1]] == " ") arrays[Buttons.y[1]][Buttons.x[1]] =
            "0" else if ((arrays[Buttons.y[0]][Buttons.x[0]] == " " || arrays[Buttons.y[0]][Buttons.x[2]] == " " || arrays[Buttons.y[2]][Buttons.x[0]] == " " || arrays[Buttons.y[2]][Buttons.x[2]] == " ") && arrays[Buttons.y[1]][Buttons.x[1]] == "X") {
            while (true) {
                q = (Math.random() * 4).toInt()
                val but = Buttons.c[q]
                if (arrays[but[0]][but[1]] == " ") {
                    arrays[but[0]][but[1]] = "0"
                    break
                }
            }
        } else if (arrays[Buttons.y[0]][Buttons.x[1]] == " " || arrays[Buttons.y[1]][Buttons.x[0]] == " " || arrays[Buttons.y[1]][Buttons.x[2]] == " " || arrays[Buttons.y[2]][Buttons.x[1]] == " ") {
            while (true) {
                q = (Math.random() * 4).toInt()
                val but = Buttons.b[q]
                if (arrays[but[0]][but[1]] == " ") {
                    arrays[but[0]][but[1]] = "0"
                    break
                }
            }
        } else {
            while (true) {
                q = (Math.random() * 9).toInt()
                val but = Buttons.a[q]
                if (arrays[but[0]][but[1]] == " ") {
                    arrays[but[0]][but[1]] = "0"
                    break
                }
            }
        }
    }

    private fun defence(b: Int, a: Int): Int {
        //button1
        if (b == Buttons.y[0] && a == Buttons.x[0]) {
            return computeAction(0, 3)
        }
        //button2
        if (b == Buttons.y[0] && a == Buttons.x[1]) {
            return computeAction(1, 2)
        }
        //button3
        if (b == Buttons.y[0] && a == Buttons.x[2]) {
            return computeAction(2, 3)
        }
        //button4
        if (b == Buttons.y[1] && a == Buttons.x[0]) {
            return computeAction(3, 2)
        }
        //button5
        if (b == Buttons.y[1] && a == Buttons.x[1]) {
            return computeAction(4, 4)
        }
        //button6
        if (b == Buttons.y[1] && a == Buttons.x[2]) {
            return computeAction(5, 2)
        }
        //button7
        if (b == Buttons.y[2] && a == Buttons.x[0]) {
            return computeAction(6, 3)
        }
        //button8
        if (b == Buttons.y[2] && a == Buttons.x[1]) {
            return computeAction(7, 2)
        }
        //button9
        return if (b == Buttons.y[2] && a == Buttons.x[2]) {
            computeAction(8, 3)
        } else 1
    }

    private fun computeAction(i: Int, size: Int): Int {
        for (j in 0 until size) {
            if (arrays[Buttons.Defender[i][j][0][0]][Buttons.Defender[i][j][0][1]] == "X") {
                if (arrays[Buttons.Defender[i][j][1][0]][Buttons.Defender[i][j][1][1]] == " ") {
                    arrays[Buttons.Defender[i][j][1][0]][Buttons.Defender[i][j][1][1]] = "0"
                    return 0
                }
            }
            if (arrays[Buttons.Defender[i][j][1][0]][Buttons.Defender[i][j][1][1]] == "X") {
                if (arrays[Buttons.Defender[i][j][0][0]][Buttons.Defender[i][j][0][1]] == " ") {
                    arrays[Buttons.Defender[i][j][0][0]][Buttons.Defender[i][j][0][1]] = "0"
                    return 0
                }
            }
        }
        return 1
    }

    private fun option(): String {
        val `in` = Scanner(System.`in`)
        println("Choose your opponent")
        println("Opponent option")
        println("Enter 1 for computer")
        println("Enter 2 for other")
        var c = `in`.nextInt()
        while (opt(c) == "Invalid") {
            println(opt(c) + " Option ")
            println("Please re-enter your choice")
            c = `in`.nextInt()
        }
        return opt(c)
    }

    private fun opt(x: Int): String {
        return when (x) {
            1 -> "Computer"
            2 -> "Other"
            else -> "Invalid"
        }
    }

    private fun board(name: String) {
        val `in` = Scanner(System.`in`)
        count++
        `val` = if (name == "Computer") {
            println("Your turn")
            "X"
        } else {
            if (`val` == "0") {
                println("$name turn")
                "X"
            } else {
                println("Your turn")
                "0"
            }
        }
        var v = 1
        while (v == 1) {
            while (true) {
                println("Enter the row ,Number ")
                row = `in`.nextLine().toInt()
                println("Enter the column , Number ")
                col = `in`.nextLine().toInt()
                if (arrays[Buttons.y[row - 1]][Buttons.x[col - 1]] == " ") {
                    arrays[Buttons.y[row - 1]][Buttons.x[col - 1]] = `val`
                    v = 0
                    break
                } else println("A number is present in this position so it is invalid")
            }
        }
    }

    private fun box() {
        val x = 5
        val y = 10
        for (i in arrays.indices) {
            for (j in arrays[0].indices) {
                arrays[i][j] = if (i % 2 == 0) "−" else " "
                if (j == 0 || j == arrays[0].size - 1 || j == x || j == y) arrays[i][j] = "|"
            }
        }
        arrays[0][0] = "+"
        arrays[0][arrays[0].size - 1] = "+"
        arrays[arrays.size - 1][0] = "+"
        arrays[arrays.size - 1][arrays[0].size - 1] = "+"
        arrays[arrays.size - 1][x] = "+"
        arrays[arrays.size - 1][y] = "+"
        arrays[0][x] = "+"
        arrays[0][y] = "+"
    }

    private fun show() {
        for (strings in arrays) {
            val bound = arrays[0].size
            for (i in 0 until bound) {
                val s = strings[i]
                print(s)
            }
            println()
        }
    }

    private fun check(): Int {
        if (arrays[1][2] == "0" && arrays[1][7] == "0" && arrays[1][12] == "0") return 1
        if (arrays[3][2] == "0" && arrays[3][7] == "0" && arrays[3][12] == "0") return 1
        if (arrays[5][2] == "0" && arrays[5][7] == "0" && arrays[5][12] == "0") return 1
        if (arrays[1][2] == "0" && arrays[3][2] == "0" && arrays[5][2] == "0") return 1
        if (arrays[1][7] == "0" && arrays[3][7] == "0" && arrays[5][7] == "0") return 1
        if (arrays[1][12] == "0" && arrays[3][12] == "0" && arrays[5][12] == "0") return 1
        if (arrays[1][2] == "0" && arrays[3][7] == "0" && arrays[5][12] == "0") return 1
        if (arrays[1][12] == "0" && arrays[3][7] == "0" && arrays[5][2] == "0") return 1
        if (arrays[1][2] == "X" && arrays[1][7] == "X" && arrays[1][12] == "X") return 2
        if (arrays[3][2] == "X" && arrays[3][7] == "X" && arrays[3][12] == "X") return 2
        if (arrays[5][2] == "X" && arrays[5][7] == "X" && arrays[5][12] == "X") return 2
        if (arrays[1][2] == "X" && arrays[3][2] == "X" && arrays[5][2] == "X") return 2
        if (arrays[1][7] == "X" && arrays[3][7] == "X" && arrays[5][7] == "X") return 2
        if (arrays[1][2] == "X" && arrays[3][7] == "X" && arrays[5][12] == "X") return 2
        if (arrays[1][12] == "X" && arrays[3][12] == "X" && arrays[5][12] == "X") return 2
        return if (arrays[1][12] == "X" && arrays[3][7] == "X" && arrays[5][2] == "X") 2 else 3
    }

    private fun checkWinO(): Boolean {
        for (k in 0..23) {
            if (arrays[Buttons.Win[k][0][0]][Buttons.Win[k][0][1]] == "0" && arrays[Buttons.Win[k][1][0]][Buttons.Win[k][1][1]] == "0") {
                if (arrays[Buttons.Win[k][2][0]][Buttons.Win[k][2][1]] == " ") {
                    arrays[Buttons.Win[k][2][0]][Buttons.Win[k][2][1]] = "0"
                    return true
                }
            }
            if (arrays[Buttons.Win[k][1][0]][Buttons.Win[k][1][1]] == "0" && arrays[Buttons.Win[k][2][0]][Buttons.Win[k][2][1]] == "0") {
                if (arrays[Buttons.Win[k][0][0]][Buttons.Win[k][0][1]] == " ") {
                    arrays[Buttons.Win[k][0][0]][Buttons.Win[k][0][1]] = "0"
                    return true
                }
            }
            if (arrays[Buttons.Win[k][2][0]][Buttons.Win[k][2][1]] == "0" && arrays[Buttons.Win[k][0][0]][Buttons.Win[k][0][1]] == "0") {
                if (arrays[Buttons.Win[k][1][0]][Buttons.Win[k][1][1]] == " ") {
                    arrays[Buttons.Win[k][1][0]][Buttons.Win[k][1][1]] = "0"
                    return true
                }
            }
        }
        return false
    }

    private fun thank() {
        println("Well played")
        println("Thanks for playing :)")
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println("Welcome to tic tac toe")
            val game = TicTacToe()
            game.start()
        }
    }
}

internal interface Buttons {
    companion object {
        val Defender = arrayOf(
            arrayOf(
                arrayOf(intArrayOf(1, 7), intArrayOf(1, 12)),
                arrayOf(intArrayOf(5, 2), intArrayOf(3, 2)),
                arrayOf(intArrayOf(3, 7), intArrayOf(5, 12))
            ),
            arrayOf(arrayOf(intArrayOf(1, 12), intArrayOf(1, 2)), arrayOf(intArrayOf(3, 7), intArrayOf(5, 7))),
            arrayOf(
                arrayOf(intArrayOf(1, 7), intArrayOf(1, 2)),
                arrayOf(intArrayOf(3, 12), intArrayOf(5, 12)),
                arrayOf(intArrayOf(3, 7), intArrayOf(5, 2))
            ),
            arrayOf(arrayOf(intArrayOf(1, 2), intArrayOf(5, 2)), arrayOf(intArrayOf(3, 7), intArrayOf(3, 12))),
            arrayOf(
                arrayOf(intArrayOf(1, 2), intArrayOf(5, 12)),
                arrayOf(intArrayOf(1, 12), intArrayOf(5, 2)),
                arrayOf(intArrayOf(1, 7), intArrayOf(5, 7)),
                arrayOf(intArrayOf(3, 2), intArrayOf(3, 12))
            ),
            arrayOf(arrayOf(intArrayOf(3, 7), intArrayOf(3, 2)), arrayOf(intArrayOf(1, 12), intArrayOf(5, 12))),
            arrayOf(
                arrayOf(intArrayOf(1, 2), intArrayOf(3, 2)),
                arrayOf(intArrayOf(5, 12), intArrayOf(5, 7)),
                arrayOf(intArrayOf(3, 7), intArrayOf(1, 12))
            ),
            arrayOf(arrayOf(intArrayOf(5, 12), intArrayOf(5, 2)), arrayOf(intArrayOf(1, 7), intArrayOf(3, 7))),
            arrayOf(
                arrayOf(intArrayOf(3, 12), intArrayOf(1, 12)),
                arrayOf(intArrayOf(5, 2), intArrayOf(5, 7)),
                arrayOf(intArrayOf(1, 2), intArrayOf(3, 7))
            )
        )
        val Win = arrayOf(
            arrayOf(intArrayOf(1, 2), intArrayOf(1, 7), intArrayOf(1, 12)),
            arrayOf(intArrayOf(1, 2), intArrayOf(3, 2), intArrayOf(5, 2)),
            arrayOf(intArrayOf(1, 2), intArrayOf(3, 7), intArrayOf(5, 12)),
            arrayOf(intArrayOf(1, 7), intArrayOf(1, 2), intArrayOf(1, 12)),
            arrayOf(intArrayOf(1, 7), intArrayOf(1, 12), intArrayOf(1, 2)),
            arrayOf(intArrayOf(1, 12), intArrayOf(1, 7), intArrayOf(1, 2)),
            arrayOf(intArrayOf(1, 12), intArrayOf(3, 12), intArrayOf(5, 12)),
            arrayOf(intArrayOf(1, 12), intArrayOf(5, 12), intArrayOf(3, 12)),
            arrayOf(intArrayOf(3, 2), intArrayOf(1, 2), intArrayOf(5, 2)),
            arrayOf(intArrayOf(3, 2), intArrayOf(3, 7), intArrayOf(3, 12)),
            arrayOf(intArrayOf(3, 7), intArrayOf(1, 2), intArrayOf(5, 12)),
            arrayOf(intArrayOf(3, 7), intArrayOf(1, 12), intArrayOf(5, 2)),
            arrayOf(intArrayOf(3, 7), intArrayOf(1, 7), intArrayOf(5, 7)),
            arrayOf(intArrayOf(3, 7), intArrayOf(3, 2), intArrayOf(3, 12)),
            arrayOf(intArrayOf(3, 12), intArrayOf(1, 12), intArrayOf(5, 12)),
            arrayOf(intArrayOf(3, 12), intArrayOf(3, 7), intArrayOf(3, 2)),
            arrayOf(intArrayOf(5, 2), intArrayOf(3, 2), intArrayOf(1, 2)),
            arrayOf(intArrayOf(5, 2), intArrayOf(3, 7), intArrayOf(1, 12)),
            arrayOf(intArrayOf(5, 2), intArrayOf(5, 7), intArrayOf(5, 12)),
            arrayOf(intArrayOf(5, 7), intArrayOf(3, 7), intArrayOf(1, 7)),
            arrayOf(intArrayOf(5, 7), intArrayOf(5, 2), intArrayOf(5, 12)),
            arrayOf(intArrayOf(5, 12), intArrayOf(3, 7), intArrayOf(1, 2)),
            arrayOf(intArrayOf(5, 12), intArrayOf(5, 7), intArrayOf(5, 2)),
            arrayOf(intArrayOf(5, 12), intArrayOf(3, 12), intArrayOf(1, 12))
        )
        val a = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(1, 7),
            intArrayOf(1, 12),
            intArrayOf(3, 2),
            intArrayOf(3, 7),
            intArrayOf(3, 12),
            intArrayOf(5, 2),
            intArrayOf(5, 7),
            intArrayOf(5, 12)
        )
        val b = arrayOf(intArrayOf(1, 7), intArrayOf(3, 2), intArrayOf(3, 12), intArrayOf(5, 7))
        val c = arrayOf(intArrayOf(1, 2), intArrayOf(1, 12), intArrayOf(5, 2), intArrayOf(5, 12))
        val x = intArrayOf(2, 7, 12)
        val y = intArrayOf(1, 3, 5)
    }
}