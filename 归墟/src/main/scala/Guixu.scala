import scala.language.higherKinds

class 水
object 水 extends 水

trait 归墟 {
  type T <: 归墟

  val head: 水
  val tail: T

  type AddWater <: 归墟
  def add(i: 水): AddWater
}

class 归墟Impl extends 归墟 {
  self =>
  override type T = 归墟Impl
  override val head: 水 = 水
  override val tail: 归墟Impl = self

  override type AddWater = 归墟Impl
  override def add(i: 水): 归墟Impl = new 归墟Impl {
    override type T = 归墟Impl
    override val head: 水 = i
    override val tail: 归墟Impl = self
  }

  override def toString = "HNil"
}

object 归墟Impl extends 归墟Impl
