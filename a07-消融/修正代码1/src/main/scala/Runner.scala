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

  def main(arr: Array[String]): Unit = {
    type HList3 = 零#后继[Test1]#后继[Test2]#后继[Test3]
    val hlist3: HList3 = 零.value.后继(new Test1).后继(new Test2).后继(new Test3)
    println(hlist3) // 零 :: Test1 :: Test2 :: Test3

    type HList6 = 零#后继[Test4]#后继[Test5]#后继[Test6]#后继[Test7]#后继[Test8]#后继[Test9]
    val hlist6: HList6 = 零.value.后继(new Test4).后继(new Test5).后继(new Test6).后继(new Test7).后继(new Test8).后继(new Test9)
    println(hlist6) // 零 :: Test4 :: Test5 :: Test6 :: Test7 :: Test8 :: Test9

    /*type 整数_3_6 = 整数[HList3, HList6]
    val 整数_3_6: 整数_3_6 = new 整数(hlist3, hlist6)
    println(整数_3_6) // (负数部分: 零 :: Test1 :: Test2 :: Test3, 整数部分: 零 :: Test4 :: Test5 :: Test6 :: Test7 :: Test8 :: Test9)*/

    type HList2 = 零#后继[Test1]#后继[Test2]
    val hlist2: HList2 = 零.value.后继(new Test1).后继(new Test2)

    type 整数_2_6 = HList2#消融[HList6]
    val 整数_2_6: 整数_2_6 = hlist2.消融(hlist6)
    println(整数_2_6) // (负数部分: 零, 正数部分: 零 :: Test4 :: Test5 :: Test6 :: Test7)

    type 整数_6_2 = HList6#消融[HList2]
    val 整数_6_2: 整数_6_2 = hlist6.消融(hlist2)
    println(整数_6_2) // (负数部分: 零 :: Test4 :: Test5 :: Test6, 正数部分: 零)

    type 整数_3_6 = HList3#消融[HList6]
    val 整数_3_6: 整数_3_6 = hlist3.消融(hlist6)
    println(整数_3_6) // (负数部分: 零, 正数部分: 零 :: Test4 :: Test5 :: Test6 :: Test7)

    type 整数_6_3 = HList6#消融[HList3]
    val 整数_6_3: 整数_6_3 = hlist6.消融(hlist3)
    println(整数_6_3) // (负数部分: 零 :: Test4 :: Test5 :: Test6, 正数部分: 零)
  }

}
