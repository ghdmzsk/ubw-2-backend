package a10

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
  class Item6 {
    override def toString: String = "Item6"
  }
  class Item7 {
    override def toString: String = "Item7"
  }
  class Item8 {
    override def toString: String = "Item8"
  }
  class Item9 {
    override def toString: String = "Item9"
  }
  class Item10 {
    override def toString: String = "Item10"
  }
  class Item11 {
    override def toString: String = "Item11"
  }
  class Item12 {
    override def toString: String = "Item12"
  }
  class Item13 {
    override def toString: String = "Item13"
  }
  class Item14 {
    override def toString: String = "Item14"
  }
  class Item15 {
    override def toString: String = "Item15"
  }
  class Item16 {
    override def toString: String = "Item16"
  }

  def main(arr: Array[String]): Unit = {
    type Nat1 = 自然数零#Next[Item16]#Next[Item15]#Next[Item14]#Next[Item13]#Next[Item12]#Next[Item11]#Next[Item10]#Next[Item9]#Next[Item8]#Next[Item7]#Next[Item6]#Next[
      Item5
    ]#Next[Item4]#Next[Item3]#Next[Item2]#Next[Item1]
    val nat1: Nat1 = 自然数零.value
      .next(new Item16)
      .next(new Item15)
      .next(new Item14)
      .next(new Item13)
      .next(new Item12)
      .next(new Item11)
      .next(new Item10)
      .next(new Item9)
      .next(new Item8)
      .next(new Item7)
      .next(new Item6)
      .next(new Item5)
      .next(new Item4)
      .next(new Item3)
      .next(new Item2)
      .next(new Item1)
    val item1                         = nat1._1._4.natPair.get
    val item2: Nat1#_1#_4#NatPair#GET = item1
    val item3: Item15                 = item2
    println(item3) // Item15
  }

}
