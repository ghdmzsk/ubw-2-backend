package 运行时测试

object Runner {

  class Item1 extends Item {
    override val name: String = "Item1"
  }
  class Item2 extends Item {
    override val name: String = "Item2"
  }
  class Item3 extends Item {
    override val name: String = "Item3"
  }
  class Item4 extends Item {
    override val name: String = "Item4"
  }
  class Item5 extends Item {
    override val name: String = "Item5"
  }
  class Item6 extends Item {
    override val name: String = "Item6"
  }
  class Item7 extends Item {
    override val name: String = "Item7"
  }

  class 底3     extends 底Positive(() => new 底Positive(() => new 底Zero1, new Item2), new Item3)
  class 底Zero1 extends 底1(() => new 底3, new Item1)

  class 底4     extends 底Positive(() => new 底Zero4, new Item2)
  class 底Zero4 extends 底1(() => new 底4, new Item1)

  def main(arr: Array[String]): Unit = {
    val 底3   = new 底3
    val 指数值1 = new 指数Positive(new 指数Positive(new 指数1))
    println(
      指数.指数(底3, 指数值1)
    ) // 自然数Zero :: Item1 :: Item2 :: Item3 :: Item1 :: Item2 :: Item3 :: Item1 :: Item2 :: Item3 :: Item1 :: Item2 :: Item3 :: Item1 :: Item2 :: Item3 :: Item1 :: Item2 :: Item3 :: Item1 :: Item2 :: Item3 :: Item1 :: Item2 :: Item3 :: Item1 :: Item2 :: Item3
    println(指数.指数(底3, 指数值1).length) // 27

    val 底4   = new 底4
    val 指数值2 = new 指数Positive(new 指数Positive(new 指数1))
    println(指数.指数(底4, 指数值2))        // 自然数Zero :: Item1 :: Item2 :: Item1 :: Item2 :: Item1 :: Item2 :: Item1 :: Item2
    println(指数.指数(底4, 指数值2).length) // 8
  }

}
