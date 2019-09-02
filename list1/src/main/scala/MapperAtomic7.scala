package org.scalax.asuna.mapper.miaomiao2;
import version1.{Fetch, Undefined}

import scala.language.higherKinds;

trait Natural {
  self =>

  type Head
  type Tail <: Natural
  def tail: Tail
  def biggest: Head

  type ::[R] <: Natural
  type M[R] <: PutAble
  type :::[R <: Natural] <: Natural

  def ::[R](xyy: R): ::[R]
  def put[R](xyy: R): M[R]
  def :::[R <: Natural](xyy: R): :::[R]

  type apply[F <: Fetch]
  def apply[F <: Fetch](f: F): apply[F]

}

trait PutAble {

  type H <: Natural
  type T

  def head: H
  def current: T

}

case class PutAbleImpl[Head <: Natural, Tail](override val head: Head, override val current: Tail) extends PutAble {
  override type H = Head
  override type T = Tail
}

class HNil extends Natural {
  self =>

  override type Head = Undefined
  override type Tail = HNil
  override def tail: HNil         = HNil.hNil
  override def biggest: Undefined = Undefined.undefined

  override type ::[R]             = AppendAble[HNil, R]
  override type M[R]              = PutAbleImpl[HNil, R]
  override type :::[R <: Natural] = R

  override def ::[R](xyy: R): AppendAble[HNil, R]   = new AppendAble(xyy, self)
  override def put[R](xyy: R): PutAbleImpl[HNil, R] = PutAbleImpl[HNil, R](self, xyy)
  override def :::[R <: Natural](xyy: R): R         = xyy

  override type apply[F <: Fetch] = Undefined
  override def apply[F <: Fetch](f: F): Undefined = Undefined.undefined

  override def toString: String = "HNil"

}

object HNil {
  val hNil: HNil = new HNil
}

class AppendAble[T1 <: Natural, T2](override val biggest: T2, override val tail: T1) extends Natural {
  self =>

  override type Head = T2
  override type Tail = T1

  override type ::[R] = AppendAble[AppendAble[T1, T2], R]
  override type M[R] = ({
    type MM = T1#M[R]
    type NN = MM#H# `::`[MM#T]
    type PP = PutAbleImpl[NN, T2]
  })#PP
  override type :::[R <: Natural] = ({
    type MM = R#M[T2]
    type NN = T1# `:::`[MM#H]# `::`[MM#T]
  })#NN

  override type apply[F <: Fetch] = F#fetch[AppendAble[T1, T2]]#Head
  override def apply[F <: Fetch](f: F): F#fetch[AppendAble[T1, T2]]#Head = f.fetch(self).biggest

  override def ::[R](xyy: R): AppendAble[AppendAble[T1, T2], R] = new AppendAble(xyy, self)
  override def put[R](xyy: R): ({
    type MM = T1#M[R]
    type NN = MM#H# `::`[MM#T]
    type PP = PutAbleImpl[NN, T2]
  })#PP = {
    type MM = T1#M[R]
    type NN = MM#H# `::`[MM#T]

    val mm: MM = tail.put(xyy)
    val nn: NN = mm.head.::(mm.current: MM#T)
    PutAbleImpl(nn, biggest)
  }
  override def :::[R <: Natural](xyy: R): ({
    type MM = R#M[T2]
    type NN = T1# `:::`[MM#H]# `::`[MM#T]
  })#NN = {
    type MM = R#M[T2]

    val mm: MM = xyy.put(biggest)
    tail.:::(mm.head: MM#H).::(mm.current: MM#T)
  }

  override def toString: String = s"${biggest}, ${tail}"

}

object Miaomiao extends App {

  val i1: Int    = 1
  val i2: String = "miaomiaomiao"
  val i3: Long   = 3L
  val i4: Double = 4

  /*val mi = (i4 :: HNil.hNil) ::: (i3 :: i2 :: HNil.hNil) ::: (HNil.hNil ::: HNil.hNil) ::: (i1 :: HNil.hNil)

  val bar = (("汪" :: "喵" :: HNil.hNil) ::: mi ::: mi ::: mi) ::: mi ::: mi
  println(bar)*/

}
