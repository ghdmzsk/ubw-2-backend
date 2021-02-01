package step2

object Runner {

  class 类型匹配[T]
  object 类型匹配 {
    def apply[T1, T2]: (类型匹配[T1], 类型匹配[T2])            = (new 类型匹配[T1], new 类型匹配[T2])
    def apply[T](i: (类型匹配[T], 类型匹配[T])): List[类型匹配[T]] = List(i._1, i._2)
    def i[T](i1: T, i2: T): List[T]                    = List(i1, i2)
  }

  class Item1
  class Item2
  class Item3
  class Item4
  class Item5
  class Item6
  class Item7

  class 底3     extends 底Positive[底Positive[底Zero1, Item2], Item3]
  class 底Zero1 extends 底1[底3, Item1]
  type 指数值1 = 指数Positive[指数Positive[指数1]]
  type 自然数1 = 自然数Positive[自然数Positive[自然数Positive[自然数Positive[自然数Positive[自然数Positive[自然数Zero, Item1], Item2], Item3], Item1], Item2], Item3]
  type 自然数2 = 自然数Positive[自然数Positive[自然数Positive[自然数Positive[自然数Positive[自然数Positive[自然数1, Item1], Item2], Item3], Item1], Item2], Item3]
  type 自然数3 = 自然数Positive[自然数Positive[自然数Positive[自然数Positive[自然数Positive[自然数Positive[自然数2, Item1], Item2], Item3], Item1], Item2], Item3]
  type 自然数4 = 自然数Positive[自然数Positive[自然数Positive[自然数Positive[自然数Positive[自然数Positive[自然数3, Item1], Item2], Item3], Item1], Item2], Item3]
  type 自然数5 = 自然数Positive[自然数Positive[自然数Positive[自然数4, Item1], Item2], Item3]

  类型匹配(类型匹配[指数值1#指数[底3]#Self, 自然数5])

  class 底4 extends 底Positive[底Zero4, Item2]

  class 底Zero4 extends 底1[底4, Item1]
  type 指数值2 = 指数Positive[指数Positive[指数1]]
  type 自然数6 = 自然数Positive[
    自然数Positive[自然数Positive[自然数Positive[自然数Positive[自然数Positive[自然数Positive[自然数Positive[自然数Zero, Item1], Item2], Item1], Item2], Item1], Item2], Item1],
    Item2
  ]

  类型匹配(类型匹配[指数值2#指数[底4], 自然数6])

}
