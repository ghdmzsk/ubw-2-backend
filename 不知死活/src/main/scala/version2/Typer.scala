package version2

import scala.language.higherKinds

object Typer {

  type 测试水尺 = 初始水尺#下一重#下一重#下一重#下一重
  type 池塘0  = 池塘之初#加水[Int]#加水[String]#加水[Int]#加水[String]#加水[String]#加水[String]

  type 去水1 = 测试水尺#检验[池塘0]
  type 池塘1 = 去水1#目前去水#去[池塘0]
  val 池塘1: 池塘之初#加水[Int]#加水[String]#加水[Int]#加水[String]#加水[String] = (throw new Exception("ii")): 池塘1

  type 去水2 = 测试水尺#检验[池塘1]
  type 池塘2 = 去水2#目前去水#去[池塘1]
  val 池塘2: 池塘之初#加水[Int]#加水[String]#加水[Int]#加水[String] = (throw new Exception("ii")): 池塘2

  type 去水3 = 测试水尺#检验[池塘2]
  type 池塘3 = 去水3#目前去水#去[池塘2]
  val 池塘3: 池塘之初#加水[Int]#加水[String]#加水[Int]#加水[String] = (throw new Exception("ii")): 池塘3

  type 去水4 = 测试水尺#检验[池塘3]
  type 池塘4 = 去水4#目前去水#去[池塘3]
  val 池塘4: 池塘之初#加水[Int]#加水[String]#加水[Int]#加水[String] = (throw new Exception("ii")): 池塘4

  type 去水5 = 测试水尺#检验[池塘4]
  type 池塘5 = 去水5#目前去水#去[池塘4]
  val 池塘5: 池塘之初#加水[Int]#加水[String]#加水[Int]#加水[String] = (throw new Exception("ii")): 池塘5

}
