
/*

  Nie działa dla linii pionowych

 */

class Line(p1: Point, p2: Point) {
  private val a = (p1.y - p2.y) / (p1.x - p2.x)
  private val b = -1
  private val c = p1.y - ((p1.y - p2.y) / (p1.x - p2.x)) * p1.x

  def findIntersection(line: Line): Point = {
    val w = this.a * line.b - line.a * this.b
    val wx = this.b * line.c - line.b * this.c
    val wy = this.a * line.c - line.a * this.c
    new Point(wx / w, wy / w)
  }

  override def toString: String = {
    s"${a}x + ${b}y = $c"
  }
}
