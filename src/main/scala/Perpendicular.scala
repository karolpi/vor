import scala.math.abs

class Perpendicular(p1: Point, p2: Point) {
  val centerPoint: Point = new Point((p1.x + p2.x) / 2, (p1.y + p2.y) / 2)
  val a: Double = -1 / (p2.y - p1.y) / (p2.x - p1.x)
  val b: Double = centerPoint.y - a * centerPoint.x
  val c: Double =
}
