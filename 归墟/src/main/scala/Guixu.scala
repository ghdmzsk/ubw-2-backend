import scala.language.higherKinds

class 水
object 水 extends 水

trait 归墟 {
  self =>

  type I
  type T = 归墟

  val head: I
  val tail: 归墟 = self

  type AddWater[I] = 归墟
  def add[II](i: II): AddWater[I] = new 归墟 {
    override type I = II
    override val head: II = i

    override type T = 归墟
    override val tail: 归墟 = self

    override def toString = head.toString + "," + self.toString
  }

}

object 归墟 extends 归墟 {

  override type I = 水
  override val head: 水 = 水

}
