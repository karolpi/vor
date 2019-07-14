import java.awt.Polygon
import java.awt.geom.Point2D

class Point(x: Double, y: Double) extends Point2D.Double(x, y) {
  //val area: Polygon = new Polygon()
  //val

  def isOnTheSameSide(Perpendicular: Perpendicular, point: Point): Boolean = {



    true
  }

  def createPerpendicular(p: Point): Perpendicular = {
    require( p != this )
    new Perpendicular( this, p )
  }
}
