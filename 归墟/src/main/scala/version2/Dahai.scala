package version2

import scala.language.higherKinds

trait 大海 {
  type 首
  type 尾 <: 大海

  val head: 首
  val tail: 尾

  type 目前去水 <: 去水
  def 目前去水: 目前去水

  type 加水[I] <: 大海
  def 加水[I](i: I): 加水[I]
}

class 大海之初 extends 大海 {
  self =>
  override type 首 = 大海之初
  override type 尾 = 大海之初
  override val head: 大海之初 = self
  override val tail: 大海之初 = self

  override type 目前去水 = 没满溢
  override def 目前去水: 没满溢 = 没满溢

  override type 加水[I] = 有水的大海[I, 大海之初]
  override def 加水[I](i: I): 有水的大海[I, 大海之初] = new 有水的大海(i, self)

  override def toString = "HNil"
}

object 大海之初 extends 大海之初

class 有水的大海[HH, TT <: 大海](override val head: HH, override val tail: TT) extends 大海 {
  self =>
  override type 首 = HH
  override type 尾 = TT

  override type 目前去水 = 满溢
  override def 目前去水: 满溢 = 满溢

  override type 加水[I] = 有水的大海[I, 有水的大海[HH, TT]]
  override def 加水[I](i: I): 有水的大海[I, 有水的大海[HH, TT]] = new 有水的大海(i, self)

  override def toString: String = head.toString + ", " + tail.toString
}
