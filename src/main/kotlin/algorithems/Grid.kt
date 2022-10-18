package algorithems

import java.awt.Dimension
import java.awt.EventQueue
import java.awt.Graphics
import java.awt.Graphics2D
import javax.swing.JFrame
import javax.swing.JPanel

class Grid {
    init {
        EventQueue.invokeLater {

            /* try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                ex.printStackTrace();
            }*/
            val frame = JFrame("Testing")
            frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
            frame.add(TestPane())
            frame.pack()
            frame.setLocationRelativeTo(null)
            frame.isVisible = true
        }
    }

    inner class TestPane : JPanel() {
        override fun getPreferredSize(): Dimension {
            return Dimension(200, 200)
        }

        override fun paintComponent(g: Graphics) {
            super.paintComponent(g)
            val g2d = g.create() as Graphics2D
            val size = Math.min(width - 4, height - 4) / 10
            val width = width - size * 2
            val height = height - size * 2
            var y = (getHeight() - size * 10) / 2
            for (horz in 0..9) {
                var x = (getWidth() - size * 10) / 2
                for (vert in 0..9) {
                    g.drawRect(x, y, size, size)
                    x += size
                }
                y += size
            }
            g2d.dispose()
        }
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            Grid()
        }
    }
}