package a05

trait HList {

  type Add[T] <: HList
  type Drop[I] <: HList

  def add[T](item: T): Add[T]
  def drop[T](item: T): Drop[T]

}

class Zero extends HList {
  self =>

  override type Add[T]  = Appendable[Zero, T]
  override type Drop[I] = Zero

  override def add[T](item: T): Appendable[Zero, T] = new Appendable(self, item)
  override def drop[T](item: T): Zero               = self

  override def toString: String = "Zero"

}

object Zero {
  val value: Zero = new Zero
}

class Appendable[T <: HList, H](val tail: T, val head: H) extends HList {
  self =>

  override type Add[I]  = Appendable[Appendable[T, H], I]
  override type Drop[I] = Chouqu#Add[I]
  type Chouqu           = T#Drop[H]

  override def add[I](item: I): Appendable[Appendable[T, H], I] = new Appendable(self, item)
  override def drop[I](item: I): Chouqu#Add[I]                  = chouqu.add(item)
  def chouqu: Chouqu                                            = tail.drop(head)

  override def toString: String = s"$tail :: $head"

}
