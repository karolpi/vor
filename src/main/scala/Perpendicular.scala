import scala.math.abs

class Perpendicular(p1: Point, p2: Point) {
  val centerPoint: Point = new Point((p1.x + p2.x) / 2, (p1.y + p2.y) / 2)
  val a: Double = -1 / ((p2.y - p1.y) / (p2.x - p1.x))
  val b: Double = -1
  val c: Double = a * centerPoint.x - centerPoint.y

  def findIntersection(line: Perpendicular): Point = {
    val w = this.a * line.b - line.a * this.b
    val wx = this.b * line.c - line.b * this.c
    val wy = this.a * line.c - line.a * this.c
    new Point(wx / w, wy / w)
  }

  override def toString: String = {
    s"centerPoint: ${centerPoint.x},${centerPoint.y} $a * ${centerPoint.x} + $b * ${centerPoint.y} = $c"
  }
}
