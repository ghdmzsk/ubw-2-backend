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

  def main(arr: Array[String]): Unit = {
    type HList3 = 零#后继[Test1]#后继[Test2]#后继[Test3]
    val hlist3: HList3 = 零.value.后继(new Test1).后继(new Test2).后继(new Test3)
    println(hlist3) // 零 :: Test1 :: Test2 :: Test3

    type HList4 = 零#后继[Test4]#后继[Test5]#后继[Test6]#后继[Test7]
    val hlist4: HList4 = 零.value.后继(new Test4).后继(new Test5).后继(new Test6).后继(new Test7)
    println(hlist4) // 零 :: Test4 :: Test5 :: Test6 :: Test7

    type HList7_1 = HList3#真的加[HList4]
    type HList7_2 = 零#后继[Test1]#后继[Test2]#后继[Test3]#后继[Test4]#后继[Test5]#后继[Test6]#后继[Test7]
    hlist3.真的加(hlist4): HList7_1
    hlist3.真的加(hlist4): HList7_2

    type 负5 = 零#成对后继[Test1]#成对后继[Test2]#成对后继[Test3]#成对后继[Test4]#成对后继[Test5]
    val 负5: 负5 = 零.value.成对后继(new Test1).成对后继(new Test2).成对后继(new Test3).成对后继(new Test4).成对后继(new Test5)

    type 结果 = 零#后继[Test6]#后继[Test7]
    val 结果: 结果 = 零.value.后继(new Test6).后继(new Test7)

    val hlist7_1: HList7_1 = hlist3.真的加(hlist4)
    val hlist7_2: HList7_2 = hlist7_1

    val 结果1: 结果 = 负5.真的加(hlist7_1)
    println(结果1) // 零 :: Test6 :: Test7

    val 结果2: 结果 = 负5.真的加(hlist7_2)

    type 结果1 = 负5#真的加[HList7_1]
    type 结果2 = 负5#真的加[HList7_2]
    val 结果1_1: 结果1 = 结果
    val 结果1_2: 结果2 = 结果

    type 结果3 = 零#成对后继[Test1]#成对后继[Test2]
    val 结果3: 结果3 = 负5.真的加(hlist3)
    println(结果3) // 零 反向 Test1 反向 Test2

  }

}
