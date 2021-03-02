package step1

trait 底 {
  type 划圈[T <: 真数, R1 <: 隐数, R2 <: 隐数] <: 对数
}
class 底Positive[Tail <: 底, Head] extends 底 {
  override type 划圈[T <: 真数, R1 <: 隐数, R2 <: 隐数] = T#被划圈[Tail, Head, 隐数Positive[R1], R2]
}
class 底1[Tail <: 底] extends 底 {
  override type 划圈[T <: 真数, R1 <: 隐数, R2 <: 隐数] = R2#G点[Tail, T, R1]
}

trait 真数 {
  type 被划圈[D <: 底, H, R1 <: 隐数, R2 <: 隐数] <: 对数
}
class 真数Positive[Tail <: 真数, Head] extends 真数 {
  override type 被划圈[D <: 底, H, R1 <: 隐数, R2 <: 隐数] = D#划圈[Tail, R1, R2]
}
class 真数1 extends 真数 {
  override type 被划圈[D <: 底, H, R1 <: 隐数, R2 <: 隐数] = 对数Zero
}

trait 隐数 {
  type G点[D <: 底, T <: 真数, R <: 隐数] <: 对数
}
class 隐数Positive[Tail <: 隐数] extends 隐数 {
  override type G点[D <: 底, T <: 真数, R <: 隐数] = D#划圈[T, R, Tail]
}
class 隐数Zero extends 隐数 {
  override type G点[D <: 底, T <: 真数, R <: 隐数] = 对数Positive[D#划圈[T, R, R]]
}

class log {
  type run[D <: 底, T <: 真数] = D#划圈[T, 隐数Zero, 隐数Zero]
}

trait 对数
class 对数Positive[Tail <: 对数] extends 对数
class 对数Zero                 extends 对数
