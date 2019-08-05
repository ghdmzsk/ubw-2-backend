package version2

import scala.language.higherKinds

trait 池塘 {
  type 首
  type 尾 <: 池塘

  def 首: 首
  def 尾: 尾

  type 目前去水 <: 去水
  def 目前去水: 目前去水

  type 加水[I] <: 池塘
  def 加水[I](i: I): 加水[I]
}

class 池塘之初 extends 池塘 {
  self =>
  override type 首 = 池塘之初
  override type 尾 = 池塘之初
  override def 首: 池塘之初 = self
  override def 尾: 池塘之初 = self

  override type 目前去水 = 没有满溢
  override def 目前去水: 没有满溢 = 没有满溢

  override type 加水[I] = 有水的池塘[I, 池塘之初]
  override def 加水[I](i: I): 有水的池塘[I, 池塘之初] = new 有水的池塘(i, self)

  override def toString = "HNil"
}

object 池塘之初 extends 池塘之初

class 有水的池塘[HH, TT <: 池塘](override val 首: HH, override val 尾: TT) extends 池塘 {
  self =>
  override type 首 = HH
  override type 尾 = TT

  override type 目前去水 = 满溢
  override def 目前去水: 满溢 = 满溢

  override type 加水[I] = 有水的池塘[I, 有水的池塘[HH, TT]]
  override def 加水[I](i: I): 有水的池塘[I, 有水的池塘[HH, TT]] = new 有水的池塘(i, self)

  override def toString: String = 首.toString + ", " + 尾.toString
}
