package version1

import scala.language.higherKinds

trait 柴 {

  type 目前能量 <: 燃烧比例

  def 目前能量: 目前能量

  type 下一段 <: 柴

  def 下一段柴: 下一段

  type 燃烧 <: 柴

  def 燃烧: 柴

  type 初始化[I <: 燃烧比例] <: 柴

  def 初始化[I <: 燃烧比例](i: I): 柴

}

class 燃干的柴 extends 柴 {
  self =>
  override type 目前能量 = 一片木头

  override def 目前能量: 一片木头 = 化为灰烬.value

  override type 下一段 = 燃干的柴

  override def 下一段柴: 燃干的柴 = self

  override type 燃烧 = 燃干的柴

  override def 燃烧: 燃干的柴 = self

  override type 初始化[I <: 燃烧比例] = 没有燃尽的柴[I, 燃干的柴]

  override def 初始化[I <: 燃烧比例](i: I): 没有燃尽的柴[I, 燃干的柴] = new 没有燃尽的柴(i, self)

  override def toString: String = "燃干的柴"
}

class 没有燃尽的柴[PP <: 燃烧比例, TT <: 柴](override val 目前能量: PP, override val 下一段柴: TT) extends 柴 {
  self =>
  override type 目前能量 = PP

  override type 下一段 = TT

  override type 燃烧 = PP#尾#部分烧尽[没有燃尽的柴[PP#尾, 下一段]]

  override def 燃烧: PP#尾#部分烧尽[没有燃尽的柴[PP#尾, 下一段]] = {
    val ii = 目前能量.尾
    ii.部分烧尽(new 没有燃尽的柴(目前能量.尾, 下一段柴))
  }

  override type 初始化[I <: 燃烧比例] = 没有燃尽的柴[I, 没有燃尽的柴[PP, TT]]

  override def 初始化[I <: 燃烧比例](i: I): 没有燃尽的柴[I, 没有燃尽的柴[PP, TT]] = new 没有燃尽的柴(i, self)

  override def toString: String = 目前能量.toString + ", " + 下一段柴.toString
}
