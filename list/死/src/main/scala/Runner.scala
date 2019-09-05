package version2

object Runner extends App {

  val hlist1 = "1" :: 2 :: 3 :: 4 :: 5 :: 6 :: "7" :: "8" :: 9 :: "10" :: HNil.hNil
  val hlist2 = "11" :: 12 :: "13" :: 14 :: "15" :: 16 :: "17" :: 18 :: "19" :: 20 :: HNil.hNil
  val hlist3 = 21 :: 22 :: 23 :: 24 :: 25 :: 26 :: 27 :: 28 :: 29 :: 30 :: HNil.hNil
  val hlist4 = 31 :: 32 :: 33 :: 34 :: 35 :: 36 :: 37 :: 38 :: 39 :: 40 :: HNil.hNil
  val hlist5 = 41 :: "42" :: 43 :: 44 :: 45 :: 46 :: 47 :: 48 :: 49 :: 50 :: HNil.hNil
  val hlist6 = 51 :: 52 :: 53 :: 54 :: 55 :: "56" :: 57 :: "58" :: 59 :: 60 :: HNil.hNil
  val hlist7 = 61 :: 62 :: 63 :: 64 :: 65 :: 66 :: 67 :: 68 :: 69 :: 70 :: HNil.hNil

  val bighlist = hlist1 ::: hlist2 ::: hlist3 ::: hlist4 ::: hlist5
  //val bighlist2 = bighlist ::: hlist6 ::: hlist7
  println(bighlist.toString)

  val i1: Int = bighlist(F._6)
  println(s"第 6 个元素是: ${i1}") //第 76 个元素是: 76

  val i2: String = bighlist(F._4._2)
  println(s"第 42 个元素是: ${i2}") //第 42 个元素是: 42

}
