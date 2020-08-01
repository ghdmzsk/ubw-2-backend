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
    type HList3 = Zero#add[Test1]#add[Test2]#add[Test3]
    val hlist3: HList3 = Zero.value.add(new Test1).add(new Test2).add(new Test3)
    println(hlist3) // Zero :: Test1 :: Test2 :: Test3

    type HList6 = Zero#add[Test4]#add[Test5]#add[Test6]#add[Test7]#add[Test8]#add[Test9]
    val hlist6: HList6 = Zero.value.add(new Test4).add(new Test5).add(new Test6).add(new Test7).add(new Test8).add(new Test9)
    println(hlist6) // Zero :: Test4 :: Test5 :: Test6 :: Test7 :: Test8 :: Test9

    type HList3_1 = HList3#push[Test5]
    val hlist3_1: HList3_1 = hlist3.push(new Test5)
    type HList3_2 = Zero#add[Test5]#add[Test2]#add[Test3]
    val hlist3_2: HList3_2 = hlist3_1
    println(hlist3_2) // Zero :: Test5 :: Test2 :: Test3

    type HList6_1 = HList6#push[Test2]
    val hlist6_1: HList6_1 = hlist6.push(new Test2)
    type HList6_2 = Zero#add[Test2]#add[Test5]#add[Test6]#add[Test7]#add[Test8]#add[Test9]
    val hlist6_2: HList6_2 = hlist6_1
    println(hlist6_2) // Zero :: Test2 :: Test5 :: Test6 :: Test7 :: Test8 :: Test9
  }

}
