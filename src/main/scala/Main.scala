import java.awt.image.BufferedImage
import java.io.File

import javax.imageio.ImageIO

object Main {
  def main(args: Array[String]): Unit = {

    val b: Board = new Board(600, 600, 5)
    val file: File = new File("image.png")

    ImageIO.write(b, "png", file)
  }
}
