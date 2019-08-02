package version2

import scala.language.higherKinds

trait 归墟 {
  self =>
  type I
  type Tail = 归墟

  val head: I
  val tail: 归墟 = self

  type AddWater[I] = 归墟
  def add[II](i: II): AddWater[I] = new 归墟 {
    override type I = II
    override val head: II = i

    override type Tail = 归墟
    override val tail: 归墟 = self

    override def toString = head.toString + ", " + self.toString
  }
}

object Guixu {

  val value: 归墟 = new 归墟 {
    self =>
    override type I = 归墟
    override val head: 归墟 = self
    override def toString = "归墟"
  }

}
