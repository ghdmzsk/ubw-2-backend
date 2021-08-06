import scala.language.higherKinds

trait 每天 {

  type 尾 <: 每天
  def 尾: 尾

  type 叠加燃料[I <: 燃料] <: 燃料
  def 叠加燃料[I <: 燃料](i: I): 叠加燃料[I]

  type 剩下的缘分 <: 每天
  def 剩下的缘分: 剩下的缘分

  type 初始化[T <: 缘] <: 每天
  def 初始化[T <: 缘](t: T): 初始化[T]

}

class 普通的一天[R <: 缘, U <: 每天](val 当前缘分: R, override val 尾: U) extends 每天 {
  self =>

  type 当前缘分       = R
  override type 尾 = U

  override type 叠加燃料[I <: 燃料] = R#当前燃料#flatMap[U#叠加燃料[I]]
  override def 叠加燃料[I <: 燃料](i: I): R#当前燃料#flatMap[U#叠加燃料[I]] = 当前缘分.当前燃料.flatMap(尾.叠加燃料(i))

  override type 剩下的缘分 = 普通的一天[R#尾, 尾#剩下的缘分]
  override def 剩下的缘分: 普通的一天[R#尾, 尾#剩下的缘分] = new 普通的一天(当前缘分.尾, 尾.剩下的缘分)

  override type 初始化[I <: 缘] = 普通的一天[I, 普通的一天[R, U]]
  override def 初始化[I <: 缘](i: I): 普通的一天[I, 普通的一天[R, U]] = new 普通的一天(i, self)

}

class 一天的开始 extends 每天 {
  self =>

  override type 尾 = 一天的开始
  override def 尾: 一天的开始 = self

  override type 叠加燃料[I <: 燃料] = I
  override def 叠加燃料[I <: 燃料](i: I): I = i

  override type 剩下的缘分 = 一天的开始
  override def 剩下的缘分: 一天的开始 = self

  override type 初始化[T <: 缘] = 普通的一天[T, 一天的开始]
  override def 初始化[T <: 缘](t: T): 普通的一天[T, 一天的开始] = new 普通的一天(t, self)

}
