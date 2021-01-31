package step2

object Runner {

  class 类型匹配[T]
  object 类型匹配 {
    def apply[T1, T2]: (类型匹配[T1], 类型匹配[T2])            = (new 类型匹配[T1], new 类型匹配[T2])
    def apply[T](i: (类型匹配[T], 类型匹配[T])): List[类型匹配[T]] = List(i._1, i._2)
  }

  class Item1
  class Item2
  class Item3
  class Item4
  class Item5
  class Item6
  class Item7

  class 底1     extends 底Positive[底Positive[底Zero1, Item1], Item2]
  class 底Zero1 extends 底Zero[底1]
  type 指数1 = 指数Positive[指数Positive[指数Zero]]
  type 容器1 = 容器Positive[容器Zero, 底1, 指数1]
  type 自然数1 = 自然数Positive[
    自然数Positive[自然数Positive[自然数Positive[自然数Positive[自然数Positive[自然数Positive[自然数Positive[自然数Zero, Item1], Item2], Item1], Item2], Item1], Item2], Item1],
    Item2
  ]

  val aa: 底1#交[容器1] = 2

  //类型匹配(类型匹配[底1#交[容器1], 自然数1])

  /*type 被乘数2 = 被乘数Positive[被乘数Positive[被乘数Positive[被乘数Zero, Item1], Item2], Item3]
  class 乘数Positive2 extends 乘数Positive[乘数Positive[乘数Positive[乘数Positive[乘数零2, Item4], Item5], Item6], Item7]
  class 乘数零2        extends 乘数Zero[乘数Positive2]
  type 积2 = 积Positive[积Positive[积Positive[积Positive[积Positive[积Positive[
    积Positive[积Positive[积Positive[积Positive[积Positive[积Positive[积Zero, Item4, Item1], Item5, Item1], Item6, Item1], Item7, Item1], Item4, Item2], Item5, Item2],
    Item6,
    Item2
  ], Item7, Item2], Item4, Item3], Item5, Item3], Item6, Item3], Item7, Item3]

  类型匹配(类型匹配[被乘数2#乘以[乘数Positive2], 积2])*/

}
