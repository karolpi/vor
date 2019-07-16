import java.awt.Polygon
import java.awt.geom.Point2D

import scala.collection.mutable.ArrayBuffer

class Point(x: Double, y: Double)(implicit board: Board) extends Point2D.Double(x, y) {

  //lazy because there must be initialized all points first


  private lazy val lines: Set[Line] =
    board.mainPoints.concat(board.1)
    .filter(_ != this)

  val a = board.mainPoints.concat(board.lines)


  //def getLines: Array[Line] = lines

  def isOnTheSameSide(Perpendicular: Perpendicular, point: Point): Boolean = {



    true
  }

  def createPerpendicular(p: Point): Line = {
    new Perpendicular( this, p )
  }
}
