package a13.减法

trait 自然数 {
  type Next[T] <: 自然数
}

trait 正自然数 extends 自然数 {
  type Next[T] <: 正自然数

  type 消去[T <: 负自然数] <: 自然数
  type 逆消去[T <: 负自然数, R] <: 自然数
}

trait 负自然数 extends 自然数 {
  type Next[T] <: 负自然数

  type 消去[T <: 正自然数, R] <: 自然数
  type 逆消去[T <: 正自然数] <: 自然数
}

class 正自然数零 extends 正自然数 {
  self =>
  override type Next[T] = 正整数[正自然数零, T]

  override type 消去[T <: 负自然数]     = T
  override type 逆消去[T <: 负自然数, R] = 负整数[T, R]

  override def toString: String = "自然数零"
}

class 负自然数零 extends 负自然数 {
  self =>
  override type Next[T] = 负整数[负自然数零, T]

  override type 消去[T <: 正自然数, R] = 正整数[T, R]
  override type 逆消去[T <: 正自然数]   = T

  override def toString: String = "自然数零"
}

object 正自然数零 extends 正自然数零

class 正整数[Tail <: 正自然数, Head] extends 正自然数 {
  self =>
  override type Next[T] = 正整数[正整数[Tail, Head], T]

  override type 消去[T <: 负自然数]     = T#消去[Tail, Head]
  override type 逆消去[T <: 负自然数, R] = T#逆消去[Tail]
}

class 负整数[Tail <: 负自然数, Head] extends 负自然数 {
  self =>
  override type Next[T] = 负整数[负整数[Tail, Head], T]

  override type 消去[T <: 正自然数, R] = T#消去[Tail]
  override type 逆消去[T <: 正自然数]   = T#逆消去[Tail, Head]
}
