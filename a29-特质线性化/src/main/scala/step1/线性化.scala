package step1

class Tag[T <: 自然数]

class 自然数IO[Input <: 自然数, Output <: 自然数]
object 自然数IO {
  def apply[T <: 自然数, P <: 自然数](i: Tag[T])(implicit pp: 自然数IO[T, P]): Tag[P] = new Tag[P]
}
class 自然数Func[U <: 自然数, N, I[_ <: 自然数, _] <: 自然数]

trait 自然数 {
  type In <: 自然数
}

class 自然数Positive[Tail <: 自然数, Head] extends 自然数 {
  override type In = 自然数Positive[Tail#In, Head]
}
object 自然数Positive extends 自然数Positive2 {
  implicit def n[T <: 自然数, H]: 自然数Func[自然数Positive[T, H], H, ({ type T[I <: 自然数, _] = I })#T] = new 自然数Func[自然数Positive[T, H], H, ({ type T[I <: 自然数, _] = I })#T]
  implicit def n3[T <: 自然数, T2 <: 自然数, H, I[_ <: 自然数, _] <: 自然数](implicit k: 自然数Func[T, H, I], k2: 自然数IO[T, T2]): 自然数IO[自然数Positive[T, H], I[T2, H]] =
    new 自然数IO[自然数Positive[T, H], I[T2, H]]
}
trait 自然数Positive2 {
  implicit def n2[T <: 自然数, H, H1, II[_ <: 自然数, _] <: 自然数](implicit i: 自然数Func[T, H1, II]): 自然数Func[自然数Positive[T, H], H1, II] = new 自然数Func[自然数Positive[T, H], H1, II]
}

class 自然数Zero extends 自然数 {
  override type In = 自然数Zero
}
object 自然数Zero {
  implicit def n22[T <: 自然数, H, H1]: 自然数Func[自然数Zero, H1, ({ type T[I <: 自然数, N] = 自然数Positive[I, N] })#T] =
    new 自然数Func[自然数Zero, H1, ({ type T[I <: 自然数, N] = 自然数Positive[I, N] })#T]
  implicit val n33: 自然数IO[自然数Zero, 自然数Zero] = new 自然数IO[自然数Zero, 自然数Zero]
}
