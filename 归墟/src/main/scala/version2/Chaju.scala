package version2

import scala.language.higherKinds

trait HList {
  type H
  type T <: HList

  val head: H
  val tail: T

  type Con <: Convert
  def convert: Con

  type Add[I] <: HList
  def add[I](i: I): Add[I]
}

class HNil extends HList {
  self =>
  override type H = HNil
  override type T = HNil
  override val head: HNil = self
  override val tail: HNil = self

  override type Con = MeiManyi
  override def convert: MeiManyi = MeiManyi

  override type Add[I] = Appendable[I, HNil]
  override def add[I](i: I): Appendable[I, HNil] = new Appendable(i, self)

  override def toString = "HNil"
}

object HNil extends HNil

class Appendable[HH, TT <: HList](override val head: HH, override val tail: TT) extends HList {
  self =>
  override type H = HH
  override type T = TT

  override type Con = Manyi
  override def convert: Manyi = Manyi

  override type Add[I] = Appendable[I, Appendable[HH, TT]]
  override def add[I](i: I): Appendable[I, Appendable[HH, TT]] = new Appendable(i, self)

  override def toString: String = head.toString + ", " + tail.toString
}
