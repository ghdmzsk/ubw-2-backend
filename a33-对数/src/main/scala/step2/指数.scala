package step2

trait 底 {
  type 划圈[T <: 指数, R1 <: 隐数, R2 <: 隐数] <: 隐数
}
class 底Positive[Tail <: 底, Head] extends 底 {
  override type 划圈[T <: 指数, R1 <: 隐数, R2 <: 隐数] = Tail#划圈[T, 隐数Positive[R1, Head], R2]
}
class 底1[Tail <: 底] extends 底 {
  override type 划圈[T <: 指数, R1 <: 隐数, R2 <: 隐数] = R2#G点[Tail, T, R1]
}

trait 指数 {
  type 被划圈[D <: 底, R <: 隐数] <: 隐数
}
class 指数Positive[Tail <: 指数, Head] extends 指数 {
  override type 被划圈[D <: 底, R <: 隐数] = D#划圈[Tail, R, R]
}
class 指数1 extends 指数 {
  override type 被划圈[D <: 底, R <: 隐数] = R
}

trait 隐数 {
  type G点[D <: 底, T <: 指数, R <: 隐数] <: 隐数
}
class 隐数Positive[Tail <: 隐数, Head] extends 隐数 {
  type T                                     = Tail
  override type G点[D <: 底, T <: 指数, R <: 隐数] = D#划圈[T, R, Tail]
}
class 隐数1 extends 隐数 {
  override type G点[D <: 底, T <: 指数, R <: 隐数] = T#被划圈[D, R]
}

class log {
  type run[D <: 底, T <: 指数] = D#划圈[T, 隐数1, 隐数1]
}
