package step2

trait 积
class 积Positive[Tail <: 积, T1, T2] extends 积
class 积Zero                        extends 积

trait 被乘数 {
  type 乘以[N <: 乘数] <: 积
}
class 被乘数Positive[Tail <: 被乘数, Head] extends 被乘数 {
  override type 乘以[N <: 乘数] = N#乘[Tail, Head]
}
class 被乘数Zero extends 被乘数 {
  override type 乘以[N <: 乘数] = 积Zero
}

trait 乘数 {
  type 乘[N <: 被乘数, Head2] <: 积
}
class 乘数Positive[Tail <: 乘数, Head] extends 乘数 {
  override type 乘[N <: 被乘数, Head2] = 积Positive[Tail#乘[N, Head2], Head, Head2]
}
class 乘数Zero[Tail <: 乘数] extends 乘数 {
  override type 乘[N <: 被乘数, Head2] = N#乘以[Tail]
}
