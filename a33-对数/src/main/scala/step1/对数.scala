package step1

trait 底 {
  type 深入[T <: 真数, R <: 真数] <: 对数
  type 划圈[T <: 真数, R <: 真数] <: 对数
}
class 底Positive[Tail <: 底, Head] extends 底 {
  override type 深入[T <: 真数, R <: 真数] = T#对[Tail, Head]
  override type 划圈[T <: 真数, R <: 真数] = T#被划圈[Tail, Head, R]
}
class 底Zero[Tail <: 底] extends 底 {
  override type 深入[T <: 真数, R <: 真数] = 对数Positive[Tail#划圈[T, R]]
  override type 划圈[T <: 真数, R <: 真数] = R#G点[Tail, T]
}

trait 真数 {
  type 对[D <: 底, H] <: 对数
  type 被划圈[D <: 底, H, R <: 真数] <: 对数
  type G点[D <: 底, T <: 真数]
}
class 真数Positive[Tail <: 真数, Reverse <: 真数, Head] extends 真数 {
  override type 对[D <: 底, H]            = D#深入[Tail, Reverse]
  override type 被划圈[D <: 底, H, R <: 真数] = D#划圈[Tail, R]
  override type G点[D <: 底, T <: 真数]     = D#划圈[T, Tail]
}
class 真数Zero[Reverse <: 真数] extends 真数 {
  override type 对[D <: 底, H]            = 对数Zero
  override type 被划圈[D <: 底, H, R <: 真数] = 对数Zero
  override type G点[D <: 底, T <: 真数]     = 对数Positive[D#深入[T]]
}

trait 对数
class 对数Positive[Tail <: 对数] extends 对数
class 对数Zero                 extends 对数
