package a13.乘法

trait 自然数 {
  type Next[T] <: 自然数
}

trait 自然数对 {
  type Next[T1, T2] <: 自然数对
  type 加[T <: 自然数对] <: 自然数对
}

class 自然数对零 extends 自然数对 {
  override type Next[T1, T2] = 自然数对正数[自然数对零, T1, T2]
  override type 加[T <: 自然数对] = T
}

class 自然数对正数[Tail <: 自然数对, Head1, Head2] extends 自然数对 {
  override type Next[T1, T2] = 自然数对正数[自然数对正数[Tail, Head1, Head2], T1, T2]
  override type 加[T <: 自然数对] = 自然数对正数[Tail#加[T], Head1, Head2]
}

trait 被乘数 extends 自然数 {
  override type Next[T] <: 被乘数
  type 乘[T <: 乘数] <: 自然数对
}

class 被乘数零 extends 被乘数 {
  self =>
  override type Next[T]    = 被乘数正数[被乘数零, T]
  override type 乘[T <: 乘数] = 自然数对零

  override def toString: String = "自然数零"
}

class 被乘数正数[Tail <: 被乘数, Head](val tail: Tail, val head: Head) extends 被乘数 {
  self =>
  override type Next[T]    = 被乘数正数[被乘数正数[Tail, Head], T]
  override type 乘[T <: 乘数] = Tail#乘[T]#加[T#复制[Head]]

  override def toString: String = s"$tail :: $head"
}

trait 乘数 extends 自然数 {
  override type Next[T] <: 乘数
  type 复制[T] <: 自然数对
}

class 乘数零 extends 乘数 {
  self =>
  override type Next[T] = 乘数正数[乘数零, T]
  override type 复制[T]   = 自然数对零

  override def toString: String = "自然数零"
}

class 乘数正数[Tail <: 乘数, Head](val tail: Tail, val head: Head) extends 乘数 {
  self =>
  override type Next[T] = 乘数正数[乘数正数[Tail, Head], T]
  override type 复制[T]   = 自然数对正数[Tail#复制[T], T, Head]

  override def toString: String = s"$tail :: $head"
}
