package version2

import scala.language.higherKinds

trait 去水 {

  type 去[II <: 大海] <: 大海
  def 去[II <: 大海](m: II, guixu: 归墟): (去[II], 归墟)

}

class 满溢 extends 去水 {
  self =>

  override type 去[II <: 大海] = II#尾
  override def 去[II <: 大海](m: II, guixu: 归墟): (II#尾, 归墟) = (m.tail, guixu.加水(m.head))

}

object 满溢 extends 满溢

class 没满溢 extends 去水 {
  self =>
  override type 去[II <: 大海] = II
  override def 去[II <: 大海](m: II, guixu: 归墟): (II, 归墟) = (m, guixu)
}

object 没满溢 extends 没满溢
