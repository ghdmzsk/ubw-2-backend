package step1_钢铁直男

trait 积 {
  type Plus[N <: 积] <: 积
}
class 积Positive[Tail <: 积, T1, T2] extends 积 {
  override type Plus[N <: 积] = 积Positive[Tail#Plus[N], T1, T2]
}
class 积Zero extends 积 {
  override type Plus[N <: 积] = N
}

trait 被乘数 {
  type Copy[Head2] <: 积
}
class 被乘数Positive[Tail <: 被乘数, Head] extends 被乘数 {
  override type Copy[Head2] = 积Positive[Tail#Copy[Head2], Head, Head2]
}
class 被乘数Zero extends 被乘数 {
  override type Copy[Head2] = 积Zero
}

trait 乘数 {
  type 乘[N <: 被乘数] <: 积
}
class 乘数Positive[Tail <: 乘数, Head] extends 乘数 {
  override type 乘[N <: 被乘数] = N#Copy[Head]#Plus[Tail#乘[N]]
}
class 乘数Zero extends 乘数 {
  override type 乘[N <: 被乘数] = 积Zero
}
