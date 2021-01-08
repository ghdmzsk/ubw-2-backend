package a23.step1

object Runner {
  class 类型匹配[T1]
  object 类型匹配 {
    def apply[T](i: (类型匹配[T], 类型匹配[T])): List[类型匹配[T]] = List(i._1, i._2)
    def apply[T1, T2]: (类型匹配[T1], 类型匹配[T2])            = (new 类型匹配[T1], new 类型匹配[T2])
  }

  class Item1
  class Item2
  class Item3
  class Item4
  class Item5
  class Item6
  class Item7

  type 被计算1 = 被计算Positive[被计算Positive[被计算Positive[被计算Zero, Item1], Item2], Item3]
  type 计算1  = 计算Positive[计算Positive[计算Positive[计算Positive[计算Zero, Item4], Item5], Item6], Item7]
  类型匹配(类型匹配[被计算1#confirm[计算1], 小于等于[被计算1, 计算1]])

  type 被计算2 = 被计算Positive[被计算Positive[被计算Positive[被计算Positive[被计算Zero, Item1], Item2], Item3], Item4]
  type 计算2  = 计算Positive[计算Positive[计算Positive[计算Zero, Item5], Item6], Item7]
  类型匹配(类型匹配[被计算2#confirm[计算2], 大于[被计算2, 计算2]])

  type 被计算3 = 被计算Positive[被计算Positive[被计算Positive[被计算Zero, Item1], Item2], Item3]
  type 计算3  = 计算Positive[计算Positive[计算Positive[计算Zero, Item4], Item5], Item6]
  类型匹配(类型匹配[被计算3#confirm[计算3], 小于等于[被计算3, 计算3]])

  type 被计算4 = 被计算Positive[被计算Positive[被计算Zero, Item1], Item2]
  type 计算4  = 计算Positive[计算Positive[计算Positive[计算Positive[计算Positive[计算Zero, Item3], Item4], Item5], Item6], Item7]
  类型匹配(类型匹配[被计算4#confirm[计算4], 小于等于[被计算4, 计算4]])

  type 被计算5 = 被计算Positive[被计算Positive[被计算Positive[被计算Positive[被计算Positive[被计算Zero, Item1], Item2], Item3], Item4], Item5]
  type 计算5  = 计算Positive[计算Positive[计算Zero, Item6], Item7]
  类型匹配(类型匹配[被计算5#confirm[计算5], 大于[被计算5, 计算5]])
}
