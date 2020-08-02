package a05

trait 自然数 {

  type 后继[T] <: 自然数
  def 后继[T](item: T): 后继[T]

  type 消融1[T <: 自然数] <: 整数定义
  def 消融1[T <: 自然数](item: T): 消融1[T]

  type 消融2[T <: 自然数, I] <: 整数定义
  def 消融2[T <: 自然数, I](item: T, i: I): 消融2[T, I]

  type Plus[T <: 自然数] <: 自然数
  def plus[T <: 自然数](h: T): Plus[T]

}

trait 整数定义 {
  type 正数部分 <: 自然数
  type 负数部分 <: 自然数
  def 正数部分: 正数部分
  def 负数部分: 负数部分

  type 加[T <: 整数定义] <: 整数定义
  def 加[T <: 整数定义](item: T): 加[T]

  type 自己 <: 整数定义
  def 自己: 自己

  type 相反数 <: 整数定义
  def 相反数: 相反数
}

class 整数[T1 <: 自然数, T2 <: 自然数](override val 负数部分: T1, override val 正数部分: T2) extends 整数定义 {
  self =>

  override type 自己 = 整数[T1, T2]
  override def 自己: 整数[T1, T2] = self

  override type 加[T <: 整数定义] = T#负数部分#Plus[负数部分]#消融1[T#正数部分#Plus[正数部分]]
  override def 加[T <: 整数定义](item: T): T#负数部分#Plus[负数部分]#消融1[T#正数部分#Plus[正数部分]] = item.负数部分.plus(负数部分).消融1(item.正数部分.plus(正数部分))

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

  override type 消融1[T <: 自然数] = 别名.自然数整数版[T]
  override def 消融1[T <: 自然数](item: T): 别名.自然数整数版[T] = 别名.自然数整数版(item)

  override type 消融2[T <: 自然数, I] = 整数[T#后继[I], 零]
  override def 消融2[T <: 自然数, I](item: T, i: I): 整数[T#后继[I], 零] = new 整数(负数部分 = item.后继(i), 正数部分 = 别名.自然数零)

  override type Plus[T <: 自然数] = T
  override def plus[T <: 自然数](h: T): T = h

  override def toString: String = "零"

}

object 别名 {
  val 自然数零: 零 = new 零
  type 整数零 = 整数[零, 零]
  val 整数零: 整数零 = new 整数(负数部分 = 自然数零, 正数部分 = 自然数零)
  type 自然数整数版[T <: 自然数] = 整数[零, T]
  def 自然数整数版[T <: 自然数](item: T): 自然数整数版[T] = new 整数(负数部分 = 自然数零, 正数部分 = item)
}

class 正数[Tail <: 自然数, H](val tail: Tail, val head: H) extends 自然数 {
  self =>

  override type 后继[I] = 正数[正数[Tail, H], I]
  override def 后继[I](item: I): 正数[正数[Tail, H], I] = new 正数(self, item)

  override type 消融1[T <: 自然数] = T#消融2[Tail, H]#自己
  override def 消融1[T <: 自然数](item: T): T#消融2[Tail, H]#自己 = item.消融2(tail, head).自己

  override type 消融2[T <: 自然数, I] = T#消融1[Tail]
  override def 消融2[T <: 自然数, I](item: T, i: I): T#消融1[Tail] = item.消融1(tail)

  override type Plus[T <: 自然数] = Tail#Plus[T]#后继[H]
  override def plus[T <: 自然数](h: T): Tail#Plus[T]#后继[H] = tail.plus(h).后继(head)

  override def toString: String = s"$tail :: $head"

}
