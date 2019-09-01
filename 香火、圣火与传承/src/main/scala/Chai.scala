import scala.language.higherKinds

trait 柴 {

  type 尾 <: 柴
  def 尾: 尾

  type 当前燃料 <: 燃料
  def 当前燃料: 当前燃料

  type 初始化[I <: 燃料] <: 柴
  def 初始化[I <: 燃料](i: I): 初始化[I]

  type 点火[I <: 火苗] <: 柴
  def 点火[I <: 火苗](i: I): 点火[I]

}

class 一块柴[S <: 燃料, T <: 柴](override val 当前燃料: S, override val 尾: T) extends 柴 {
  self =>

  override type 尾    = T
  override type 当前燃料 = S

  override type 初始化[I <: 燃料] = 一块柴[I, 一块柴[S, T]]
  override def 初始化[I <: 燃料](i: I): 一块柴[I, 一块柴[S, T]] = new 一块柴(i, self)

  override type 点火[I <: 火苗] = ({
    type I1 = I#flatMap[当前燃料]
    type I2 = I#叠减[当前燃料]
    type I3 = T#点火[I1]
    type II = 一块柴[I2, I3]
  })#II
  override def 点火[I <: 火苗](i: I): 点火[I] = {
    val i1: I#flatMap[当前燃料] = i.flatMap(当前燃料)
    val i2                  = i.叠减(当前燃料)
    val i3                  = 尾.点火(i1)
    new 一块柴(i2, i3)
  }

}

class 初始柴 extends 柴 {
  self =>
  override type 尾    = 初始柴
  override type 当前燃料 = 初始燃料
  override def 尾    = self
  override def 当前燃料 = 初始燃料.初始燃料
  override type 初始化[I <: 燃料] = 一块柴[I, 初始柴]
  override def 初始化[I <: 燃料](i: I): 一块柴[I, 初始柴] = new 一块柴(i, self)

  override type 点火[I <: 火苗] = 初始柴
  override def 点火[I <: 火苗](i: I): 初始柴 = self

}

object 初始柴 {
  val 初始柴: 初始柴 = new 初始柴
}
