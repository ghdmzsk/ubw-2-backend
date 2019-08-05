package version3

object Typer {

  type 舀水水尺 = 初始水尺#下一重#下一重#下一重#下一重
  type 去水水尺 = 初始水尺#下一重#下一重
  type 池塘0  = 池塘之初#加水[Int]#加水[String]

  type 舀水1 = 舀水水尺#检验[池塘0]
  type 池塘1 = 舀水1#目前舀水#舀[池塘0, String]
  val 池塘1: 池塘之初#加水[Int]#加水[String]#加水[String] = (throw new Exception("ii")): 池塘1

  type 舀水2 = 舀水水尺#检验[池塘1]
  type 池塘2 = 舀水2#目前舀水#舀[池塘1, Int]
  val 池塘2: 池塘之初#加水[Int]#加水[String]#加水[String]#加水[Int] = (throw new Exception("ii")): 池塘2

  type 舀水3 = 舀水水尺#检验[池塘2]
  type 池塘3 = 舀水3#目前舀水#舀[池塘2, Long]
  val 池塘3: 池塘之初#加水[Int]#加水[String]#加水[String]#加水[Int]#加水[Long] = (throw new Exception("ii")): 池塘3

  type 舀水4 = 舀水水尺#检验[池塘3]
  type 池塘4 = 舀水4#目前舀水#舀[池塘3, Short]
  val 池塘4: 池塘之初#加水[Int]#加水[String]#加水[String]#加水[Int]#加水[Short] = (throw new Exception("ii")): 池塘4

  type 去水5 = 去水水尺#检验[池塘4]
  type 池塘5 = 去水5#目前去水#去[池塘4]
  val 池塘5: 池塘之初#加水[Int]#加水[String]#加水[String]#加水[Int] = (throw new Exception("ii")): 池塘5

  type 去水6 = 去水水尺#检验[池塘5]
  type 池塘6 = 去水6#目前去水#去[池塘5]
  val 池塘6: 池塘之初#加水[Int]#加水[String]#加水[String] = (throw new Exception("ii")): 池塘6

  type 去水7 = 去水水尺#检验[池塘6]
  type 池塘7 = 去水7#目前去水#去[池塘6]
  val 池塘7: 池塘之初#加水[Int]#加水[String] = (throw new Exception("ii")): 池塘7

  type 去水8 = 去水水尺#检验[池塘7]
  type 池塘8 = 去水8#目前去水#去[池塘7]
  val 池塘8: 池塘之初#加水[Int]#加水[String] = (throw new Exception("ii")): 池塘8

}
