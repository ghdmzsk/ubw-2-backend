package a13.乘法

trait 自然数 {
  type Next[T] <: 自然数
  type 复制[T] <: 自然数对
  type 乘以[T <: 自然数] <: 自然数对
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

class 自然数零 extends 自然数 {
  self =>
  override type Next[T]      = 自然数正数[自然数零, T]
  override type 复制[T]        = 自然数对零
  override type 乘以[T <: 自然数] = 自然数对零

  override def toString: String = "自然数零"
}

class 自然数正数[Tail <: 自然数, Head](val tail: Tail, val head: Head) extends 自然数 {
  self =>
  override type Next[T]      = 自然数正数[自然数正数[Tail, Head], T]
  override type 复制[T]        = 自然数对正数[Tail#复制[T], T, Head]
  override type 乘以[T <: 自然数] = T#复制[Head]#加[Tail#乘以[T]]

  override def toString: String = s"$tail :: $head"
}
