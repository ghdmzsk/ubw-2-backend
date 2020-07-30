package a05

object Runner {

  class Test1 {
    override def toString: String = "Test1"
  }
  class Test2 {
    override def toString: String = "Test2"
  }
  class Test3 {
    override def toString: String = "Test3"
  }
  class Test4 {
    override def toString: String = "Test4"
  }
  class Test5 {
    override def toString: String = "Test5"
  }
  class Test6 {
    override def toString: String = "Test6"
  }
  class Test7 {
    override def toString: String = "Test7"
  }
  class Test8 {
    override def toString: String = "Test8"
  }
  class Test9 {
    override def toString: String = "Test9"
  }

  class Test10 {
    override def toString: String = "Test10"
  }
  class Test11 {
    override def toString: String = "Test11"
  }

  class Test12 {
    override def toString: String = "Test12"
  }
  class Test13 {
    override def toString: String = "Test13"
  }

  def main(arr: Array[String]): Unit = {
    type HList3 = 零#后继[Test1]#后继[Test2]#后继[Test3]
    val hlist3: HList3 = 别名.自然数零.后继(new Test1).后继(new Test2).后继(new Test3)
    println(hlist3) // 零 :: Test1 :: Test2 :: Test3

    type HList6 = 零#后继[Test4]#后继[Test5]#后继[Test6]#后继[Test7]#后继[Test8]#后继[Test9]
    val hlist6: HList6 = 别名.自然数零.后继(new Test4).后继(new Test5).后继(new Test6).后继(new Test7).后继(new Test8).后继(new Test9)
    println(hlist6) // 零 :: Test4 :: Test5 :: Test6 :: Test7 :: Test8 :: Test9

    type 整数_3_6 = 整数[HList3, HList6]
    val 整数_3_6: 整数_3_6 = new 整数(hlist3, hlist6)

    type 整数_6_3 = 整数[HList6, HList3]
    val 整数_6_3: 整数_6_3 = new 整数(hlist6, hlist3)

    type 整数_0 = 整数_3_6#加[整数_6_3]
    val 整数_0: 整数_0     = 整数_3_6.加(整数_6_3)
    val 整数_0_1: 别名.整数零 = 整数_0
    println(整数_0_1) // (负数部分: 零, 正数部分: 零)

    type 整数_0_2 = 整数_3_6#相反数#加[整数_3_6]
    val 整数_0_2: 整数_0_2 = 整数_3_6.相反数.加(整数_3_6)
    val 整数_0_3: 别名.整数零 = 整数_0_2
    println(整数_0_3) // (负数部分: 零, 正数部分: 零)

    type HList2 = 零#后继[Test2]#后继[Test3]
    val hlist2 = 别名.自然数零.后继(new Test2).后继(new Test3)
    type 整数_0_1_1 = 整数[HList6, HList3]#加[别名.自然数整数版[HList2]]
    val 整数_0_1_1: 整数_0_1_1 = 整数_6_3.加(别名.自然数整数版(hlist2))
    type 整数_0_1_2 = 整数[零#后继[Test4], 零]
    val 整数_0_1_2: 整数_0_1_2 = 整数_0_1_1
    println(整数_0_1_2) // (负数部分: 零 :: Test4, 正数部分: 零)

    type HList2_1 = 零#后继[Test10]#后继[Test11]
    val hlist2_1 = 别名.自然数零.后继(new Test10).后继(new Test11)

    type HList2_2 = 零#后继[Test12]#后继[Test13]
    val hlist2_2 = 别名.自然数零.后继(new Test12).后继(new Test13)

    type 整数_0_3_1 = 整数[HList6, HList3]#加[别名.自然数整数版[HList2_1]]#加[别名.自然数整数版[HList2_2#后继[Test2]]]
    val 整数_0_3_1: 整数_0_3_1 = 整数_6_3.加(别名.自然数整数版(hlist2_1)).加(别名.自然数整数版(hlist2_2.后继(new Test2)))
    type 整数_0_3_2 = 整数[零, 零#后继[Test12]#后继[Test13]]
    val 整数_0_3_2: 整数_0_3_2 = 整数_0_3_1
    println(整数_0_3_2) // (负数部分: 零 :: Test4, 正数部分: 零)
  }

}
