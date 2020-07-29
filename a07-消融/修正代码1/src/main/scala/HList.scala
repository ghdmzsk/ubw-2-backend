package a05

trait 自然数 {

  type 后继[T] <: 自然数
  def 后继[T](item: T): 后继[T]

  type 消融[T <: 自然数] <: 整数定义
  def 消融[T <: 自然数](item: T): 消融[T]

}

trait 整数定义 {
  type 正数部分 <: 自然数
  type 负数部分 <: 自然数
  def 正数部分: 正数部分
  def 负数部分: 负数部分

  type 相反数 <: 整数定义
  def 相反数: 相反数
}

class 整数[T1 <: 自然数, T2 <: 自然数](override val 负数部分: T1, override val 正数部分: T2) extends 整数定义 {
  override type 负数部分 = T1
  override type 正数部分 = T2

  override type 相反数 = 整数[T2, T1]
  override def 相反数: 整数[T2, T1] = new 整数(负数部分 = 正数部分, 正数部分 = 负数部分)

  override def toString: String = s"(负数部分: ${负数部分}, 正数部分: ${正数部分})"
}

class 零 extends 自然数 {
  self =>

  override type 后继[T] = 正数[零, T]
  override def 后继[T](item: T): 正数[零, T] = new 正数(self, item)

  override type 消融[T <: 自然数] = 整数[零, T]
  override def 消融[T <: 自然数](item: T): 整数[零, T] = new 整数(负数部分 = 零.value, 正数部分 = item)

  override def toString: String = "零"

}

object 零 {
  val value: 零 = new 零
}

class 正数[Tail <: 自然数, H](val tail: Tail, val head: H) extends 自然数 {
  self =>

  override type 后继[I] = 正数[正数[Tail, H], I]
  override def 后继[I](item: I): 正数[正数[Tail, H], I] = new 正数(self, item)

  override type 消融[T <: 自然数] = T#消融[Tail]#相反数
  override def 消融[T <: 自然数](item: T): T#消融[Tail]#相反数 = item.消融[Tail](tail).相反数

  override def toString: String = s"$tail :: $head"

}
