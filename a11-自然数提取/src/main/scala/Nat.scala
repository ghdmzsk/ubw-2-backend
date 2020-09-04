package a10

trait 自然数 {
  type Next[T] <: 自然数
  type 消去标记[T <: 自然数标记] <: 自然数对
  def next[T](t: T): Next[T]
  def 消去标记[T <: 自然数标记](item: T): 消去标记[T]
}

class 自然数零 extends 自然数 {
  self =>
  override type Next[T]          = 正整数[自然数零, T]
  override type 消去标记[T <: 自然数标记] = 非正整数自然数对[T]
  override def next[T](t: T): 正整数[自然数零, T]            = new 正整数(tail = self, head = t)
  override def 消去标记[T <: 自然数标记](item: T): 非正整数自然数对[T] = new 非正整数自然数对(负数部分 = item, 正数部分 = self)

  override def toString: String = "自然数零"
}

object 自然数零 {
  val value: 自然数零 = new 自然数零
}

class 正整数[Tail <: 自然数, Head](val tail: Tail, val head: Head) extends 自然数 {
  self =>
  override type Next[T]          = 正整数[正整数[Tail, Head], T]
  override type 消去标记[T <: 自然数标记] = T#自然数消去[Tail, Head]
  override def next[T](t: T): 正整数[正整数[Tail, Head], T]         = new 正整数(tail = self, head = t)
  override def 消去标记[T <: 自然数标记](item: T): T#自然数消去[Tail, Head] = item.自然数消去(tail, head)

  override def toString: String = s"$tail :: $head"
}
