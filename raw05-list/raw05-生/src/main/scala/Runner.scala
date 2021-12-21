package version1

object Runner extends App {

  val hlist2 = "11" :: "12" :: HNil.hNil
  val hlist1 = "1" :: 2 :: HNil.hNil

  val bighlist = hlist1 ::: hlist2

  println(bighlist.toString)

  val i1: String = bighlist(F._3)
  println(s"第 3 个元素是: ${i1}") // 第 3 个元素是: 11

  val i2: Int = bighlist(F._2)
  println(s"第 2 个元素是: ${i2}") // 第 2 个元素是: 2

}
