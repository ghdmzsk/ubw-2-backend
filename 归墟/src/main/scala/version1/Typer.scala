package version1

object Typer {

  type 水尺 = 初始水尺#下一重#下一重#下一重#下一重
  type 大海 = 大海之初#加水[Int]#加水[String]

  type 舀水1 = 水尺#检验[大海]
  type 大海1 = 舀水1#目前舀水#舀[大海, String]
  val 大海1: 大海之初#加水[Int]#加水[String]#加水[String] = (throw new Exception("ii")): 大海1

  type 舀水2 = 水尺#检验[大海1]
  type 大海2 = 舀水2#目前舀水#舀[大海1, Int]
  val 大海2: 大海之初#加水[Int]#加水[String]#加水[String]#加水[Int] = (throw new Exception("ii")): 大海2

  type 舀水3 = 水尺#检验[大海2]
  type 大海3 = 舀水3#目前舀水#舀[大海2, Long]
  val 大海3: 大海之初#加水[Int]#加水[String]#加水[String]#加水[Int]#加水[Long] = (throw new Exception("ii")): 大海3

  type 舀水4 = 水尺#检验[大海3]
  type 大海4 = 舀水4#目前舀水#舀[大海3, Short]
  val 大海4: 大海之初#加水[Int]#加水[String]#加水[String]#加水[Int]#加水[Long] = (throw new Exception("ii")): 大海4

  type 舀水5 = 水尺#检验[大海4]
  type 大海5 = 舀水5#目前舀水#舀[大海4, String]
  val 大海5: 大海之初#加水[Int]#加水[String]#加水[String]#加水[Int]#加水[Long] = (throw new Exception("ii")): 大海5

}
