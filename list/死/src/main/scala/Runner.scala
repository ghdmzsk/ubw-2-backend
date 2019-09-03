package version2

object Runner extends App {

  val hlist2 = "7" :: "8" :: 9 :: "10" :: "11" :: 12 :: HNil.hNil
  val hlist1 = "1" :: 2 :: 3 :: 4 :: 5 :: 6 :: HNil.hNil

  val bighlist = hlist1 ::: hlist2
  println(bighlist.toString)

  val i1: Int = bighlist(F._6)
  println(s"第 6 个元素是: ${i1}") //第 76 个元素是: 76

  val i2: String = bighlist(F._1._1)
  println(s"第 11 个元素是: ${i2}") //第 118 个元素是: 118

}
