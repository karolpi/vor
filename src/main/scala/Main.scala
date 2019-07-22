import java.awt.image.BufferedImage
import java.io.File

import javax.imageio.ImageIO

object Main {
  def main(args: Array[String]): Unit = {

    val b: Board = new Board(600, 600, 3)
    val file: File = new File("image.png")

    ImageIO.write(b, "png", file)

    val p1 = new Point(267,595)
    val p2 = new Point(305, 580)
    val p3 = new Point(524, 600)
    val l1 = new Line(p1, p2, perpendicular = true) // down

    println(Point.areOnTheSameSide(p1, p3, l1))
  }
}
