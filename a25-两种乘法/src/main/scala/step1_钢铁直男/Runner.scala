package step1_钢铁直男

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

  type 被乘数1 = 被乘数Positive[被乘数Positive[被乘数Positive[被乘数Positive[被乘数Positive[被乘数Zero, Item1], Item2], Item3], Item4], Item5]
  type 乘数1  = 乘数Positive[乘数Positive[乘数Zero, Item6], Item7]
  type 积1 = 积Positive[积Positive[积Positive[积Positive[
    积Positive[积Positive[积Positive[积Positive[积Positive[积Positive[积Zero, Item1, Item6], Item2, Item6], Item3, Item6], Item4, Item6], Item5, Item6], Item1, Item7],
    Item2,
    Item7
  ], Item3, Item7], Item4, Item7], Item5, Item7]

  类型匹配(类型匹配[乘数1#乘[被乘数1], 积1])

  type 被乘数2 = 被乘数Positive[被乘数Positive[被乘数Positive[被乘数Zero, Item1], Item2], Item3]
  type 乘数2  = 乘数Positive[乘数Positive[乘数Positive[乘数Positive[乘数Zero, Item4], Item5], Item6], Item7]
  type 积2 = 积Positive[积Positive[积Positive[积Positive[积Positive[积Positive[
    积Positive[积Positive[积Positive[积Positive[积Positive[积Positive[积Zero, Item1, Item4], Item2, Item4], Item3, Item4], Item1, Item5], Item2, Item5], Item3, Item5],
    Item1,
    Item6
  ], Item2, Item6], Item3, Item6], Item1, Item7], Item2, Item7], Item3, Item7]

  类型匹配(类型匹配[乘数2#乘[被乘数2], 积2])

}
