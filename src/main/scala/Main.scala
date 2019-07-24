import java.awt.image.BufferedImage
import java.io.File

import javax.imageio.ImageIO

object Main {
  def main(args: Array[String]): Unit = {

    println("Generating...")
    val startNanos = System.currentTimeMillis()

    val b: Board = new Board(600, 600, 200)
    val file: File = new File("image.png")

    ImageIO.write(b, "png", file)

    val endNanos = System.currentTimeMillis()
    println("generated in time: " + (endNanos - startNanos) / 1000 + "s, " + (endNanos - startNanos) % 1000 + "ms")
  }
}
