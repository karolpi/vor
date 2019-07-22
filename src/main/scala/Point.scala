import java.awt.Polygon
import java.awt.geom.Point2D

class Point(x: Double, y: Double)(implicit board: Board) extends java.awt.geom.Point2D.Double(x, y) {
  
  //lazy because there must be initialized all points first
  lazy val lines: Set[Line] =
    board.mainPoints
      .filter(_ != this)
      .map(this.createPerpendicular)
      .concat(board.lines)

  /*
  TWORZY WSZYSTKIE MOŻLIWE PUNKTY POŁACZEŃ I FILTRUJE TE,
  + KTÓRE SĄ POZA PLANSZĄ
  */
  lazy val areaPoints: Set[Point2D] =
    lines.flatMap(line => {
      lines.filter(!line.eq(_))
        .flatMap(line findIntersection _)
        .filter(p => p.getX >= 0 && p.getX <= board.getWidth && p.getY >= 0 && p.getY <= board.getHeight)
    })

  def createPerpendicular(p: Point): Line = {
    new Line( p1 = this, p2 = p, perpendicular = true )
  }
}

object Point {
  def areOnTheSameSide(p1: Point2D, p2: Point2D, l: Line): Boolean = {
    val (a, b, c) = (l.a, l.b, l.c)
    (a * p1.getX + b * p1.getY + c) * (a * p2.getX + b * p2.getY + c) >= 0
  }
}