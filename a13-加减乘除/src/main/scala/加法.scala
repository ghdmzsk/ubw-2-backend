package a13.加法

trait 自然数 {
  type Next[T] <: 自然数
}

trait 被加数 extends 自然数 {
  override type Next[T] <: 被加数
  type 加[T <: 加数] <: 被加数
}

class 被加数零 extends 被加数 {
  self =>
  override type Next[T]    = 被加数正数[被加数零, T]
  override type 加[T <: 加数] = T#反向加[被加数零]

  override def toString: String = "自然数零"
}

class 被加数正数[Tail <: 被加数, Head] extends 被加数 {
  self =>
  override type Next[T]    = 被加数正数[被加数正数[Tail, Head], T]
  override type 加[T <: 加数] = T#反向加[被加数正数[Tail, Head]]
}

trait 加数 extends 自然数 {
  override type Next[T] <: 加数
  type 反向加[T <: 被加数] <: 被加数
}

class 加数零 extends 加数 {
  self =>
  override type Next[T]       = 加数正数[加数零, T]
  override type 反向加[T <: 被加数] = T

  override def toString: String = "自然数零"
}

class 加数正数[Tail <: 加数, Head] extends 加数 {
  self =>
  override type Next[T]       = 加数正数[加数正数[Tail, Head], T]
  override type 反向加[T <: 被加数] = 被加数正数[Tail#反向加[T], Head]
}
