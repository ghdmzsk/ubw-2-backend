package version1

object Runner extends App {

  val hlist12 = 111 :: 112 :: 113 :: "114" :: "115" :: 116 :: 117 :: 118 :: 119 :: 120 :: HNil
  val hlist11 = 101 :: 102 :: "103" :: 104 :: 105 :: 106 :: 107 :: 108 :: 109 :: 110 :: hlist12
  val hlist10 = 91 :: 92 :: 93 :: 94 :: 95 :: 96 :: 97 :: 98 :: "99" :: 100 :: hlist11
  val hlist9  = 81 :: 82 :: "83" :: 84 :: 85 :: 86 :: 87 :: 88 :: 89 :: 90 :: hlist10
  val hlist8  = 71 :: 72 :: 73 :: 74 :: 75 :: "76" :: "77" :: 78 :: 79 :: 80 :: hlist9
  val hlist7  = 61 :: 62 :: 63 :: 64 :: 65 :: 66 :: 67 :: 68 :: 69 :: 70 :: hlist8
  val hlist6  = 51 :: 52 :: 53 :: 54 :: 55 :: "56" :: 57 :: 58 :: 59 :: 60 :: hlist7
  val hlist5  = 41 :: 42 :: "43" :: 44 :: 45 :: 46 :: 47 :: "48" :: 49 :: 50 :: hlist6
  val hlist4  = 31 :: 32 :: 33 :: 34 :: 35 :: 36 :: 37 :: 38 :: 39 :: 40 :: hlist5
  val hlist3  = 21 :: 22 :: 23 :: 24 :: 25 :: 26 :: 27 :: 28 :: 29 :: 30 :: hlist4
  val hlist2  = "11" :: "12" :: "13" :: "14" :: "15" :: 16 :: 17 :: "18" :: 19 :: 20 :: hlist3
  val hlist1  = "1" :: 2 :: 3 :: "4" :: "5" :: 6 :: 7 :: "8" :: 9 :: 10 :: hlist2

  println(hlist1.toString)

  val i1: String = hlist1(F._7._6)
  println(s"第 76 个元素是: ${i1}") //第 76 个元素是: 76

  val i2: Int = hlist1(F._1._1._8)
  println(s"第 118 个元素是: ${i2}") //第 118 个元素是: 118

}
