package plus

trait HList {

  type Plus[T <: HList] <: HList
  type RePlus[P <: HList] <: HList
  type Add[N] <: HList

  def plus[T <: HList](h: T): Plus[T]
  def rePlus[T <: HList](h: T): RePlus[T]
  def add[N](n: N): Add[N]

}

class Appendable[T <: HList, H](val tail: T, val head: H) extends HList {
  self =>

  @deprecated("在加法实现中不是必须的", "1.0")
  type Head = H
  @deprecated("在加法实现中不是必须的", "1.0")
  type Tail = T

  override type Plus[P <: HList]   = T#Plus[P]#Add[H]
  override type RePlus[P <: HList] = P#Plus[Appendable[T, H]]
  override type Add[N]             = Appendable[Appendable[T, H], N]

  override def plus[P <: HList](h: P): T#Plus[P]#Add[H]           = tail.plus(h).add(head)
  override def rePlus[P <: HList](h: P): P#Plus[Appendable[T, H]] = h.plus(self)
  override def add[N](n: N): Appendable[Appendable[T, H], N]      = new Appendable(self, n)

  override def toString: String = s"${tail} , ${head}"

}

class Zero extends HList {
  self =>

  override type Plus[T <: HList]   = T
  override type RePlus[P <: HList] = P#Plus[Zero]
  override type Add[T]             = Appendable[Zero, T]

  override def plus[T <: HList](h: T): T         = h
  override def rePlus[T <: HList](h: T): T       = h: T
  override def add[N](n: N): Appendable[Zero, N] = new Appendable(self, n)

  override def toString: String = "Zero"

}

object Zero {
  val value: Zero = new Zero
}
