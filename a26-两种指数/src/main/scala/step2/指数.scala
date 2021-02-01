package step2

trait 底 {
  type 交[I <: 容器] <: 自然数
  type 退位[T <: 容器, I <: 指数, N <: 底] <: 自然数
}
trait 底Positive[Tail <: 底, Head] extends 底 {
  override type 交[I <: 容器]                   = 自然数Positive[Tail#交[I], Head]
  override type 退位[I <: 容器, T <: 指数, N <: 底] = T#恢复[N, 容器Positive[I, Tail, T]]
}
trait 底1[Total <: 底, Head] extends 底 {
  override type 交[I <: 容器]                   = 自然数Positive[I#容器恢复[Total], Head]
  override type 退位[I <: 容器, T <: 指数, N <: 底] = I#容器恢复[Total]
}

trait 指数 {
  type 恢复[N1 <: 底, I <: 容器] <: 自然数
}
class 指数Positive[Tail <: 指数] extends 指数 {
  override type 恢复[N1 <: 底, I <: 容器] = Tail#恢复[N1, 容器Positive[I, N1, Tail]]
}
class 指数Zero extends 指数 {
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
class 自然数Positive[Tail <: 自然数, Head] extends 自然数
class 自然数Zero                        extends 自然数
