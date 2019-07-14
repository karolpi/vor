import java.awt.{Color, Graphics2D}
import java.awt.image.BufferedImage

import scala.util.Random

class Board( width: Int, height: Int, numOfPoints: Int ) extends BufferedImage( width, height, BufferedImage.TYPE_INT_RGB ) {

  val g: Graphics2D = this.createGraphics()
  val mainPoints: Array[Point] = generatePoints(numOfPoints)

  //fill background in white
  g.setPaint( Color.white )
  g.fillRect( 0, 0, width, height )

  //draw points
  g.setPaint( Color.BLACK )
  mainPoints.foreach( p => g.drawOval(p.x.toInt, p.y.toInt, 5, 5))

  def generatePoints(numOfPoints: Int): Array[Point] = {
    val r = Random
    new Array[Point](numOfPoints).map( x => new Point( width * r.nextDouble(), height * r.nextDouble() ) )
  }
}
