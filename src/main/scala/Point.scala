import java.awt.Polygon
import java.awt.geom.Point2D

import scala.collection.mutable.ArrayBuffer

class Point(x: Double, y: Double)(implicit board: Board) extends Point2D.Double(x, y) {

  //lazy because there must be initialized all points first
  lazy val lines: Set[Line] =
    board.mainPoints
    .filter(_ != this)
    .map(this.createPerpendicular)
    .concat(board.lines)


  lazy val areaPoints: Set[Point2D.Double] =
    lines.flatMap(line => lines.filter(_ != line).map(line.findIntersection))

  def createPerpendicular(p: Point): Line = {
    new Line( p1 = this, p2 = p, perpendicular = true )
  }

  def areOnTheSameSite(p: Point, l: Line): Boolean = {
    val (a, b, c) = (l.a, l.b, l.c)
    (a * this.x + b * this.y + c) * (a * p.x + b * p.y + c) >= 0
  }
}