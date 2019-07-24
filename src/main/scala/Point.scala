import java.awt.{Color, Polygon}
import java.awt.geom.Point2D

import scala.collection.immutable.{HashSet, TreeSet}
import scala.util.Random

class Point(x: Double, y: Double)(implicit board: Board) extends java.awt.geom.Point2D.Double(x, y) {

  private val color: Color = {
    if(board.getBufferedImage.isDefined) {
      new Color(board.getBufferedImage.get.getRGB(
        if(x == board.getWidth) this.getX.toInt - 1 else this.getX.toInt,
        if(y == board.getHeight) this.getY.toInt - 1 else this.getY.toInt))
    } else new Color(Random.nextInt)
  }

  //lazy because there must be initialized all points first
  lazy val lines: Set[Line] =
    board.mainPoints
      .filter(_ != this)
      .map(this.createPerpendicular)
      .concat(board.lines)

  /*
  TWORZY WSZYSTKIE MOŻLIWE PUNKTY POŁACZEŃ I FILTRUJE TE,
  KTÓRE SĄ POZA PLANSZĄ
  */
  lazy val sortedAreaPoints: Array[Point2D] =
    lines.flatMap(line => {
      lines.filter(!line.eq(_))
        .flatMap(line findIntersection _) //filtr Some
        .concat(HashSet(new Point(0,0), new Point(0, board.getHeight()), new Point(board.getWidth(), 0),
          new Point(board.getWidth(), board.getHeight())))
        .filter(p => p.getX >= 0 && p.getX <= board.getWidth && p.getY >= 0 && p.getY <= board.getHeight) //odrzuca poza granicami
    })
      .filter(p => {
        lines.forall(l => {
          Point.areOnTheSameSide(this, p, l)
        })
      })
      .toArray.sortBy(p => math.atan2(p.getY - this.getY, p.getX - this.getX))


  lazy val areaPolygon: Polygon =
    new Polygon(sortedAreaPoints.map(_.getX.toInt), sortedAreaPoints.map(_.getY.toInt), sortedAreaPoints.size)

  def createPerpendicular(p: Point): Line = {
    new Line( p1 = this, p2 = p, perpendicular = true )
  }
  def getColor: Color = color

  override def toString: String = s"Point[$x, $y]"
}

object Point {
  def areOnTheSameSide(p1: Point2D, p2: Point2D, l: Line): Boolean = {
    if(l.a.isInfinity) {
      if(!(p1.getX >= l.getP1.getX ^ p2.getX >= l.getP1.getX) || !(p1.getX <= l.getP1.getX ^ p2.getX <= l.getP1.getX)) true else false
    } else {
      if(!((l.a * p1.getX + l.b * p1.getY + l.c).toInt >= 0 ^ (l.a * p2.getX + l.b * p2.getY + l.c).toInt >= 0) ||
        !((l.a * p1.getX + l.b * p1.getY + l.c).toInt <= 0 ^ (l.a * p2.getX + l.b * p2.getY + l.c).toInt <= 0)) true else false
    }
  }
}