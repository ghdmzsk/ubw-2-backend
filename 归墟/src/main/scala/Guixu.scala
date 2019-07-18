import scala.language.higherKinds

class 水
object 水 extends 水

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

    override def toString = head.toString + "," + self.toString
  }

}

object Guixu extends Guixu {

  override type I = 水
  override val head: 水 = 水

}
