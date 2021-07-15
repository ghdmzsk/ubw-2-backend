import shapeless._

object Runner extends App {

  val i1 = 苹果("苹果名称1", 12)
  val i2 = 桃("桃名称2", 13)
  val i3 = 鸡("桃名称3", 14, Option.empty)
  val i4 = 鹅("桃名称4", 15)
  val i5 = 走地鸡("走地鸡名称5", 16)
  val i6 = 蛋糕("蛋糕名称6", 18)

  val i8 = 神坛(i1, i2, i3, i4, i5, i6)

  object PolyJson extends UnInit[禽类 :: 神坛包裹类 :: HNil]

  val str1 = PolyJson.toJSON(i8)
  println(str1.spaces2)
  println(PolyJson.decode[神坛](str1))

  val str2 = PolyJson.toJSON(i3)
  println(str2.spaces2)
  println(PolyJson.decode[鸡](str2))

}
