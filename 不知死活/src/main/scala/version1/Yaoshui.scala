package version1

import scala.language.higherKinds

trait 舀水 {
  type 舀[H <: 大海, I] <: 大海
  def 舀[H <: 大海, I](大海: H, 水: I): 舀[H, I]
}

class 没有满溢 extends 舀水 {
  self =>
  override type 舀[H <: 大海, I] = H#加水[I]
  override def 舀[H <: 大海, I](大海: H, 水: I): H#加水[I] = 大海.加水(水)
}
object 没有满溢 extends 没有满溢

class 满溢 extends 舀水 {
  self =>
  override type 舀[H <: 大海, I] = H
  override def 舀[H <: 大海, I](大海: H, 水: I): H = {
    println(s"满水了, 水: " + 水 + " 被舀去了其他地方")
    大海
  }
}
object 满溢 extends 满溢
