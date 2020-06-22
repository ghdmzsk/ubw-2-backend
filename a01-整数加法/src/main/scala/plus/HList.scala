package plus

trait HList {

  type Head
  type Tail <: HList
  type Plus[T <: HList] <: HList
  type Add[N] <: HList
  type RePlus[P <: HList] <: HList

  def head: Head
  def tail: Tail
  def plus[T <: HList](h: T): Plus[T]
  def add[N](n: N): Add[N]
  def rePlus[T <: HList](h: T): RePlus[T]

}

class Appendable[H, T <: HList](override val head: H, override val tail: T) extends HList {
  self =>

  override type Head               = H
  override type Tail               = T
  override type Plus[P <: HList]   = T#Plus[P]#Add[H]
  override type RePlus[P <: HList] = P#Plus[Appendable[H, T]]
  override type Add[N]             = Appendable[N, Appendable[H, T]]

  override def plus[P <: HList](h: P): T#Plus[P]#Add[H]           = ((tail: T).plus[P](h: P): T#Plus[P]).add[H](head: H): T#Plus[P]#Add[H]
  override def add[N](n: N): Appendable[N, Appendable[H, T]]      = new Appendable[N, Appendable[H, T]](n: N, self: Appendable[H, T])
  override def rePlus[P <: HList](h: P): P#Plus[Appendable[H, T]] = (h: P).plus[Appendable[H, T]](self: Appendable[H, T]): P#Plus[Appendable[H, T]]

  override def toString: String = s"${tail} , ${head}"

}

class Zero extends HList {
  self =>

  override type Head               = ZeroValue
  override type Tail               = Zero
  override type Plus[T <: HList]   = T
  override type Add[T]             = Appendable[T, Zero]
  override type RePlus[P <: HList] = P

  override def head: ZeroValue                   = ZeroValue.value: ZeroValue
  override def tail: Zero                        = self: Zero
  override def plus[T <: HList](h: T): T         = h: T
  override def add[N](n: N): Appendable[N, Zero] = new Appendable[N, Zero](n: N, self: Zero)
  override def rePlus[T <: HList](h: T): T       = h: T

  override def toString: String = "Zero"

}

object Zero {
  val value: Zero = new Zero
}
