package 练习07

trait 被除数 {
  type 被除[T <: 除数, H] <: 商
}
class 被除数Positive[Tail <: 被除数, Head] extends 被除数 {
  override type 被除[T <: 除数, H] = T#除[Tail]
}
class 被除数Zero extends 被除数 {
  override type 被除[T <: 除数, H] = 商Zero
}

trait 除数 {
  type 除[T <: 被除数] <: 商
}
class 除数Positive[Tail <: 除数, Head] extends 除数 {
  override type 除[T <: 被除数] = T#被除[Tail, Head]
}
trait 除数Zero[Tail <: 除数] extends 除数 {
  override type 除[T <: 被除数] = 商Postive[Tail#除[T]]
}

trait 商
class 商Postive[Tail <: 商] extends 商
class 商Zero               extends 商
