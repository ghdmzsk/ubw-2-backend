package version2

import scala.language.higherKinds

trait Convert {

  type M[II <: HList] <: HList
  def tran[II <: HList](guixu: Guixu, m: II): (M[II], Guixu)

}

class Manyi extends Convert {
  self =>

  override type M[II <: HList] = II#T
  override def tran[II <: HList](guixu: Guixu, m: II): (II#T, Guixu) = (m.tail, guixu.add(m.head))

}

object Manyi extends Manyi

class MeiManyi extends Convert {
  self =>
  override type M[II <: HList] = II
  override def tran[II <: HList](guixu: Guixu, m: II): (II, Guixu) = (m, guixu)
}

object MeiManyi extends MeiManyi
