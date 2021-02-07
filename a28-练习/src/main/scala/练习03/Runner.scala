package 练习03

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

  /*type 被除数值1 = 被除数Positive[被除数Positive[被除数Positive[被除数Positive[被除数Positive[被除数Positive[被除数Positive[被除数Positive[被除数Positive[被除数Positive[被除数Positive[被除数Zero]]]]]]]]]]]
  type 被除数值2 = 被除数Positive[被除数值1]
  type 被除数值3 = 被除数Positive[被除数值2]

  class 除数值1 extends 除数Positive[除数Positive[除数Positive[除数Positive[除数值2]]]]
  class 除数值2 extends 除数Zero[除数值1]
  类型匹配.i2(类型匹配.i1[除数值1#除[被除数值2], 商Positive[商Positive[商Positive[商Zero]]]])
  类型匹配.i2(类型匹配.i1[除数值1#除[被除数值1], 商Positive[商Positive[商Zero]]])
  类型匹配.i2(类型匹配.i1[除数值1#除[被除数值2], 商Positive[商Positive[商Positive[商Zero]]]])*/

  type 被除数值1 = 被除数Positive[
    被除数Positive[被除数Positive[被除数Positive[被除数Positive[被除数Positive[被除数Positive[被除数Positive[被除数Zero, Item1], Item2], Item3], Item4], Item5], Item6], Item7],
    Item8
  ]
  class 除数值1 extends 除数Positive[除数Positive[除数值2, Item8], Item8]
  class 除数值2 extends 除数Zero[除数值1]
  class 除数值3 extends 除数Positive[除数Positive[除数Positive[除数值4, Item8], Item8], Item8]
  class 除数值4 extends 除数Zero[除数值3]

  类型匹配.i2(类型匹配.i1[除数值1#除[被除数值1], 商Positive[商Positive[商Positive[商Positive[商Zero]]]]])
  类型匹配.i2(类型匹配.i1[除数值3#除[被除数值1], 商Positive[商Positive[商Zero]]])

}
