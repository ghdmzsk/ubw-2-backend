package 练习01

trait 底 {
  type 交缠[T <: 太极] <: 自然数
  type 退位[N <: 指数, T <: 太极, I <: 底] <: 自然数
}
trait 底Positive[Tail <: 底, Head] extends 底 {
  override type 交缠[T <: 太极]                  = 自然数Positive[Tail#交缠[T], Head]
  override type 退位[N <: 指数, T <: 太极, I <: 底] = N#逆[I, 太极Positive[T, Tail, N]]
}
trait 底1[Tail <: 底, Head] extends 底 {
  override type 交缠[T <: 太极]                  = 自然数Positive[T#退位[Tail], Head]
  override type 退位[N <: 指数, T <: 太极, I <: 底] = T#退位[Tail]
}

trait 指数 {
  type 逆[I <: 底, T <: 太极] <: 自然数
}
class 指数Positive[Tail <: 指数] extends 指数 {
  override type 逆[I <: 底, T <: 太极] = Tail#逆[I, 太极Positive[T, I, Tail]]
}
class 指数1 extends 指数 {
  override type 逆[I <: 底, T <: 太极] = I#交缠[T]
}

class 指数运算 {
  type 指[I <: 底, N <: 指数] = N#逆[I, 太极Zero]
}

trait 太极 {
  type 退位[Total <: 底] <: 自然数
}
class 太极Positive[Tail <: 太极, Head1 <: 底, Head2 <: 指数] extends 太极 {
  override type 退位[Total <: 底] = Head1#退位[Head2, Tail, Total]
}
class 太极Zero extends 太极 {
  override type 退位[Total <: 底] = 自然数Zero
}

trait 自然数
class 自然数Positive[Tail <: 自然数, Head] extends 自然数
class 自然数Zero                        extends 自然数
