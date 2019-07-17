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

  lazy val areaPoints: Set[Point] =
    lines.flatMap(line => lines.filter(_ != line).map(line.findIntersection))



  def isOnTheSameSide(Perpendicular: Perpendicular, point: Point): Boolean = {



    true
  }

  def createPerpendicular(p: Point): Line = {
    new Perpendicular( this, p )
  }
}
