package version1

import scala.language.higherKinds

object Runner extends App {

  val 东海之水 = List(
    海水(true, 温度 = 41),
    海水(true, 温度 = 41),
    海水(false, 温度 = 41),
    海水(false, 温度 = 41),
    海水(false, 温度 = 41),
    海水(false, 温度 = 41),
    海水(false, 温度 = 41)
  )
  val 张羽的锅里水 = List(锅里水(温度 = 41), 锅里水(温度 = 41), 锅里水(温度 = 41), 锅里水(温度 = 41))

  val 焚山煮海 = new 煮海(东海之水)().煮
  val 张羽煮海 = new 煮锅(张羽的锅里水)().煮

  println(焚山煮海.容物.mkString("\n"))
  println("====================================================")
  println(张羽煮海.容物.mkString("\n"))

}
