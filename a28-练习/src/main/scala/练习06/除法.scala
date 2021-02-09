package 练习06

trait 被除数 {
  type 被除[T <: 除数, H] <: 自然数
}
class 被除数Positive[Tail <: 被除数, Head] extends 被除数 {
  override type 被除[T <: 除数, H] = T#除[Tail]
}
class 被除数Zero extends 被除数 {
  override type 被除[T <: 除数, H] = 自然数Zero
}

trait 除数 {
  type 除[T <: 被除数] <: 自然数
}
class 除数Positive[Tail <: 除数, Head] extends 除数 {
  override type 除[T <: 被除数] = T#被除[Tail, Head]
}
class 除数Zero[Tail <: 除数] extends 除数 {
  override type 除[T <: 被除数] = 自然数Positive[Tail#除[T]]
}

trait 自然数
class 自然数Positive[Tail <: 自然数] extends 自然数
class 自然数Zero                  extends 自然数
