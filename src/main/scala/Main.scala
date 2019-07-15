import java.awt.image.BufferedImage
import java.io.File

import javax.imageio.ImageIO

object Main {
  def main(args: Array[String]): Unit = {
    val b: Board = new Board(600, 600, 8)
    val file: File = new File("image.png")

    ImageIO.write(b, "png", file)
    val line1 = new Perpendicular(new Point(-3,-3), new Point(1,-1))
    val line2 = new Perpendicular(new Point(0,2), new Point(1,5))
    println(line1)
    println(line2)
    println(line2.findIntersection(line1))
  }
}
