package a10

trait 元素对自然数 {
  type Next[T1, T2] <: 元素对自然数
  type 加[I <: 元素对自然数] <: 元素对自然数
  def next[T1, T2](t1: T1, t2: T2): Next[T1, T2]
  def 加[I <: 元素对自然数](i: I): 加[I]
}

class 元素对自然数零 extends 元素对自然数 {
  self =>
  override type Next[T1, T2]   = 元素对正整数[元素对自然数零, T1, T2]
  override type 加[I <: 元素对自然数] = I
  override def next[T1, T2](t1: T1, t2: T2): 元素对正整数[元素对自然数零, T1, T2] = new 元素对正整数(tail = self, head1 = t1, head2 = t2)
  override def 加[I <: 元素对自然数](i: I): I                               = i

  override def toString: String = "元素对自然数零"
}

object 元素对自然数零 {
  val value: 元素对自然数零 = new 元素对自然数零
}

class 元素对正整数[Tail <: 元素对自然数, Head1, Head2](val tail: Tail, val head1: Head1, val head2: Head2) extends 元素对自然数 {
  self =>
  override type Next[T1, T2]   = 元素对正整数[元素对正整数[Tail, Head1, Head2], T1, T2]
  override type 加[I <: 元素对自然数] = 元素对正整数[Tail#加[I], Head1, Head2]
  override def next[T1, T2](t1: T1, t2: T2): 元素对正整数[元素对正整数[Tail, Head1, Head2], T1, T2] = new 元素对正整数(tail = self, head1 = t1, head2 = t2)
  override def 加[I <: 元素对自然数](i: I): 元素对正整数[Tail#加[I], Head1, Head2] = new 元素对正整数(tail = tail.加(i), head1 = head1, head2 = head2)

  override def toString: String = s"$tail :: ($head1, $head2)"
}
