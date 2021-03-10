package 练习13

trait 被除数 {
  type 除以[T <: 除数, H] <: 商
}
class 被除数Positive[Tail <: 被除数, Head] extends 被除数 {
  override type 除以[T <: 除数, H] = T#除[Tail]
}
class 被除数Zero extends 被除数 {
  override type 除以[T <: 除数, H] = 商Zero
}

trait 除数 {
  type 除[T <: 被除数] <: 商
}
class 除数Positive[Tail <: 除数, Head] extends 除数 {
  override type 除[T <: 被除数] = T#除以[Tail, Head]
}
class 除数Zero[Tail <: 除数] extends 除数 {
  override type 除[T <: 被除数] = 商Positive[Tail#除[T]]
}

trait 商
class 商Positive[Tail <: 商] extends 商
class 商Zero                extends 商
