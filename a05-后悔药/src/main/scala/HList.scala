package a05

trait HList {

  type Drop[I] <: HList

  def drop[T](item: T): Drop[T]

}

class Zero extends HList {
  self =>

  override type Drop[I] = Zero

  override def drop[T](item: T): Zero = self

  override def toString: String = "Zero"

}

object Zero {
  val value: Zero = new Zero
}

case class Appendable[T <: HList, H](val tail: T, val head: H) extends HList {
  self =>

  override type Drop[I] = Appendable[T#Drop[H], I]
  type Chouqu           = T#Drop[H]

  override def drop[I](item: I): Appendable[Chouqu, I] = new Appendable(tail.drop(head), item)
  def chouqu: T#Drop[H]                                = tail.drop(head)

  override def toString: String = s"$tail :: $head"

}
