package version2

import scala.language.higherKinds;

trait HList {
  self =>

  type Head
  type Tail <: HList

  def tail: Tail

  def head: Head

  type ::[R] <: HList
  type M[R] <: PutAble
  type :::[R <: HList] <: HList

  def ::[R](xyy: R): ::[R]

  def put[R](xyy: R): M[R]

  def :::[R <: HList](xyy: R): :::[R]

  type apply[F <: Fetch]

  def apply[F <: Fetch](f: F): apply[F]

}

trait PutAble {

  type Head
  type Tail <: HList

  def head: Head

  def tail: Tail

}

case class PutAbleImpl[H, T <: HList](override val head: H, override val tail: T) extends PutAble {
  override type Head = H
  override type Tail = T
}

class HNil extends HList {
  self =>

  override type Head = Undefined
  override type Tail = HNil

  override def tail: HNil = HNil.hNil

  override def head: Undefined = Undefined.undefined

  override type ::[R]           = AppendAble[R, HNil]
  override type M[R]            = PutAbleImpl[R, HNil]
  override type :::[R <: HList] = R

  override def ::[R](xyy: R): AppendAble[R, HNil] = new AppendAble(xyy, self)

  override def put[R](xyy: R): PutAbleImpl[R, HNil] = PutAbleImpl[R, HNil](xyy, self)

  override def :::[R <: HList](xyy: R): R = xyy

  override type apply[F <: Fetch] = Undefined

  override def apply[F <: Fetch](f: F): Undefined = Undefined.undefined

  override def toString: String = "HNil"

}

object HNil {
  val hNil: HNil = new HNil
}

case class Undefined()

object Undefined {
  val undefined: Undefined = Undefined()
}

class AppendAble[T1, T2 <: HList](override val head: T1, override val tail: T2) extends HList {
  self =>

  override type Head = T1
  override type Tail = T2

  override type ::[R] = AppendAble[R, AppendAble[T1, T2]]
  override type M[R] = ({
    type MM = T2#M[R]
    type NN = AppendAble[MM#Head, MM#Tail]
    type PP = PutAbleImpl[T1, NN]
  })#PP
  override type :::[R <: HList] = ({
    type MM = R#M[T1]
    type NN = AppendAble[MM#Head, T2# `:::`[MM#Tail]]
  })#NN

  override type apply[F <: Fetch] = F#fetch[AppendAble[T1, T2]]#Head

  override def apply[F <: Fetch](f: F): F#fetch[AppendAble[T1, T2]]#Head = f.fetch(self).head

  override def ::[R](xyy: R): AppendAble[R, AppendAble[T1, T2]] = new AppendAble(xyy, self)

  override def put[R](xyy: R): ({
    type MM = T2#M[R]
    type NN = AppendAble[MM#Head, MM#Tail]
    type PP = PutAbleImpl[T1, NN]
  })#PP = {
    type MM = T2#M[R]
    type NN = AppendAble[MM#Head, MM#Tail]

    val mm: MM = tail.put(xyy)
    val nn: NN = new AppendAble(mm.head, mm.tail)
    PutAbleImpl(head, nn)
  }

  override def :::[R <: HList](xyy: R): ({
    type MM = R#M[T1]
    type NN = AppendAble[MM#Head, T2# `:::`[MM#Tail]]
  })#NN = {
    type MM = R#M[T1]

    val mm: MM = xyy.put(head)
    //tail.:::(mm.head: MM#H).::(mm.tail: MM#T)
    new AppendAble(mm.head: MM#Head, tail.:::(mm.tail: MM#Tail))
  }

  override def toString: String = s"${head}, ${tail}"

}

object Miaomiao {

  val i1: Int    = 1
  val i2: String = "miaomiaomiao"
  val i3: Long   = 3L
  val i4: Double = 4

  /*val mi = (i4 :: HNil.hNil) ::: (i3 :: i2 :: HNil.hNil) ::: (HNil.hNil ::: HNil.hNil) ::: (i1 :: HNil.hNil)

  val bar = (("汪" :: "喵" :: HNil.hNil) ::: mi ::: mi ::: mi) ::: mi ::: mi
  println(bar)*/

}
