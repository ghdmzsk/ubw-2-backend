package version3

import scala.language.higherKinds

trait 舀水 {
  type 舀[H <: 池塘, I] <: 池塘
  def 舀[H <: 池塘, I](池塘: H, 水: I): 舀[H, I]
}

class 没有满溢舀水 extends 舀水 {
  self =>
  override type 舀[H <: 池塘, I] = H#加水[I]
  override def 舀[H <: 池塘, I](池塘: H, 水: I): H#加水[I] = 池塘.加水(水)
}
object 没有满溢舀水 extends 没有满溢舀水

class 满溢舀水 extends 舀水 {
  self =>
  override type 舀[H <: 池塘, I] = H#尾#加水[I]
  override def 舀[H <: 池塘, I](池塘: H, 水: I): H#尾#加水[I] = {
    println(s"满水了, 水: " + 池塘.首 + " 被溢出去其他地方了")
    池塘.尾.加水(水)
  }
}
object 满溢舀水 extends 满溢舀水
