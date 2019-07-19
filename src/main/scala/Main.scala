import java.awt.image.BufferedImage
import java.io.File

import javax.imageio.ImageIO

object Main {
  def main(args: Array[String]): Unit = {

    val b: Board = new Board(600, 600, 5)
    val file: File = new File("image.png")

    ImageIO.write(b, "png", file)

    val l1 = new Line(new Point(0,0), new Point(400, 0)) // down
    val l2 = new Line(new Point(600, 0), new Point(600, 600)) //right - pionowa
    println(l1)
    println(l2)
    println(l2.findIntersection(l1))
  }
}
