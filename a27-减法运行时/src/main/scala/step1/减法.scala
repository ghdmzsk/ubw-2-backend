package step1

trait 自然数
trait 自然数Positive[Tail<: 自然数,Head]
trait 自然数Zero

trait 被减数 {
  type 被减[I <: 减数,T] <: 自然数
}
trait 被减数Positive[Tail <: 底, Head] extends 被减数 {
  override type 被减[I <: 减数,T]                   = 自然数Positive[Tail#交[I], Head]
}
trait 被减数Zero[Total <: 底, Head] extends 被减数 {
  override type 被减[I <: 减数,T]                   = 自然数Positive[I#容器恢复[Total], Head]
}

trait 指数 {
  type 指数[N <: 底] = 指[N, 容器Zero]
  type 指[N <: 底, I <: 容器] <: 自然数
  type 恢复[N1 <: 底, I <: 容器] <: 自然数
}
class 指数Positive[Tail <: 指数] extends 指数 {
  override type 指[N <: 底, I <: 容器]   = Tail#指[N, 容器Positive[I, N, Tail]]
  override type 恢复[N1 <: 底, I <: 容器] = Tail#恢复[N1, 容器Positive[I, N1, Tail]]
}
class 指数1 extends 指数 {
  override type 指[N <: 底, I <: 容器]  = N#交[I]
  override type 恢复[N <: 底, I <: 容器] = N#交[I]
}

trait 容器 {
  type 容器恢复[N <: 底] <: 自然数
}
class 容器Positive[Tail <: 容器, Head1 <: 底, Head2 <: 指数] extends 容器 {
  override type 容器恢复[N <: 底] = Head1#退位[Tail, Head2, N]
}
class 容器Zero extends 容器 {
  override type 容器恢复[N <: 底] = 自然数Zero
}

trait 自然数
class 自然数Positive[T <: 自然数, H] extends 自然数 {
  type Self = 自然数Positive[T, H]
}
class 自然数Zero extends 自然数
