package 练习12

trait 被乘数 {
  type 乘以[T <: 乘数, H] <: 积
}
class 被乘数Positive[Tail <: 被乘数, Head] extends 被乘数 {
  override type 乘以[T <: 乘数, H] = 积Positive[Tail#乘以[T, H], Head, H]
}
class 被乘数Zero[Tail <: 被乘数] extends 被乘数 {
  override type 乘以[T <: 乘数, H] = T#乘[Tail]
}

trait 乘数 {
  type 乘[T <: 被乘数] <: 积
}
class 乘数Positive[Tail <: 乘数, Head] extends 乘数 {
  override type 乘[T <: 被乘数] = T#乘以[Tail, Head]
}
class 乘数Zero extends 乘数 {
  override type 乘[T <: 被乘数] = 积Zero
}

trait 积
class 积Positive[Tail <: 积, Head1, Head2] extends 积
class 积Zero                              extends 积
