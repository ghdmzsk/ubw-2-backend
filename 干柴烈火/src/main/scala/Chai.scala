package version1

import scala.language.higherKinds

trait 燃烧比例 {
  type 尾 <: 燃烧比例

  def 尾: 尾

  type 热量 <: 燃烧比例
  def 热量: 热量

  type 部分烧尽[I <: 柴] <: 柴
  def 部分烧尽[I <: 柴](m: I): 部分烧尽[I]

}

class 一片木头 extends 燃烧比例 {
  self =>
  override type 尾 = 一片木头

  override def 尾: 一片木头 = self

  override type 热量 = 没有燃尽[一片木头]
  override def 热量: 没有燃尽[一片木头] = new 没有燃尽(self)

  override type 部分烧尽[I <: 柴] = I#下一段
  override def 部分烧尽[I <: 柴](m: I): I#下一段 = m.下一段柴

  override def toString: String = "化为灰烬"
}

object 化为灰烬 {
  val value = new 一片木头
}

class 没有燃尽[TT <: 燃烧比例](override val 尾: TT) extends 燃烧比例 {
  self =>
  override type 尾 = TT

  override type 热量 = 没有燃尽[没有燃尽[TT]]
  override def 热量: 没有燃尽[没有燃尽[TT]] = new 没有燃尽(self)

  override type 部分烧尽[I <: 柴] = I
  override def 部分烧尽[I <: 柴](m: I): I = m

  override def toString: String = "燃烧比例" + ", " + 尾.toString
}
