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

    type HList7 = Appendable[
      Appendable[Appendable[Appendable[Appendable[Appendable[Appendable[Zero, Test1], Test2], Test3], Test4], Test5], Test6],
      Test7
    ]
    val hlist7: HList7 = Appendable(
      Appendable(
        Appendable(Appendable(Appendable(Appendable(Appendable(Zero.value, new Test1), new Test2), new Test3), new Test4), new Test5),
        new Test6
      ),
      new Test7
    )
    println(hlist7) // Zero :: Test1 :: Test2 :: Test3 :: Test4 :: Test5 :: Test6 :: Test7

    hlist7.chouqu: HList7#Chouqu
    hlist7.chouqu: Appendable[Appendable[Appendable[Appendable[Appendable[Appendable[Zero, Test2], Test3], Test4], Test5], Test6], Test7]
    println(hlist7.chouqu) // Zero :: Test2 :: Test3 :: Test4 :: Test5 :: Test6 :: Test7

    hlist7.chouqu.chouqu.chouqu: HList7#Chouqu#Chouqu#Chouqu
    hlist7.chouqu.chouqu.chouqu: Appendable[Appendable[Appendable[Appendable[Zero, Test4], Test5], Test6], Test7]
    println(hlist7.chouqu.chouqu.chouqu) // Zero :: Test4 :: Test5 :: Test6 :: Test7
  }

}
