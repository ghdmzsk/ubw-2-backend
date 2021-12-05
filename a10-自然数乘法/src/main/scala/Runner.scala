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
    type Nat1    = 自然数零#Next[Item1]#Next[Item2]#Next[Item3]
    type Nat2    = 自然数零#Next[Item4]#Next[Item5]
    type Mutiply = Nat1#乘以[Nat2]
    type MutiplyNat =
      元素对自然数零#Next[Item4, Item1]#Next[Item5, Item1]#Next[Item4, Item2]#Next[Item5, Item2]#Next[Item4, Item3]#Next[Item5, Item3]
    val nat1: Nat1             = 自然数零.value.next(new Item1).next(new Item2).next(new Item3)
    val nat2: Nat2             = 自然数零.value.next(new Item4).next(new Item5)
    val mutiply: Mutiply       = nat1.乘以(nat2)
    val mutiplyNat: MutiplyNat = mutiply
    println(mutiplyNat)
  }

}
