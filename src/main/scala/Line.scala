
/*
  TWORZY LINIĘ ŁĄCZĄCĄ DWA PUNKTY, JEŚLI PARAMETR perpendicular
  MA WARTOŚĆ TRUE TO LINIA JEST PROSTOPADŁA TO PIERWOTNEJ LINII
  I PRZEBIEGA PRZEZ PUNKT ZNAJDUJĄCY SIĘ W RÓWNEJ ODLEGŁOŚCI OD
  PUKTÓW PODANYCH JAKO PARAMETRY KONSTRUKTORA
 */

class Line(p1: Point, p2: Point, perpendicular: Boolean = false) {

  val (a: Double, b: Double, c: Double) = if (perpendicular) {
    val centerPoint: Point = new Point((p1.x + p2.x) / 2, (p1.y + p2.y) / 2)
    val a: Double = -1 / ((p2.y - p1.y) / (p2.x - p1.x))

    (a  ,  -1.0  ,  centerPoint.x - centerPoint.y * a)
  } else  //normalna linia
    ((p1.y - p2.y) / (p1.x - p2.x)  ,  -1.0  ,  p1.y - ((p1.y - p2.y) / (p1.x - p2.x)) * p1.x)

  def findIntersection(line: Line): Point = {
    val w = this.a * line.b - line.a * this.b
    val wx = this.b * -line.c - line.b * -this.c
    val wy = this.a * -line.c - line.a * -this.c
    new Point(wx / w, wy / w)
  }

  override def toString: String = f"a: $a%.1f\tb: $b%.1f\tc: $c%.1f"

}
