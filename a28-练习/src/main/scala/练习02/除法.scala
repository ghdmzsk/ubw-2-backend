package 练习02

trait 被除数 {
  type 被除[T <: 除数] <: 商
}
trait 被除数Positive[Tail <: 被除数] extends 被除数 {
  override type 被除[T <: 除数] = T#除[Tail]
}
trait 被除数Zero extends 被除数 {
  override type 被除[T <: 除数] = 商Zero
}

trait 除数 {
  type 除[I <: 被除数] <: 商
}
class 除数Positive[Tail <: 除数] extends 除数 {
  override type 除[I <: 被除数] = I#被除[Tail]
}
class 除数Zero[Tail <: 除数] extends 除数 {
  override type 除[I <: 被除数] = 商Positive[Tail#除[I]]
}

trait 商
class 商Positive[Tail <: 商] extends 商
class 商Zero                extends 商
