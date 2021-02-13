package step2

trait 整数 {
  type 加[T <: 整数] <: 整数
  type 被加正数[T <: 整数, H] <: 整数
  type 被加负数[T[D] <: 整数, H] <: 整数
}

class 零 extends 整数 {
  override type 加[T <: 整数]          = T
  override type 被加正数[T <: 整数, H]    = 正数[T, H]
  override type 被加负数[T[D] <: 整数, H] = 负数[T, H]
}

class 正数[Tail <: 整数, Head] extends 整数 {
  override type 加[T <: 整数]          = T#被加正数[Tail, Head]
  override type 被加正数[T <: 整数, H]    = 正数[Tail#被加正数[T, H], Head]
  override type 被加负数[T[D] <: 整数, H] = Tail#加[T[Head]]
}

class 负数[Tail[D] <: 整数, Head] extends 整数 {
  override type 加[T <: 整数]          = T#被加负数[Tail, Head]
  override type 被加正数[T <: 整数, H]    = Tail[H]#加[T]
  override type 被加负数[T[D] <: 整数, H] = 负数[({ type N[M] = Tail[M]#被加负数[T, H] })#N, Head]
}
