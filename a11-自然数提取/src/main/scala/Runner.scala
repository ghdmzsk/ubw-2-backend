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

  def main(arr: Array[String]): Unit = {
    type Nat1    = 自然数零#Next[Item1]#Next[Item2]#Next[Item3]#Next[Item4]#Next[Item5]
    type NatTag2 = 自然数标记零#Next#Next#Next
    val nat1: Nat1       = 自然数零.value.next(new Item1).next(new Item2).next(new Item3).next(new Item4).next(new Item5)
    val natTag2: NatTag2 = 自然数标记零.value.next.next.next
    type I2 = Nat1#消去标记[NatTag2]#GET
    val i2: I2    = nat1.消去标记(natTag2).get
    val i3: Item2 = i2 // Item2
    println(i3)
  }

}
