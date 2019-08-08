package version1

import scala.language.higherKinds

/**
  * HList 设计大体与 shapeless 相同，无需过度留意。
  */
trait 燃烧比例 {
  type 尾 <: 燃烧比例

  def 尾: 尾

  type 增加 <: 燃烧比例
  def 增加: 增加
}

class 化为灰烬 extends 燃烧比例 {
  self =>
  override type 尾 = 化为灰烬

  override def 尾: 化为灰烬 = self

  override type 增加 = 没有燃尽[化为灰烬]
  override def 增加: 没有燃尽[化为灰烬] = new 没有燃尽(self)

  override def toString: String = "化为灰烬"
}

object 化为灰烬 extends 化为灰烬

class 没有燃尽[TT <: 燃烧比例](override val 尾: TT) extends 燃烧比例 {
  self =>
  override type 尾 = TT

  override type 增加 = 没有燃尽[没有燃尽[TT]]
  override def 增加: 没有燃尽[没有燃尽[TT]] = new 没有燃尽(self)

  override def toString: String = "燃烧比例" + ", " + 尾.toString
}
