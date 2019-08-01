package version2

import scala.language.higherKinds

trait Convert {

  type M[II <: HList] <: HList
  def tran[II <: HList](m: II, guixu: 归墟): (M[II], 归墟)

}

class Manyi extends Convert {
  self =>

  override type M[II <: HList] = II#T
  override def tran[II <: HList](m: II, guixu: 归墟): (II#T, 归墟) = (m.tail, guixu.add(m.head))

}

object Manyi extends Manyi

class MeiManyi extends Convert {
  self =>
  override type M[II <: HList] = II
  override def tran[II <: HList](m: II, guixu: 归墟): (II, 归墟) = (m, guixu)
}

object MeiManyi extends MeiManyi
