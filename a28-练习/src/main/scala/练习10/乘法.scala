package 练习10

trait 被乘数 {
  type 被乘[T <: 乘数] <: 积
}
class 被乘数Zero extends 被乘数 {
  override type 被乘[T <: 乘数] = 积Zero
}
class 被乘数Positive[Tail <: 被乘数, Head] extends 被乘数 {
  override type 被乘[T <: 乘数] = T#乘[Tail, Head]
}

trait 乘数 {
  type 乘[T <: 被乘数, H] <: 积
}
class 乘数Zero[Tail <: 乘数] extends 乘数 {
  override type 乘[T <: 被乘数, H] = T#被乘[Tail]
}
class 乘数Positive[Tail <: 乘数, Head] extends 乘数 {
  override type 乘[T <: 被乘数, H] = 积Positive[Tail#乘[T, H], Head, H]
}

trait 积
class 积Zero                              extends 积
class 积Positive[Tail <: 积, Head1, Head2] extends 积
