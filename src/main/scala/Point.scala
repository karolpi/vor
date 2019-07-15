import java.awt.Polygon
import java.awt.geom.Point2D

import scala.collection.mutable.ArrayBuffer

class Point(x: Double, y: Double) extends Point2D.Double(x, y) {
  //val area: Polygon = new Polygon()

  def isOnTheSameSide(Perpendicular: Perpendicular, point: Point): Boolean = {



    true
  }

  def createPerpendicular(p: Point): Line = {
    new Perpendicular( this, p )
  }
}
