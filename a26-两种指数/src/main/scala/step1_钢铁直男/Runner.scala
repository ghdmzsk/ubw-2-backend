package step1_钢铁直男

object Runner {

  class 类型匹配[T]
  object 类型匹配 {
    def apply[T1, T2]: (类型匹配[T1], 类型匹配[T2])            = (new 类型匹配[T1], new 类型匹配[T2])
    def apply[T](i: (类型匹配[T], 类型匹配[T])): List[类型匹配[T]] = List(i._1, i._2)
  }

  type 幂值2 = 幂Positive[幂1]
  type 幂值3 = 幂Positive[幂值2]

  class Item1
  class Item2
  class Item3

  type 底1 = 底Positive[底Positive[底Zero, Item1], Item2]
  类型匹配(类型匹配[幂值2#阶乘[底1], 底Positive[底Positive[底Positive[底Positive[底Zero, Item1], Item2], Item1], Item2]])
  类型匹配(
    类型匹配[幂值3#阶乘[底1], 底Positive[
      底Positive[底Positive[底Positive[底Positive[底Positive[底Positive[底Positive[底Zero, Item1], Item2], Item1], Item2], Item1], Item2], Item1],
      Item2
    ]]
  )

  type 底2 = 底Positive[底Positive[底Positive[底Zero, Item1], Item2], Item3]

  type 结果1 = 底Positive[底Positive[底Positive[底Positive[底Positive[底Positive[底Zero, Item1], Item2], Item3], Item1], Item2], Item3]
  type 结果2 = 底Positive[底Positive[底Positive[底Positive[底Positive[底Positive[结果1, Item1], Item2], Item3], Item1], Item2], Item3]
  type 结果3 = 底Positive[底Positive[底Positive[底Positive[底Positive[底Positive[结果2, Item1], Item2], Item3], Item1], Item2], Item3]
  type 结果4 = 底Positive[底Positive[底Positive[底Positive[底Positive[底Positive[结果3, Item1], Item2], Item3], Item1], Item2], Item3]
  type 结果5 = 底Positive[底Positive[底Positive[结果4, Item1], Item2], Item3]

  // val a: 幂值3#阶乘[底2] = 2

  类型匹配(类型匹配[幂值3#阶乘[底2]#Self, 结果5])

}
