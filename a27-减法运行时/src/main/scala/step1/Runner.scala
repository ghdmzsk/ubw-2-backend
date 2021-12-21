package step1

object Runner {

  class 类型匹配[T]
  object 类型匹配 {
    def apply[T1, T2]: (类型匹配[T1], 类型匹配[T2])            = (new 类型匹配[T1], new 类型匹配[T2])
    def apply[T](i: (类型匹配[T], 类型匹配[T])): List[类型匹配[T]] = List(i._1, i._2)
    def i[T](i1: T, i2: T): List[T]                    = List(i1, i2)
  }

  class Item1 {
    override val toString: String = "Item1"
  }
  class Item2 {
    override val toString: String = "Item2"
  }
  class Item3 {
    override val toString: String = "Item3"
  }
  class Item4 {
    override val toString: String = "Item4"
  }
  class Item5 {
    override val toString: String = "Item5"
  }
  class Item6 {
    override val toString: String = "Item6"
  }
  class Item7 {
    override val toString: String = "Item7"
  }

  type 被减数1 = 被减数Positive[被减数Positive[被减数Zero, Item1], Item2]
  type 减数1  = 减数Positive[减数Positive[减数Positive[减数Positive[减数Positive[减数Zero, Item3], Item4], Item5], Item6], Item7]
  type 差1   = 减数Positive[减数Positive[减数Positive[减数Zero, Item3], Item4], Item5]

  type 被减数2 = 被减数Positive[被减数Positive[被减数Positive[被减数Positive[被减数Zero, Item1], Item2], Item3], Item4]
  type 减数2  = 减数Positive[减数Positive[减数Positive[减数Zero, Item5], Item6], Item7]
  type 差2   = 被减数Positive[被减数Zero, Item1]

  type 被减数3 = 被减数Positive[被减数Positive[被减数Positive[被减数Positive[被减数Zero, Item1], Item2], Item3], Item4]
  type 减数3  = 减数Positive[减数Positive[减数Positive[减数Positive[减数Zero, Item4], Item5], Item6], Item7]
  type 差3   = 被减数Zero

  def main(arr: Array[String]): Unit = {

    val 被减数1: 被减数1 = new 被减数Positive(new 被减数Positive(new 被减数Zero, new Item1), new Item2)
    val 减数1: 减数1 = new 减数Positive(
      new 减数Positive(new 减数Positive(new 减数Positive(new 减数Positive(new 减数Zero, new Item3), new Item4), new Item5), new Item6),
      new Item7
    )
    val 差1: 差1 = 减数1.减(被减数1)
    println(被减数1.length) // 2
    println(减数1.length)  // 5
    println(差1)          // 零 :: Item3 :: Item4 :: Item5
    println(差1.length)   // 3

    println("======================================")

    val 被减数2: 被减数2 =
      new 被减数Positive(new 被减数Positive(new 被减数Positive(new 被减数Positive(new 被减数Zero, new Item1), new Item2), new Item3), new Item4)
    val 减数2: 减数2 = new 减数Positive(new 减数Positive(new 减数Positive(new 减数Zero, new Item5), new Item6), new Item7)
    val 差2: 差2   = 减数2.减(被减数2)
    println(被减数2.length) // 4
    println(减数2.length)  // 3
    println(差2)          // 零 :: Item1
    println(差2.length)   // 1

    println("======================================")

    val 被减数3: 被减数3 =
      new 被减数Positive(new 被减数Positive(new 被减数Positive(new 被减数Positive(new 被减数Zero, new Item1), new Item2), new Item3), new Item4)
    val 减数3: 减数3 = new 减数Positive(new 减数Positive(new 减数Positive(new 减数Positive(new 减数Zero, new Item4), new Item5), new Item6), new Item7)
    val 差3: 差3   = 减数3.减(被减数3)
    println(被减数3.length) // 4
    println(减数3.length)  // 4
    println(差3)          // 零
    println(差3.length)   // 0

  }

}
