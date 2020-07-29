package a06

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

  def main(arr: Array[String]): Unit = {
    type HList7 = 零#后继[Test1]#后继[Test2]#后继[Test3]#后继[Test4]#后继[Test5]#后继[Test6]#后继[Test7]
    val hlist7: HList7 = 零.value.后继(new Test1).后继(new Test2).后继(new Test3).后继(new Test4).后继(new Test5).后继(new Test6).后继(new Test7)
    println(hlist7) // 零 :: Test1 :: Test2 :: Test3 :: Test4 :: Test5 :: Test6 :: Test7

    type 负5 = 零#负一#负一#负一#负一#负一
    val 负5: 负5 = 零.value.负一.负一.负一.负一.负一
    println(负5) // 零 反向 item 反向 item 反向 item 反向 item 反向 item

    type HList2_1 = 负5#真的加[HList7]
    type HList2_2 = 零#后继[Test6]#后继[Test7]
    val hlist2_1: HList2_1 = 负5.真的加(hlist7)
    val hlist2_2: HList2_2 = hlist2_1
    println(hlist2_2) // 零 :: Test6 :: Test7

    type 负9 = 负5#负一#负一#负一#负一
    val 负9: 负9 = 负5.负一.负一.负一.负一
    println(负9) // 零 反向 item 反向 item 反向 item 反向 item 反向 item 反向 item 反向 item 反向 item 反向 item

    type HList3_1 = 负9#真的加[HList7]
    type HList3_2 = 零#负一#负一
    val hlist3_1: HList3_1 = 负9.真的加(hlist7)
    val hlist3_2: HList3_2 = hlist3_1
    println(hlist3_2) // 零 反向 item 反向 item

    type HList7_1 = 零#真的加[HList7]
    val hlist7_1: HList7_1 = hlist7
    println(hlist7_1) // 零 :: Test1 :: Test2 :: Test3 :: Test4 :: Test5 :: Test6 :: Test7
  }

}
