package version2

import scala.language.higherKinds

object Runner extends App {

  val sc           = ShuichiZero.add.add.add.add
  val shui         = HNil.add(1).add("水2").add(3).add("水4").add("水5").add("水6").add("水7")
  val a1           = sc.shendu(shui)
  val (b1, guixu1) = a1.convert.tran(Guixu.value, shui)
  val a2           = sc.shendu(b1)
  val (b2, guixu2) = a2.convert.tran(guixu1, b1)
  val a3           = sc.shendu(b2)
  val (b3, guixu3) = a3.convert.tran(guixu2, b2)
  val a4           = sc.shendu(b3)
  val (b4, guixu4) = a4.convert.tran(guixu3, b3)
  val a5           = sc.shendu(b4)
  val (b5, guixu5) = a5.convert.tran(guixu4, b4)
  val a6           = sc.shendu(b5)
  val (b6, guixu6) = a6.convert.tran(guixu5, b5)
  val a7           = sc.shendu(b6)
  val (b7, guixu7) = a7.convert.tran(guixu6, b6)

  println(s"大海: ${b1}, guixu: ${guixu1}")
  println(s"大海: ${b2}, guixu: ${guixu2}")
  println(s"大海: ${b3}, guixu: ${guixu3}")
  println(s"大海: ${b4}, guixu: ${guixu4}")
  println(s"大海: ${b5}, guixu: ${guixu5}")
  println(s"大海: ${b6}, guixu: ${guixu6}")
  println(s"大海: ${b7}, guixu: ${guixu7}")

}
