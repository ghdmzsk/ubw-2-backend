package 练习04

object Runner {

  class 类型匹配[T]
  object 类型匹配 {
    def i1[T1, T2]: (类型匹配[T1], 类型匹配[T2])            = (new 类型匹配[T1], new 类型匹配[T2])
    def i2[T](i: (类型匹配[T], 类型匹配[T])): List[类型匹配[T]] = List(i._1, i._2)
  }

  class Item1
  class Item2
  class Item3
  class Item4
  class Item5
  class Item6
  class Item7
  class Item8

  type 加数1 = 加数Positive[加数Positive[加数Positive3[加数Zero, Item1, Item2, Item3], Item4], Item5]
  type 加数2 = 加数Positive[加数Positive[加数Positive[加数Positive[加数Positive[加数Zero, Item1], Item2], Item3], Item4], Item5]

  类型匹配.i2(类型匹配.i1[加数1#正, 加数2])

}
