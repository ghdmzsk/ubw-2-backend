package version1

import scala.language.higherKinds

/**
HList 设计大体与 shapeless 相同，无需过度留意。
  */
trait 大海 {
  type 首
  val 首: 首
  type 尾 <: 大海
  val 尾: 尾

  type 目前舀水 <: 舀水
  def 目前舀水: 目前舀水

  type 加水[I] <: 大海
  def 加水[I](i: I): 加水[I]
}

class 大海之初 extends 大海 {
  self =>
  override type 首 = 大海之初
  override val 首: 大海之初 = self
  override type 尾 = 大海之初
  override val 尾: 大海之初 = self

  override type 目前舀水 = 没有满溢
  override def 目前舀水: 没有满溢 = 没有满溢

  override type 加水[I] = 有水的大海[I, 大海之初]
  override def 加水[I](i: I): 有水的大海[I, 大海之初] = new 有水的大海(i, self)

  override def toString: String = "HNil"
}

object 大海之初 extends 大海之初

class 有水的大海[HH, TT <: 大海](override val 首: HH, override val 尾: TT) extends 大海 {
  self =>
  override type 首 = HH
  override type 尾 = TT

  override type 目前舀水 = 满溢
  override def 目前舀水: 满溢 = 满溢

  override type 加水[I] = 有水的大海[I, 有水的大海[HH, TT]]
  override def 加水[I](i: I): 有水的大海[I, 有水的大海[HH, TT]] = new 有水的大海(i, self)

  override def toString: String = 首.toString + ", " + 尾.toString
}
