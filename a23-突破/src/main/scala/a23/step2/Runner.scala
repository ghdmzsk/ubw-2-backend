package a23.step2

object Runner {

  class 类型匹配[T]
  object 类型匹配 {
    def apply[T1, T2]: (类型匹配[T1], 类型匹配[T2])            = (new 类型匹配[T1], new 类型匹配[T2])
    def apply[T](t: (类型匹配[T], 类型匹配[T])): List[类型匹配[T]] = List(t._1, t._2)
  }

  class Item1
  class Item2
  class Item3
  class Item4
  class MM5
  class MM6
  class MM7

  type 挑战者1 = 挑战者Positive[挑战者Positive[挑战者Positive[挑战者Positive[挑战者Zero, Item1], Item2], Item3], Item4]
  type 困难1  = 困难Positive[困难Positive[困难Positive[困难Zero, MM5], MM6], MM7]
  type 结果1  = 挑战者Positive[挑战者Positive[挑战者Positive[挑战者Positive[挑战者Positive[挑战者Positive[挑战者Positive[挑战者Zero, Item1], MM5], Item2], MM6], Item3], MM7], Item4]
  类型匹配(类型匹配[挑战者1#挑战[困难1], 结果1])

  class ItemA1
  class ItemA2
  class MMA3
  class MMA4
  class MMA5
  class MMA6
  class MMA7

  type 挑战者2 = 挑战者Positive[挑战者Positive[挑战者Zero, ItemA1], ItemA2]
  type 困难2  = 困难Positive[困难Positive[困难Positive[困难Positive[困难Positive[困难Zero, MMA3], MMA4], MMA5], MMA6], MMA7]
  type 结果2  = 困难Positive[困难Positive[困难Positive[困难Positive[困难Positive[困难Positive[困难Positive[困难Zero, MMA3], MMA4], MMA5], MMA6], ItemA1], MMA7], ItemA2]
  类型匹配(类型匹配[挑战者2#挑战[困难2], 结果2])

}
