package version1

import scala.language.higherKinds

trait 归墟 {
  self =>
  type 首
  type 尾 = 归墟

  def 首: 首
  def 尾: 尾 = self

  type 加水[I] = 归墟
  def 加水[II](i: II): 加水[II] = new 归墟 {
    override type 首 = II
    override val 首: II = i

    override type 尾 = 归墟
    override val 尾: 归墟 = self

    override def toString = 首.toString + ", " + 尾.toString
  }
}

object 归墟 {

  val value: 归墟 = new 归墟 {
    self =>
    override type 首 = 归墟
    override val 首: 归墟 = self

    override def toString = "归墟"
  }

}
