package step1

trait 整数 {
  type Successor[T] <: 整数
  type Predecessor <: 整数
  type 加[T <: 整数] <: 整数
  type 被加正数[T <: 整数, H] <: 整数
  type 被加负数[T[H] <: 负数容器[H]] <: 整数
}

class 零 extends 整数 {
  override type Successor[T]          = 正数[零, T]
  override type Predecessor           = 负数[({ type H[L] = 负数容器负数[零, L] })#H]
  override type 加[T <: 整数]            = T
  override type 被加正数[T <: 整数, H]      = 正数[T, H]
  override type 被加负数[T[H] <: 负数容器[H]] = 负数[T]
}

class 正数[Tail <: 整数, Head] extends 整数 {
  override type Successor[T]          = 正数[正数[Tail, Head], T]
  override type Predecessor           = Tail
  override type 加[T <: 整数]            = T#被加正数[Tail, Head]
  override type 被加正数[T <: 整数, H]      = 正数[Tail#被加正数[T, H], Head]
  override type 被加负数[T[H] <: 负数容器[H]] = T[Head]#负数部分#加[Tail]
}

class 负数[Tail[H] <: 负数容器[H]] extends 整数 {
  override type Successor[T]          = Tail[T]#负数部分
  override type Predecessor           = 负数[({ type H[L] = 负数容器负数[负数[Tail], L] })#H]
  override type 加[T <: 整数]            = T#被加负数[Tail]
  override type 被加正数[T <: 整数, H]      = T#加[Tail[H]#负数部分]
  override type 被加负数[T[H] <: 负数容器[H]] = 负数[({ type H[L] = 负数容器负数[Tail[L]#负数部分#被加负数[T], L] })#H]
}

trait 负数容器[H] {
  type 负数部分 <: 整数
}
class 负数容器负数[F <: 整数, H] extends 负数容器[H] {
  override type 负数部分 = F
}
