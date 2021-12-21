package 练习01

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

  class 底值2 extends 底Positive[底值1, Item2]
  class 底值1 extends 底1[底值2, Item1]

  type 指数值1 = 指数Positive[指数Positive[指数1]]
  type 结果1 = 自然数Positive[
    自然数Positive[
      自然数Positive[自然数Positive[自然数Positive[自然数Positive[自然数Positive[自然数Positive[自然数Zero, Item1], Item2], Item1], Item2], Item1], Item2],
      Item1
    ],
    Item2
  ]
  类型匹配.i2(类型匹配.i1[指数运算#指[底值2, 指数值1], 结果1])

}
