package 练习05

trait 被乘数 {
  type 被乘[T <: 乘数] <: 自然数
}
class 被乘数Positive[Tail <: 被乘数, Head] extends 被乘数 {
  override type 被乘[T <: 乘数] = T#乘[Tail, Head]
}
class 被乘数Zero extends 被乘数 {
  override type 被乘[T <: 乘数] = 自然数Zero
}

trait 乘数 {
  type 乘[T <: 被乘数, H] <: 自然数
}
class 乘数Positive[Tail <: 乘数, Head] extends 乘数 {
  override type 乘[T <: 被乘数, H] = 自然数Positive[Tail#乘[T, H], Head, H]
}
class 乘数Zero[Tail <: 乘数] extends 乘数 {
  override type 乘[T <: 被乘数, H] = T#被乘[Tail]
}

trait 自然数
class 自然数Positive[Tail <: 自然数, Head1, Head2] extends 自然数
class 自然数Zero                                extends 自然数
