package step1

trait 自然数 {
  def length: Int
}
trait 自然数Positive[Tail <: 自然数, Head] extends 自然数 {
  def tail: Tail
  def head: Head
  override def length: Int      = tail.length + 1
  override def toString: String = s"${tail} :: ${head}"
}
trait 自然数Zero extends 自然数 {
  override def length: Int      = 0
  override def toString: String = "零"
}

trait 被减数 extends 自然数 {
  type 被减[I <: 减数, T] <: 自然数
  def 被减[I <: 减数, T](ii: 减数Positive[I, T]): 被减[I, T]
}
class 被减数Positive[Tail <: 被减数, Head](override val tail: Tail, override val head: Head) extends 被减数 with 自然数Positive[Tail, Head] {
  override type 被减[I <: 减数, T] = I#减[Tail]
  override def 被减[I <: 减数, T](ii: 减数Positive[I, T]): I#减[Tail] = {
    val i1 = ii.tail
    val i2 = this.tail
    i1.减(i2)
  }
}
class 被减数Zero extends 被减数 with 自然数Zero {
  override type 被减[I <: 减数, T] = 减数Positive[I, T]
  override def 被减[I <: 减数, T](ii: 减数Positive[I, T]): 减数Positive[I, T] = ii
}

trait 减数 extends 自然数 {
  type 减[N <: 被减数] <: 自然数
  def 减[N <: 被减数](n: N): 减[N]
}
class 减数Positive[Tail <: 减数, Head](override val tail: Tail, override val head: Head) extends 减数 with 自然数Positive[Tail, Head] {
  override type 减[N <: 被减数] = N#被减[Tail, Head]
  override def 减[N <: 被减数](n: N): N#被减[Tail, Head] = n.被减(this)
}
class 减数Zero extends 减数 with 自然数Zero {
  override type 减[N <: 被减数] = N
  override def 减[N <: 被减数](n: N): N = n
}
