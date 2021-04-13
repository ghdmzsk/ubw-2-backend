package 练习20

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
    val 乘数值1: 乘数T1 = new 乘数T1Positive(
      new 乘数T1Positive(
        new 乘数T1Positive(
          new 乘数T1Positive(
            new 乘数T1Positive(
              new 乘数T1Positive(
                new 乘数T1Positive(
                  new 乘数T1Positive(
                    new 乘数T1Positive(new 乘数T1Positive(new 乘数T1Positive(new 乘数T1Positive(new 乘数T1Positive(new 乘数T1Positive(new 乘数T1Positive(new 乘数T1One)))))))
                  )
                )
              )
            )
          )
        )
      )
    )
    lazy val 乘数值2: 乘数T2 = new 乘数T2Positive(
      new 乘数T2Positive(
        new 乘数T2Positive(
          new 乘数T2Positive(
            new 乘数T2Positive(
              new 乘数T2Positive(
                new 乘数T2Positive(new 乘数T2Positive(new 乘数T2Positive(new 乘数T2Positive(new 乘数T2Positive(new 乘数T2Positive(new 乘数T2Positive(new 乘数T2Positive(乘数One2))))))))
              )
            )
          )
        )
      )
    )
    lazy val 乘数One2: 乘数T2 = new 乘数T2One(() => 乘数值2)
    lazy val 乘数值3: 乘数T3   = new 乘数T3Positive(new 乘数T3Positive(new 乘数T3Positive(new 乘数T3Positive(乘数One3, new Item1), new Item2), new Item3), new Item4)
    lazy val 乘数One3: 乘数T3 = new 乘数T3Zero(() => 乘数值3)

    println(s"value1: ${乘数值3.length}")
    println(s"value2: ${乘数值2.length}")
    println(s"value3: ${乘数值1.length}")
    println(s"result: ${乘数值3.乘3(乘数值1, 乘数值2).length}")

  }

}
