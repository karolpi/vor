
import java.awt.{Color, Graphics2D}
import java.awt.image.BufferedImage

import Board.activeBoard

import scala.collection.mutable.ArrayBuffer
import scala.util.Random

class Board( width: Int, height: Int, numOfPoints: Int ) extends BufferedImage( width, height, BufferedImage.TYPE_INT_RGB ) {

  Board.activeBoard = this
  val g: Graphics2D = this.createGraphics()
  val mainPoints: Set[Point] = generatePoints(numOfPoints)


  //boundary lines
  val lines = ArrayBuffer(
    new Line(new Point(0,0), new Point(getWidth, 0)), // down
    new Line(new Point(getWidth, 0), new Point(getWidth, getHeight)), //right - pionowa
    new Line(new Point(getWidth, getHeight), new Point(0, getHeight)), //upper
    new Line(new Point(0, getHeight), new Point(0,0)) // left - pionowa
  )

  //fill background in white
  g.setPaint( Color.white )
  g.fillRect( 0, 0, width, height )

  //draw points
  g.setPaint( Color.BLACK )
  mainPoints.foreach( p => g.fillOval(p.getX.toInt, p.getY.toInt, 8, 8))

  //draw area of all points
  var pointInRow = 0
  mainPoints.foreach(point => {
    g.setPaint( new Color(Random.nextInt()) )
    g.fill(point.areaPolygon)
    pointInRow += 1
    print(f"${pointInRow.toDouble / numOfPoints * 100}%.0f%%\r")
  })


  def generatePoints(numOfPoints: Int): Set[Point] = {
    val r = Random
    Set.fill[Point](numOfPoints)(elem = new Point(width * r.nextDouble, height * r.nextDouble))
  }
}

object Board {
  implicit var activeBoard: Board = null
}