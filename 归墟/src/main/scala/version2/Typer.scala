package version2

import scala.language.higherKinds

object Typer {

  type sc   = 初始水尺#下一重#下一重#下一重#下一重
  type shui = 大海之初#加水[Int]#加水[String]#加水[Int]#加水[String]#加水[String]#加水[String]

  type a1 = sc#检验[shui]
  type b1 = a1#目前去水#去[shui]
  val 溢水1: 大海之初#加水[Int]#加水[String]#加水[Int]#加水[String]#加水[String] = (throw new Exception("ii")): b1

  type a2 = sc#检验[b1]
  type b2 = a2#目前去水#去[b1]
  val 溢水2: 大海之初#加水[Int]#加水[String]#加水[Int]#加水[String] = (throw new Exception("ii")): b2

  type a3 = sc#检验[b2]
  type b3 = a3#目前去水#去[b2]
  val 溢水3: 大海之初#加水[Int]#加水[String]#加水[Int]#加水[String] = (throw new Exception("ii")): b3

  type a4 = sc#检验[b3]
  type b4 = a4#目前去水#去[b3]
  val 溢水4: 大海之初#加水[Int]#加水[String]#加水[Int]#加水[String] = (throw new Exception("ii")): b4

  type a5 = sc#检验[b4]
  type b5 = a5#目前去水#去[b4]
  val 溢水5: 大海之初#加水[Int]#加水[String]#加水[Int]#加水[String] = (throw new Exception("ii")): b5

}
