package version2

import scala.language.higherKinds

object Runner extends App {

  val 水尺           = 初始水尺.下一重.下一重.下一重.下一重
  val shui         = 大海之初.加水(1).加水("水2").加水(3).加水("水4").加水("水5").加水("水6").加水("水7")
  val a1           = 水尺.检验(shui)
  val (b1, guixu1) = a1.目前去水.去(shui, 归墟.value)
  val a2           = 水尺.检验(b1)
  val (b2, guixu2) = a2.目前去水.去(b1, guixu1)
  val a3           = 水尺.检验(b2)
  val (b3, guixu3) = a3.目前去水.去(b2, guixu2)
  val a4           = 水尺.检验(b3)
  val (b4, guixu4) = a4.目前去水.去(b3, guixu3)
  val a5           = 水尺.检验(b4)
  val (b5, guixu5) = a5.目前去水.去(b4, guixu4)
  val a6           = 水尺.检验(b5)
  val (b6, guixu6) = a6.目前去水.去(b5, guixu5)
  val a7           = 水尺.检验(b6)
  val (b7, guixu7) = a7.目前去水.去(b6, guixu6)

  println(s"大海: ${b1}, guixu: ${guixu1}")
  println(s"大海: ${b2}, guixu: ${guixu2}")
  println(s"大海: ${b3}, guixu: ${guixu3}")
  println(s"大海: ${b4}, guixu: ${guixu4}")
  println(s"大海: ${b5}, guixu: ${guixu5}")
  println(s"大海: ${b6}, guixu: ${guixu6}")
  println(s"大海: ${b7}, guixu: ${guixu7}")

}
