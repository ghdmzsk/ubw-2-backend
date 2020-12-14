package version3

object Runner extends App {

  val 舀水水尺 = 初始水尺.下一重.下一重.下一重.下一重
  val 去水水尺 = 初始水尺.下一重.下一重
  val 池塘0  = 池塘之初.加水(1).加水("水2")
  println(s"池塘: ${池塘0}\n")

  val 舀水1                                     = 舀水水尺.检验(池塘0)
  val 池塘1: 池塘之初#加水[Int]#加水[String]#加水[String] = 舀水1.目前舀水.舀(池塘0, "水3": String)
  println(s"池塘: ${池塘1}\n")

  val 舀水2                                             = 舀水水尺.检验(池塘1)
  val 池塘2: 池塘之初#加水[Int]#加水[String]#加水[String]#加水[Int] = 舀水2.目前舀水.舀(池塘1, 3)
  println(s"池塘: ${池塘2}\n")

  val 舀水3                                                      = 舀水水尺.检验(池塘2)
  val 池塘3: 池塘之初#加水[Int]#加水[String]#加水[String]#加水[Int]#加水[Long] = 舀水3.目前舀水.舀(池塘2, 4L)
  println(s"池塘: ${池塘3}\n")

  val 舀水4                                                       = 舀水水尺.检验(池塘3)
  val 池塘4: 池塘之初#加水[Int]#加水[String]#加水[String]#加水[Int]#加水[Short] = 舀水4.目前舀水.舀(池塘3, 5: Short)
  println(s"池塘: ${池塘4}\n")

  val 去水5                                             = 去水水尺.检验(池塘4)
  val 池塘5: 池塘之初#加水[Int]#加水[String]#加水[String]#加水[Int] = 去水5.目前去水.去(池塘4)
  println(s"池塘: ${池塘5}\n")

  val 去水6                                     = 去水水尺.检验(池塘5)
  val 池塘6: 池塘之初#加水[Int]#加水[String]#加水[String] = 去水6.目前去水.去(池塘5)
  println(s"池塘: ${池塘6}\n")

  val 去水7                          = 去水水尺.检验(池塘6)
  val 池塘7: 池塘之初#加水[Int]#加水[String] = 去水7.目前去水.去(池塘6)
  println(s"池塘: ${池塘7}\n")

  val 去水8                          = 去水水尺.检验(池塘7)
  val 池塘8: 池塘之初#加水[Int]#加水[String] = 去水8.目前去水.去(池塘7)
  println(s"池塘: ${池塘8}\n")

}
