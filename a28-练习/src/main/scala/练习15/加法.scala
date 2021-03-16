package 练习15

trait 被加数
class 被加数Positive[Tail <: 被加数, Head] extends 被加数
class 被加数Zero                        extends 被加数

trait 加数 {
  type 加[N <: 被加数] <: 被加数
}
class 加数Positive[Tail <: 加数, Head] extends 加数 {
  override type 加[N <: 被加数] = 被加数Positive[Tail#加[N], Head]
}
class 加数Zero extends 加数 {
  override type 加[N <: 被加数] = N
}
