package plus

trait HList {

  type Head
  type Tail <: HList
  type Plus[T <: HList] <: HList
  type Add[N] <: HList

  def head: Head
  def tail: Tail
  def plus[T <: HList](h: T): Plus[T]
  def add[N](n: N): Add[N]

}

class Appendable[T <: HList, H](override val tail: T, override val head: H) extends HList {
  self =>

  override type Head             = H
  override type Tail             = T
  override type Plus[P <: HList] = T#Plus[P#Add[H]]
  override type Add[N]           = Appendable[Appendable[T, H], N]

  override def plus[P <: HList](h: P): T#Plus[P#Add[H]]      = tail.plus(h.add(head))
  override def add[N](n: N): Appendable[Appendable[T, H], N] = new Appendable(self, n)

  override def toString: String = s"${tail} , ${head}"

}

class Zero extends HList {
  self =>

  override type Head             = ZeroValue
  override type Tail             = Zero
  override type Plus[T <: HList] = T
  override type Add[T]           = Appendable[Zero, T]

  override def head: ZeroValue                   = ZeroValue.value
  override def tail: Zero                        = self
  override def plus[T <: HList](h: T): T         = h: T
  override def add[N](n: N): Appendable[Zero, N] = new Appendable(self, n)

  override def toString: String = "Zero"

}

object Zero {
  val value: Zero = new Zero
}
