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

    type 整数_3_6 = 整数[HList3, HList6]
    val 整数_3_6: 整数_3_6 = new 整数(hlist3, hlist6)
    println(整数_3_6) // (负数部分: 零 :: Test1 :: Test2 :: Test3, 整数部分: 零 :: Test4 :: Test5 :: Test6 :: Test7 :: Test8 :: Test9)

    type 整数3 = 正数[零, Test1]
    val 整数3: 整数3 = 零.value.后继(new Test1)
    type 整数_4 = 整数3#消融[HList6, 正数赋值]
    val 整数_4: 整数_4 = 整数3.消融(hlist6, 正数赋值.value)
    println(整数_4)
  }

}
