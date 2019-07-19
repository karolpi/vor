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

  def findIntersection(line: Line): Point2D.Double = {
    val w = this.a * line.b - line.a * this.b
    val wx = this.b * -line.c - line.b * -this.c
    val wy = this.a * -line.c - line.a * -this.c
    new Point(-wx / w, wy / w)
  }

  override def toString: String = f"Line${if(perpendicular) "Perpendicular" else ""}(${p1.getX}%.2f, ${p1.getY}%.2f)(${p2.getX}%.2f, ${p2.getY}%.2f)\ta: $a%.3f\tb: $b%.3f\tc: $c%.3f"

}
