import java.awt.geom.Point2D

/*
  TWORZY LINIĘ ŁĄCZĄCĄ DWA PUNKTY, JEŚLI PARAMETR perpendicular
  MA WARTOŚĆ TRUE TO LINIA JEST PROSTOPADŁA TO PIERWOTNEJ LINII
  I PRZEBIEGA PRZEZ PUNKT ZNAJDUJĄCY SIĘ W RÓWNEJ ODLEGŁOŚCI OD
  PUKTÓW PODANYCH JAKO PARAMETRY KONSTRUKTORA
 */

class Line(p1: Point, p2: Point, perpendicular: Boolean = false) {

  val (a: Double, b: Double, c: Double) =
  //perpendicular = true
    if (perpendicular) {
    val centerPoint: Point = new Point((p1.getX + p2.getX) / 2, (p1.getY + p2.getY) / 2)
    val a: Double = -1 / ((p2.getY - p1.getY) / (p2.getX - p1.getX))

    (a  ,  -1.0  ,  centerPoint.getY - centerPoint.getX * a)
  }
  //perpendicular = false
  else {
    val a = (p1.getY - p2.getY) / (p1.getX - p2.getX)

    (a, -1.0, p1.getY - p1.getX * a)
  }

  def getP1: Point2D = p1
  def getP2: Point2D = p2

  def findIntersection(line: Line): Option[Point2D] = {
      Line.intersection(line, this)
  }

  override def toString: String = f"Line${if(perpendicular) "Perpendicular" else ""}(${p1.getX}%.2f, ${p1.getY}%.2f)(${p2.getX}%.2f, ${p2.getY}%.2f)\ta: $a%.3f\tb: $b%.3f\tc: $c%.3f"
}

object Line {
  def intersection(line1: Line, line2: Line): Option[Point2D] = {
    if(line1.a == line2.a) None
    if(!line1.a.isInfinity && !line2.a.isInfinity) {
      val w = line1.a * line2.b - line2.a * line1.b
      val wx = line1.b * -line2.c - line2.b * -line1.c
      val wy = line1.a * -line2.c - line2.a * -line1.c
      Some(new java.awt.geom.Point2D.Double(-wx / w, wy / w))
    } else {
      if(line1.a.isInfinity) {
        Some(new java.awt.geom.Point2D.Double(line1.getP1.getX, line1.getP1.getX * line2.a + line2.c))
      } else {
        Some(new java.awt.geom.Point2D.Double(line2.getP1.getX, line2.getP1.getX * line1.a + line1.c))
      }
    }
  }
}