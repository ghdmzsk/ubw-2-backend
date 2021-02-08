package 练习05

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

  type 乘数值1 = 被乘数Positive[被乘数Positive[被乘数Positive[被乘数Zero, Item1], Item2], Item3]
  class 乘数值2 extends 乘数Positive[乘数Positive[乘数值3, Item4], Item5]
  class 乘数值3 extends 乘数Zero[乘数值2]

  类型匹配.i2(
    类型匹配.i1[乘数值1#被乘[乘数值2], 自然数Positive[
      自然数Positive[自然数Positive[自然数Positive[自然数Positive[自然数Positive[自然数Zero, Item4, Item1], Item5, Item1], Item4, Item2], Item5, Item2], Item4, Item3],
      Item5,
      Item3
    ]]
  )

}
