package version1

import scala.language.higherKinds

trait 锅 {

  type 尾 <: 锅
  def 尾: 尾

  type 加铁[I <: 铁] <: 锅
  def 加铁[I <: 铁](i: I): 加铁[I]

  type 武火 <: 锅
  def 武火: 武火

}

class 没有铁的锅 extends 锅 {
  self =>

  override type 尾 = 没有铁的锅
  override def 尾: 没有铁的锅 = self

  override type 加铁[I <: 铁] = 有铁的锅[I, 没有铁的锅]
  override def 加铁[I <: 铁](i: I): 有铁的锅[I, 没有铁的锅] = new 有铁的锅[I, 没有铁的锅](i, self)

  override type 武火 = 没有铁的锅
  override def 武火: 没有铁的锅 = 没有铁的锅.value

  override def toString: String = "没有铁的锅"
}

object 没有铁的锅 {
  val value = new 没有铁的锅
}

class 有铁的锅[PP <: 铁, TT <: 锅](val 第一块铁: PP, override val 尾: TT) extends 锅 {
  self =>
  override type 尾 = TT

  override type 加铁[I <: 铁] = 有铁的锅[I, 有铁的锅[PP, TT]]
  override def 加铁[I <: 铁](i: I): 有铁的锅[I, 有铁的锅[PP, TT]] = new 有铁的锅[I, 有铁的锅[PP, TT]](i, self)

  override type 武火 = 有铁的锅[PP#需要热量, 尾#武火]
  override def 武火: 有铁的锅[PP#需要热量, 尾#武火] = new 有铁的锅(第一块铁.需要热量, 尾.武火)

  override def toString: String = 第一块铁.toString + ", " + 尾.toString
}
