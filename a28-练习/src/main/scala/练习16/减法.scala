package 练习16

trait 自然数
trait 自然数Positive[Tail <: 自然数, Head] extends 自然数
trait 自然数Zero

trait 被减数 extends 自然数 {
  type 减去[N <: 减数, H] <: 自然数
}
class 被减数Positive[Tail <: 被减数, Head] extends 被减数 with 自然数Positive[Tail, Head] {
  override type 减去[N <: 减数, H] = N#减[Tail]
}
class 被减数Zero extends 被减数 with 自然数Zero {
  override type 减去[N <: 减数, H] = 减数Positive[N, H]
}

trait 减数 extends 自然数 {
  type 减[N <: 被减数] <: 自然数
}
class 减数Positive[Tail <: 减数, Head] extends 减数 with 自然数Positive[Tail, Head] {
  override type 减[N <: 被减数] = N#减去[Tail, Head]
}
class 减数Zero extends 减数 with 自然数Zero {
  override type 减[N <: 被减数] = N
}
