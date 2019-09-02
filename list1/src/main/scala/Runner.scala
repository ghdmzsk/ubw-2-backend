package version1

import org.scalax.asuna.mapper.miaomiao2.HNil

object Runner extends App {

  val hlist6 = 101 :: 102 :: "103" :: 104 :: 105 :: 106 :: 107 :: 108 :: 109 :: 110 :: 111 :: 112 :: 113 :: "114" :: "115" :: 116 :: 117 :: 118 :: 119 :: 120 :: HNil.hNil
  val hlist5  = 81 :: 82 :: "83" :: 84 :: 85 :: 86 :: 87 :: 88 :: 89 :: 90 :: 91 :: 92 :: 93 :: 94 :: 95 :: 96 :: 97 :: 98 :: "99" :: 100 :: HNil.hNil
  val hlist4  = 61 :: 62 :: 63 :: 64 :: 65 :: 66 :: 67 :: 68 :: 69 :: 70 :: 71 :: 72 :: 73 :: 74 :: 75 :: "76" :: "77" :: 78 :: 79 :: 80 :: HNil.hNil
  val hlist3  = 41 :: 42 :: "43" :: 44 :: 45 :: 46 :: 47 :: "48" :: 49 :: 50 :: 51 :: 52 :: 53 :: 54 :: 55 :: "56" :: 57 :: 58 :: 59 :: 60 :: HNil.hNil
  val hlist2  = 21 :: 22 :: 23 :: 24 :: 25 :: 26 :: 27 :: 28 :: 29 :: 30 :: 31 :: 32 :: 33 :: 34 :: 35 :: 36 :: 37 :: 38 :: 39 :: 40 :: HNil.hNil
  val hlist1  = "1" :: 2 :: 3 :: "4" :: "5" :: 6 :: 7 :: "8" :: 9 :: 10 :: "11" :: "12" :: "13" :: "14" :: "15" :: 16 :: 17 :: "18" :: 19 :: 20 :: HNil.hNil

  println(hlist1.toString)

  val bighlist1  = hlist1 ::: hlist2
  val bighlist2  = bighlist1 ::: hlist3
  /*val bighlist3  = bighlist2 ::: hlist4
  val bighlist4  = bighlist3 ::: hlist5
  val bighlist  = bighlist4 ::: hlist6*/
  println(bighlist2.toString)

  val i1: String = bighlist2(F._7._6)
  println(s"第 76 个元素是: ${i1}") //第 76 个元素是: 76

  val i2: Int = bighlist2(F._1._1._8)
  println(s"第 118 个元素是: ${i2}") //第 118 个元素是: 118

}
