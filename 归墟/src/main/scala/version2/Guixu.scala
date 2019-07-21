package version2

import scala.language.higherKinds

trait Guixu {
  self =>
  type I
  type T = Guixu

  val head: I
  val tail: Guixu = self

  type AddWater[I] = Guixu
  def add[II](i: II): AddWater[I] = new Guixu {
    override type I = II
    override val head: II = i

    override type T = Guixu
    override val tail: Guixu = self

    override def toString = head.toString + ", " + self.toString
  }
}

object Guixu {

  val value: Guixu = new Guixu {
    self =>
    override type I = Guixu
    override val head: Guixu = self

    override def toString = "归墟"
  }

}
