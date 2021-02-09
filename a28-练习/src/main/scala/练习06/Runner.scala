package 练习06

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
  class Item9
  class Item10
  class Item11
  class Item12
  class Item13

  type 被除数值1 = 被除数Positive[
    被除数Positive[被除数Positive[被除数Positive[被除数Positive[被除数Positive[被除数Positive[被除数Positive[被除数Zero, Item1], Item2], Item3], Item4], Item5], Item6], Item7],
    Item8
  ]

  class 除数值2 extends 除数Positive[除数Positive[除数值3, Item9], Item10]
  class 除数值3 extends 除数Zero[除数值2]

  class 除数值4 extends 除数Positive[除数Positive[除数Positive[除数值5, Item9], Item10], Item11]
  class 除数值5 extends 除数Zero[除数值4]

  class 除数值6 extends 除数Positive[除数Positive[除数Positive[除数Positive[除数值7, Item9], Item10], Item11], Item12]
  class 除数值7 extends 除数Zero[除数值6]

  class 除数值8 extends 除数Positive[除数Positive[除数Positive[除数Positive[除数Positive[除数值9, Item9], Item10], Item11], Item12], Item13]
  class 除数值9 extends 除数Zero[除数值8]

  类型匹配.i2(类型匹配.i1[除数值2#除[被除数值1], 自然数Positive[自然数Positive[自然数Positive[自然数Positive[自然数Zero]]]]])
  类型匹配.i2(类型匹配.i1[除数值4#除[被除数值1], 自然数Positive[自然数Positive[自然数Zero]]])
  类型匹配.i2(类型匹配.i1[除数值6#除[被除数值1], 自然数Positive[自然数Positive[自然数Zero]]])
  类型匹配.i2(类型匹配.i1[除数值8#除[被除数值1], 自然数Positive[自然数Zero]])

}
