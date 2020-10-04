package a13.加法

trait 自然数 {
  type Next[T] <: 自然数
  type 加[T <: 自然数] <: 自然数
  type 再加[T <: 自然数] <: 自然数

  def next[T](t: T): Next[T]
  def 加[T <: 自然数](item: T): 加[T]
  def 再加[T <: 自然数](item: T): 再加[T]

}

class 自然数零 extends 自然数 {
  self =>
  override type Next[T]      = 正整数[自然数零, T]
  override type 加[T <: 自然数]  = T
  override type 再加[T <: 自然数] = T#加[自然数零]

  override def next[T](t: T): 正整数[自然数零, T]      = new 正整数(tail = self, head = t)
  override def 加[T <: 自然数](item: T): T          = item
  override def 再加[T <: 自然数](item: T): T#加[自然数零] = item.加(self)

  override def toString: String = "自然数零"
}

object 自然数零 extends 自然数零

class 正整数[Tail <: 自然数, Head](val tail: Tail, val head: Head) extends 自然数 {
  self =>
  override type Next[T]      = 正整数[正整数[Tail, Head], T]
  override type 加[T <: 自然数]  = 正整数[Tail#加[T], Head]
  override type 再加[T <: 自然数] = T#加[正整数[Tail, Head]]

  override def next[T](t: T): 正整数[正整数[Tail, Head], T]      = new 正整数(tail = self, head = t)
  override def 加[T <: 自然数](item: T): 正整数[Tail#加[T], Head]  = new 正整数(tail = tail.加(item), head)
  override def 再加[T <: 自然数](item: T): T#加[正整数[Tail, Head]] = item.加(self)

  override def toString: String = s"$tail :: $head"
}
