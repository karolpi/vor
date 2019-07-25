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

    val b: Board = new Board(width, height, 900, Some(startImage))
    val file: File = new File("image.png")

    ImageIO.write(b, "png", file)

    val endNanos = System.currentTimeMillis()
    println("generated in time: "+ (endNanos - startNanos) / 60000 + "m, " +(endNanos - startNanos) % 60000 / 1000 + "s, " + (endNanos - startNanos) % 60000 % 1000 + "ms")
  }
}
