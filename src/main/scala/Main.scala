import java.awt.image.BufferedImage
import java.io.File

import javax.imageio.ImageIO

object Main {
  def main(args: Array[String]): Unit = {

    val imageFile: File = new File("startimage.jpg")
    val startImage: BufferedImage = ImageIO.read(imageFile)

    val width = startImage.getWidth
    val height = startImage.getHeight

    println("Generating...")
    val startNanos = System.currentTimeMillis()

    val b: Board = new Board(900, 900, 200, None)
    val file: File = new File("image.png")

    ImageIO.write(b, "png", file)

    val endNanos = System.currentTimeMillis()
    println("generated in time: " + (endNanos - startNanos) / 1000 + "s, " + (endNanos - startNanos) % 1000 + "ms")
  }
}
