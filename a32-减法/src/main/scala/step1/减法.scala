package step1

class 减数操作 {
  type 壁虎取尾[Tail1 <: 被减数, Head1, Tail2 <: 减数, Head2] = Tail2#减[Tail1]
}

trait 自然数

trait 被减数 extends 自然数 {
  type 被减[T <: 减数, H] <: 自然数
}

class 被减数Positive[Tail <: 被减数, Head] extends 被减数 {
  type 被减[T <: 减数, H] = 减数操作#壁虎取尾[Tail, Head, T, H]
}

class 被减数Zero extends 被减数 {
  type 被减[T <: 减数, H] = 减数Positive[T, H]
}

trait 减数 extends 自然数 {
  type 减[T <: 被减数] <: 自然数
}

class 减数Positive[Tail <: 减数, Head] extends 减数 {
  type 减[T <: 被减数] = T#被减[Tail, Head]
}

class 减数Zero extends 减数 {
  type 减[T <: 被减数] = T
}
