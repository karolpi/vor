
import java.awt.{Color, Graphics2D}
import java.awt.image.BufferedImage

import Board.activeBoard

import scala.collection.mutable.ArrayBuffer
import scala.util.Random

class Board( width: Int, height: Int, numOfPoints: Int, image: Option[BufferedImage] = None) extends BufferedImage( width, height, BufferedImage.TYPE_INT_RGB ) {

  Board.activeBoard = this
  val g: Graphics2D = this.createGraphics()
  val mainPoints: Set[Point] = generatePoints(numOfPoints)

  //boundary lines
  val lines = ArrayBuffer(
    new Line(new Point(0,0), new Point(getWidth, 0)), // down
    new Line(new Point(getWidth, 0), new Point(getWidth, getHeight)), //right
    new Line(new Point(getWidth, getHeight), new Point(0, getHeight)), //upper
    new Line(new Point(0, getHeight), new Point(0,0)) // left
  )

  //fill background in white
  g.setPaint( Color.white )
  g.fillRect( 0, 0, width, height )

  //draw area of all points and calcuate process
  var pointInRow = 0
  mainPoints.foreach(point => {
    g.setPaint(point.getColor)
    g.fill(point.areaPolygon)
    pointInRow += 1
    print(f"${pointInRow.toDouble / numOfPoints * 100}%.2f%%\r")
  })


  def generatePoints(numOfPoints: Int): Set[Point] = {
    val r = Random
    Set.fill[Point](numOfPoints)(elem = new Point(width * r.nextDouble, height * r.nextDouble))
  }

  def getBufferedImage: Option[BufferedImage] = image
}

object Board {
  implicit var activeBoard: Board = null
}