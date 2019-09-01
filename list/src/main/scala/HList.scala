package version1

import scala.language.higherKinds

trait HList {
  type Tail <: HList
  type Head

  def tail: Tail
  def head: Head

  type ::[T] <: HList
  def ::[T](t: T): ::[T]

  type append[T] <: HList
  def append[T](t: T): append[T]

  type :::[T <: HList] <: HList
  def :::[T <: HList](t: T): :::[T]

  type apply[F <: Fetch]
  def apply[F <: Fetch](f: F): apply[F]

}

case class Appendable[H, T <: HList](override val head: H, override val tail: T) extends HList {
  self =>
  override type Tail = T
  override type Head = H

  override type ::[T1] = Appendable[T1, Appendable[H, T]]
  override def ::[T1](t: T1): Appendable[T1, Appendable[H, T]] = new Appendable[T1, Appendable[H, T]](t, self)

  override type append[T1] = Appendable[H, T#append[T1]]
  override def append[T1](t: T1): Appendable[H, T#append[T1]] = new Appendable(head, tail.append(t))

  override type :::[T1 <: HList] = T# `:::`[T1#append[H]]
  override def :::[T1 <: HList](t: T1): T# `:::`[T1#append[H]] = tail.:::(t.append(head))

  override type apply[F <: Fetch] = F#fetch[Appendable[H, Tail]]#Head
  override def apply[F <: Fetch](f: F): F#fetch[Appendable[H, Tail]]#Head = f.fetch(self).head

  override def toString = head.toString + " :: " + tail.toString
}

case class Undefined()
object Undefined {
  val undefined: Undefined = Undefined()
}

class HNil extends HList {
  self =>
  override type Tail = HNil
  override type Head = Undefined
  override def tail: HNil      = self
  override def head: Undefined = Undefined.undefined

  override type ::[T] = Appendable[T, HNil]
  override def ::[T](t: T) = new Appendable(t, self)

  override type append[T1] = Appendable[T1, HNil]
  override def append[T1](t: T1): Appendable[T1, HNil] = new Appendable(t, self)

  override type :::[T <: HList] = T
  override def :::[T <: HList](t: T): T = t

  override type apply[F <: Fetch] = Undefined
  override def apply[F <: Fetch](f: F): Undefined = Undefined.undefined

  override def toString = "HNil"

}

case object HNil extends HNil
