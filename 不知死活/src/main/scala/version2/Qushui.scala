package version2

import scala.language.higherKinds

trait 去水 {
  type 去[II <: 池塘] <: 池塘
  def 去[II <: 池塘](m: II): 去[II]
}

class 满溢 extends 去水 {
  self =>
  override type 去[II <: 池塘] = II#尾
  override def 去[II <: 池塘](m: II): II#尾 = {
    println(s"水: " + m.首 + " 溢出去其他地方了")
    m.尾
  }
}

object 满溢 extends 满溢

class 没有满溢 extends 去水 {
  self =>
  override type 去[II <: 池塘] = II
  override def 去[II <: 池塘](m: II): II = m
}

object 没有满溢 extends 没有满溢
