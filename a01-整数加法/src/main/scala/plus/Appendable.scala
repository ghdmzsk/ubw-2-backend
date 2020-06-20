package plus

class Appendable[H, T <: HList](override val head: H, override val tail: T) extends HList {
  self =>

  override type Head               = H
  override type Tail               = T
  override type Plus[P <: HList]   = T#Plus[P]#Add[H]
  override type RePlus[P <: HList] = P#Plus[Appendable[H, T]]
  override type Add[N]             = Appendable[N, Appendable[H, T]]

  override def plus[P <: HList](h: P): T#Plus[P]#Add[H]           = tail.plus(h).add(head)
  override def add[N](n: N): Appendable[N, Appendable[H, T]]      = new Appendable(n, self)
  override def rePlus[P <: HList](h: P): P#Plus[Appendable[H, T]] = h.plus(self)

  override def toString: String = s"${tail} , ${head}"

}
