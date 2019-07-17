
/*

  Nie działa dla linii pionowych


class Line2(p1: Point, p2: Point, perpendicular: Boolean = true) {

  private lazy val centerPoint: Point = null
  private lazy val a: Double = null
  private lazy val b: Double = null
  private lazy val c: Double = null

  if (perpendicular) {
    centerPoint: Point = new Point((p1.x + p2.x) / 2, (p1.y + p2.y) / 2)
    a: Double = -1 / ((p2.y - p1.y) / (p2.x - p1.x))
    b: Double = -1
    c: Double = a * centerPoint.x - centerPoint.y
  } else {
    a: Double = (p1.y - p2.y) / (p1.x - p2.x) // jest dobrze liczone
    b: Double = -1
    c: Double = p1.y - ((p1.y - p2.y) / (p1.x - p2.x)) * p1.x
  }

  def findIntersection(line: Line): Point = {
    val w = this.a * line.b - line.a * this.b
    val wx = this.b * line.c - line.b * this.c
    val wy = this.a * line.c - line.a * this.c
    new Point(wx / w, wy / w)
  }

  override def toString: String = {
    f"CP: ${centerPoint.x}%.2f , ${centerPoint.y}%.2f $a%.2f x - y = $c%.2f"
  }
}
*/