package plus

class Zero extends HList {
  self =>

  override type Head               = ZeroValue
  override type Tail               = Zero
  override type Plus[T <: HList]   = T
  override type Add[T]             = Appendable[T, Zero]
  override type RePlus[P <: HList] = P

  override def head: ZeroValue                   = ZeroValue.value
  override def tail: Zero                        = self
  override def plus[T <: HList](h: T): T         = h
  override def add[N](n: N): Appendable[N, Zero] = new Appendable(n, self)
  override def rePlus[T <: HList](h: T): T       = h

  override def toString: String = "Zero"

}

object Zero {
  val value: Zero = new Zero
}
