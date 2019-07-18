import java.awt.image.BufferedImage
import java.io.File

import javax.imageio.ImageIO

object Main {
  def main(args: Array[String]): Unit = {
    /*
    val b: Board = new Board(600, 600, 8)
    val file: File = new File("image.png")

    ImageIO.write(b, "png", file)
    */

    val l1 = new Line(new Point(1,3), new Point(3,0), perpendicular = false)
    val l2 = new Line(new Point(6,1), new Point(-1,-2), perpendicular = false)
    println(s"$l1\n$l2\n${l1.findIntersection(l2)}")
  }
}
