package 练习21

object Runner {

  class Item1 {
    override def toString: String = "Item1"
  }
  class Item2 {
    override def toString: String = "Item2"
  }
  class Item3 {
    override def toString: String = "Item3"
  }
  class Item4 {
    override def toString: String = "Item4"
  }
  class Item5 {
    override def toString: String = "Item5"
  }

  def 乘数T1FromInt(cx: Int): 乘数T1 = cx match {
    case i: Int if i > 1 => new 乘数T1Positive(乘数T1FromInt(i - 1))
    case 1               => new 乘数T1One
  }

  def 乘数T2FromInt(cx: Int): 乘数T2 = {
    def c2(p2: () => 乘数T2, index: Int): 乘数T2 = index match {
      case i: Int if i > 1 => new 乘数T2Positive(c2(p2, i - 1))
      case 1               => new 乘数T2One(p2)
    }
    lazy val cxx: 乘数T2 = c2(() => cxx, cx)
    cxx
  }

  def 乘数T3FromList(cx: List[Any]): 乘数T3 = {
    def c2(p2: () => 乘数T3, cb: List[Any]): 乘数T3 = cb match {
      case head :: tail => new 乘数T3Positive(c2(p2, tail), head)
      case Nil          => new 乘数T3Zero(p2)
    }
    lazy val cxx: 乘数T3 = c2(() => cxx, cx.reverse)
    cxx
  }

  def main(arr: Array[String]): Unit = {
    {
      val 乘数1 = new 乘数T1Positive(new 乘数T1Positive(new 乘数T1Positive(new 乘数T1Positive(new 乘数T1Positive(new 乘数T1Positive(new 乘数T1One)))))) // 7
      lazy val 乘数2           = new 乘数T2Positive(new 乘数T2Positive(new 乘数T2Positive(new 乘数T2Positive(乘数One2))))                 // 5
      lazy val 乘数One2: 乘数T2  = new 乘数T2One(() => 乘数2)
      lazy val 乘数3           = new 乘数T3Positive(new 乘数T3Positive(new 乘数T3Positive(乘数3Zero, new Item1), new Item2), new Item3) // 3
      lazy val 乘数3Zero: 乘数T3 = new 乘数T3Zero(() => 乘数3)
      println(s"value: ${乘数3.乘3(乘数1, 乘数2).length}") // 105
      println(乘数3.乘3(乘数1, 乘数2))
    }

    {
      val 乘数1      = 乘数T1FromInt(57)
      lazy val 乘数2 = 乘数T2FromInt(25)
      lazy val 乘数3 = 乘数T3FromList(List(new Item1, new Item2, new Item3))
      println(s"value: ${乘数3.乘3(乘数1, 乘数2).length}") // 105
    }
  }

}
