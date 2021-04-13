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

  def main(arr: Array[String]): Unit = {
    val 乘数1                = new 乘数T1Positive(new 乘数T1Positive(new 乘数T1Positive(new 乘数T1Positive(new 乘数T1Positive(new 乘数T1Positive(new 乘数T1One)))))) // 7
    lazy val 乘数2           = new 乘数T2Positive(new 乘数T2Positive(new 乘数T2Positive(new 乘数T2Positive(乘数One2))))                                          // 5
    lazy val 乘数One2: 乘数T2  = new 乘数T2One(() => 乘数2)
    lazy val 乘数3           = new 乘数T3Positive(new 乘数T3Positive(new 乘数T3Positive(乘数3Zero, new Item1), new Item2), new Item3)                          // 3
    lazy val 乘数3Zero: 乘数T3 = new 乘数T3Zero(() => 乘数3)
    println(s"value: ${乘数3.乘3(乘数1, 乘数2).length}") // 105
    println(乘数3.乘3(乘数1, 乘数2))
  }

}
