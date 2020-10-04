package a13.减法

trait 自然数对 {
  type T1 <: 负自然数
  type T2 <: 正自然数
  val 负自然数: T1
  val 正自然数: T2
}

class 自然数对实现[T11 <: 负自然数, T22 <: 正自然数](override val 负自然数: T11, override val 正自然数: T22) extends 自然数对 {
  override type T1 = T11
  override type T2 = T22
}

trait 正自然数 {
  type Next[T] <: 正自然数
  def next[T](t: T): Next[T]

  type 消去[T <: 负自然数] <: 自然数对
}

trait 负自然数 {
  type Next[T] <: 负自然数
  def next[T](t: T): Next[T]

  type 消去[T <: 正自然数, R] <: 自然数对
}

class 正自然数零 extends 正自然数 {
  self =>
  override type Next[T] = 正整数[正自然数零, T]
  override def next[T](t: T): 正整数[正自然数零, T] = new 正整数(tail = self, head = t)

  override type 消去[T <: 负自然数] = 自然数对实现[T, 正自然数零]

  override def toString: String = "自然数零"
}

class 负自然数零 extends 负自然数 {
  self =>
  override type Next[T] = 负整数[负自然数零, T]
  override def next[T](t: T): 负整数[负自然数零, T] = new 负整数(tail = self, head = t)

  override type 消去[T <: 正自然数, R] = 自然数对实现[负自然数零, 正整数[T, R]]

  override def toString: String = "自然数零"
}

object 正自然数零 extends 正自然数零

class 正整数[Tail <: 正自然数, Head](val tail: Tail, val head: Head) extends 正自然数 {
  self =>
  override type Next[T] = 正整数[正整数[Tail, Head], T]
  override def next[T](t: T): 正整数[正整数[Tail, Head], T] = new 正整数(tail = self, head = t)

  override type 消去[T <: 负自然数] = T#消去[Tail, Head]

  override def toString: String = s"$tail :: $head"
}

class 负整数[Tail <: 负自然数, Head](val tail: Tail, val head: Head) extends 负自然数 {
  self =>
  override type Next[T] = 负整数[负整数[Tail, Head], T]
  override def next[T](t: T): 负整数[负整数[Tail, Head], T] = new 负整数(tail = self, head = t)

  override type 消去[T <: 正自然数, R] = T#消去[Tail]

  override def toString: String = s"$tail :: $head"
}
