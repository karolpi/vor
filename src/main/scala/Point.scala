import java.awt.Polygon
import java.awt.geom.Point2D

class Point(x: Double, y: Double) extends Point2D.Double(x, y) {
  //val area: Polygon = new Polygon()
  //val

  def isOnTheSameSide(line: Line, point: Point): Boolean = {



    true
  }

  def createLine(p: Point): Line = {
    require( p != this )
    new Line( this, p )
  }
}