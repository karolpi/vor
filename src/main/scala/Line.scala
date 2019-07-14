import scala.math.abs

class Line(p1: Point, p2: Point) {
  val direction = abs( p1.y - p2.y) / abs( p1.x - p2.x )
}
