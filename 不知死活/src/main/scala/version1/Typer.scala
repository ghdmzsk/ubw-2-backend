package version1

object Typer {

  type 测试水尺 = 初始水尺#下一重#下一重#下一重#下一重
  type 池塘0  = 池塘之初#加水[Int]#加水[String]

  type 舀水1 = 测试水尺#检验[池塘0]
  type 池塘1 = 舀水1#目前舀水#舀[池塘0, String]
  val 池塘1: 池塘之初#加水[Int]#加水[String]#加水[String] = (throw new Exception("ii")): 池塘1

  type 舀水2 = 测试水尺#检验[池塘1]
  type 池塘2 = 舀水2#目前舀水#舀[池塘1, Int]
  val 池塘2: 池塘之初#加水[Int]#加水[String]#加水[String]#加水[Int] = (throw new Exception("ii")): 池塘2

  type 舀水3 = 测试水尺#检验[池塘2]
  type 池塘3 = 舀水3#目前舀水#舀[池塘2, Long]
  val 池塘3: 池塘之初#加水[Int]#加水[String]#加水[String]#加水[Int]#加水[Long] = (throw new Exception("ii")): 池塘3

  type 舀水4 = 测试水尺#检验[池塘3]
  type 池塘4 = 舀水4#目前舀水#舀[池塘3, Short]
  val 池塘4: 池塘之初#加水[Int]#加水[String]#加水[String]#加水[Int]#加水[Short] = (throw new Exception("ii")): 池塘4

  type 舀水5 = 测试水尺#检验[池塘4]
  type 池塘5 = 舀水5#目前舀水#舀[池塘4, String]
  val 池塘5: 池塘之初#加水[Int]#加水[String]#加水[String]#加水[Int]#加水[String] = (throw new Exception("ii")): 池塘5

}
