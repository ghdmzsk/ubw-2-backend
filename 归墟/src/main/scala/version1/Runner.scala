package version1

object Runner extends App {

  val 水尺               = 初始水尺.下一重.下一重.下一重.下一重.下一重.下一重.下一重
  val dahai1           = 大海之初.加水(1).加水("水2").加水(3)
  val 舀水1              = 水尺.检验(dahai1).目前舀水
  val (dahai2, guixu2) = 舀水1.舀(dahai1, 归墟.value, "水4")
  val 舀水2              = 水尺.检验(dahai2).目前舀水
  val (dahai3, guixu3) = 舀水2.舀(dahai2, guixu2, "水5")
  val 舀水3              = 水尺.检验(dahai3).目前舀水
  val (dahai4, guixu4) = 舀水3.舀(dahai3, guixu3, 6)
  val 舀水4              = 水尺.检验(dahai4).目前舀水
  val (dahai5, guixu5) = 舀水4.舀(dahai4, guixu4, "水7")
  val 舀水5              = 水尺.检验(dahai5).目前舀水
  val (dahai6, guixu6) = 舀水5.舀(dahai5, guixu5, "水8")
  val 舀水6              = 水尺.检验(dahai6).目前舀水
  val (dahai7, guixu7) = 舀水6.舀(dahai6, guixu6, 9)
  val 舀水7              = 水尺.检验(dahai7).目前舀水
  val (dahai8, guixu8) = 舀水7.舀(dahai7, guixu7, "水10")

  println(s"大海: ${dahai1}, 归墟: ${归墟.value}")
  println(s"大海: ${dahai2}, 归墟: ${guixu2}")
  println(s"大海: ${dahai3}, 归墟: ${guixu3}")
  println(s"大海: ${dahai4}, 归墟: ${guixu4}")
  println(s"大海: ${dahai5}, 归墟: ${guixu5}")
  println(s"大海: ${dahai6}, 归墟: ${guixu6}")
  println(s"大海: ${dahai7}, 归墟: ${guixu7}")
  println(s"大海: ${dahai8}, 归墟: ${guixu8}")

}
