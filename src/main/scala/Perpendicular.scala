class Perpendicular(p1: Point, p2: Point) extends Line(p1, p2){
  private lazy val centerPoint: Point = new Point((p1.x + p2.x) / 2, (p1.y + p2.y) / 2)
  private lazy val a: Double = -1 / ((p2.y - p1.y) / (p2.x - p1.x))
  private lazy val b: Double = -1
  private lazy val c: Double = a * centerPoint.x - centerPoint.y

  override def toString: String = {
    s"centerPoint: ${centerPoint.x},${centerPoint.y} $a * ${centerPoint.x} + $b * ${centerPoint.y} = $c"
  }
}
