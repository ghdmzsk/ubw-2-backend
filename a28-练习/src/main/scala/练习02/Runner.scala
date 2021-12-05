package 练习02

object Runner {

  def i1[T1, T2]: (类型匹配[T1], 类型匹配[T2])            = (new 类型匹配[T1], new 类型匹配[T2])
  def i2[T](i: (类型匹配[T], 类型匹配[T])): List[类型匹配[T]] = List(i._1, i._2)
  class 类型匹配[T]

  class Item1
  class Item2
  class Item3
  class Item4
  class Item5
  class Item6
  class Item7

  type 被除数值1 =
    被除数Positive[被除数Positive[
      被除数Positive[被除数Positive[被除数Positive[被除数Positive[被除数Positive[被除数Positive[被除数Positive[被除数Positive[被除数Positive[被除数Zero]]]]]]]]]
    ]] // 11
  type 被除数值2 = 被除数Positive[被除数值1] // 12
  type 被除数值3 = 被除数Positive[被除数值2] // 13

  class 除数值1 extends 除数Positive[除数Positive[除数Positive[除数Positive[除数值2]]]]
  class 除数值2 extends 除数Zero[除数值1]

  // 下舍法
  i2(i1[除数值1#除[被除数值2], 商Positive[商Positive[商Positive[商Zero]]]]) // 12 / 4 = 3
  i2(i1[除数值1#除[被除数值1], 商Positive[商Positive[商Zero]]])            // 11 / 4 = 2
  i2(i1[除数值1#除[被除数值3], 商Positive[商Positive[商Positive[商Zero]]]]) // 13 / 4 = 3

  // 上舍法
  i2(i1[被除数值2#被除[除数值2], 商Positive[商Positive[商Positive[商Zero]]]])            // 12 / 4 = 3
  i2(i1[被除数值1#被除[除数值2], 商Positive[商Positive[商Positive[商Zero]]]])            // 11 / 4 = 3
  i2(i1[被除数值3#被除[除数值2], 商Positive[商Positive[商Positive[商Positive[商Zero]]]]]) // 13 / 4 = 4

}
