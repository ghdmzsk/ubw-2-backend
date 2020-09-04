package a10

trait 自然数 {
  type Next[T] <: 自然数
  type 加[I <: 自然数] <: 自然数
  type 成对[T] <: 元素对自然数
  type 乘以[I <: 自然数] <: 元素对自然数
  def next[T](t: T): Next[T]
  def 加[I <: 自然数](i: I): 加[I]
  def 成对[T](t: T): 成对[T]
  def 乘以[I <: 自然数](i: I): 乘以[I]
}

class 自然数零 extends 自然数 {
  self =>
  override type Next[T]      = 正整数[自然数零, T]
  override type 加[I <: 自然数]  = I
  override type 成对[T]        = 元素对自然数零
  override type 乘以[I <: 自然数] = 元素对自然数零
  override def next[T](t: T): 正整数[自然数零, T] = new 正整数(tail = self, head = t)
  override def 加[I <: 自然数](i: I): I        = i
  override def 成对[T](t: T): 元素对自然数零        = 元素对自然数零.value
  override def 乘以[I <: 自然数](i: I): 元素对自然数零 = 元素对自然数零.value

  override def toString: String = "自然数零"
}

object 自然数零 {
  val value: 自然数零 = new 自然数零
}

class 正整数[Tail <: 自然数, Head](val tail: Tail, val head: Head) extends 自然数 {
  self =>
  override type Next[T]      = 正整数[正整数[Tail, Head], T]
  override type 加[I <: 自然数]  = 正整数[Tail#加[I], Head]
  override type 成对[T]        = 元素对正整数[Tail#成对[T], Head, T]
  override type 乘以[I <: 自然数] = I#成对[Head]#加[Tail#乘以[I]]
  override def next[T](t: T): 正整数[正整数[Tail, Head], T]       = new 正整数(tail = self, head = t)
  override def 加[I <: 自然数](i: I): 正整数[Tail#加[I], Head]      = new 正整数(tail = tail.加(i), head = head)
  override def 成对[T](t: T): 元素对正整数[Tail#成对[T], Head, T]     = new 元素对正整数(tail.成对(t), head, t)
  override def 乘以[I <: 自然数](i: I): I#成对[Head]#加[Tail#乘以[I]] = i.成对(head).加(tail.乘以(i))

  override def toString: String = s"$tail :: $head"
}
