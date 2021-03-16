package 练习14

trait 被除数 {
  type 除以[T <: 除数, H] <: 商
  def 除以[T <: 除数, H](t: T, h: H): 除以[T, H]
}
class 被除数Positive[Tail <: 被除数, Head](val tail: Tail, val head: Head) extends 被除数 {
  override type 除以[T <: 除数, H] = T#除[Tail]
  override def 除以[T <: 除数, H](t: T, h: H): T#除[Tail] = t.除(tail)
}
class 被除数Zero extends 被除数 {
  override type 除以[T <: 除数, H] = 商Zero
  override def 除以[T <: 除数, H](t: T, h: H): 商Zero = new 商Zero
}
object 被除数Zero {
  val value: 被除数Zero = new 被除数Zero
}
object 被除数 {
  def apply(i: Int): 被除数 = i match {
    case j if j >= 1 => new 被除数Positive(apply(i - 1), s"Item${j}")
    case 0           => 被除数Zero.value
  }
}

trait 除数 {
  type 除[T <: 被除数] <: 商
  def 除[T <: 被除数](t: T): 除[T]
}
class 除数Positive[Tail <: 除数, Head](val tail: Tail, val head: Head) extends 除数 {
  override type 除[T <: 被除数] = T#除以[Tail, Head]
  override def 除[T <: 被除数](t: T): T#除以[Tail, Head] = t.除以(tail, head)
}
abstract class 除数Zero[Tail <: 除数] extends 除数 {
  def tail: Tail

  override type 除[T <: 被除数] = 商Positive[Tail#除[T]]
  override def 除[T <: 被除数](t: T): 商Positive[Tail#除[T]] = new 商Positive(tail.除(t))
}
object 除数 {
  def apply(i: Int): 除数 = {
    def ii(tail1: () => 除数, ib: Int): 除数 = ib match {
      case j if j >= 1 => new 除数Positive(ii(tail1, j - 1), s"Item${j}")
      case 0 =>
        new 除数Zero[除数] {
          override lazy val tail: 除数 = tail1()
        }
    }
    lazy val bb: 除数 = ii(() => bb, i)
    bb
  }
}

trait 商 {
  def value: Int
}
class 商Positive[Tail <: 商](val tail: Tail) extends 商 {
  override def value: Int = tail.value + 1
}
class 商Zero extends 商 {
  override def value: Int = 0
}
