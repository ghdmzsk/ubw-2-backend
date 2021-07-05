package 练习25

trait b被乘数 {
  type 被乘[T <: c乘数] <: z自然数
}
class b被乘数Positive[Tail <: b被乘数] extends b被乘数 {
  override type 被乘[T <: c乘数] = T#乘[Tail]
}
class b被乘数Zero extends b被乘数 {
  override type 被乘[T <: c乘数] = z自然数Zero
}

trait c乘数 {
  type 乘[T <: b被乘数] <: z自然数
}
class c乘数Positive[Tail <: c乘数] extends c乘数 {
  override type 乘[T <: b被乘数] = z自然数Positive[Tail#乘[T]]
}
class c乘数Zero[Tail <: c乘数] extends c乘数 {
  override type 乘[T <: b被乘数] = T#被乘[Tail]
}

trait z自然数
class z自然数Positive[Tail <: z自然数] extends z自然数
class z自然数Zero                   extends z自然数
