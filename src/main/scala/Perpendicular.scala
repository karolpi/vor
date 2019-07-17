/*
class Perpendicular(p1: Point, p2: Point) extends Line(p1, p2){

  def findIntersection(line: Line): Point = {
    val w = this.a * line.b - line.a * this.b
    val wx = this.b * line.c - line.b * this.c
    val wy = this.a * line.c - line.a * this.c
    new Point(wx / w, wy / w)
  }
}
 */
