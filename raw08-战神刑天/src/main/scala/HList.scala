import scala.language.higherKinds

trait HList {

  type Head
  def head: Head

  type Tail <: HList
  def tail: Tail

  type Append[I] <: HList
  def append[I](i: I): Append[I]

  type Contribute <: HList
  def contribute: Contribute

  type ReverseAppend[I] <: HList
  def reverseAppend[I](i: I): ReverseAppend[I]

}

class Appendable[H, T <: HList](override val head: H, override val tail: T) extends HList {
  self =>

  override type Head = H
  override type Tail = T

  override type Append[I] = Appendable[I, Appendable[H, T]]
  override def append[I](i: I): Appendable[I, Appendable[H, T]] = new Appendable(i, self)

  override type Contribute = T#ReverseAppend[H]
  override def contribute: T#ReverseAppend[H] = tail.reverseAppend(head)

  override type ReverseAppend[I] = Appendable[I, T#ReverseAppend[H]]
  override def reverseAppend[I](i: I): Appendable[I, T#ReverseAppend[H]] = new Appendable(i, tail.reverseAppend(head))

  override def toString: String = head.toString + ", " + tail.toString

}

class Undefined
object Undefined {
  val undefined: Undefined = new Undefined
}

class HNil extends HList {
  self =>

  override type Head = Undefined
  override def head: Undefined = Undefined.undefined
  override type Tail = HNil
  override def tail: HNil = self

  override type Append[I] = Appendable[I, HNil]
  override def append[I](i: I): Appendable[I, HNil] = new Appendable(i, self)

  override type Contribute = HNil
  override def contribute: HNil = self

  override type ReverseAppend[I] = HNil
  override def reverseAppend[I](i: I): HNil = self

  override def toString: String = "HNil"

}

object HNil {
  val hNil: HNil = new HNil
}
