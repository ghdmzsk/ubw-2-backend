package 除.step1

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
  class Item8
  class Item9
  class Item10
  class Item11
  class Item12
  class Item13
  class Item14
  class Item15
  class Item16

  type 被除数1 = 被除数Positive[被除数Positive[被除数Positive[被除数Positive[被除数Positive[被除数Zero, Item1], Item2], Item3], Item4], Item5]
  class 除数值2    extends 除数Positive[除数Positive[除数Zero1]]
  class 除数Zero1 extends 除数Zero[除数值2]
  // class 除数值0    extends 除数Zero[除数值0] // Error

  类型匹配(类型匹配[除数值2#除[被除数1], 商Positive[商Positive[商Zero]]])

  type 被除数2 = 被除数Positive[被除数Positive[被除数Positive[被除数Positive[被除数Positive[被除数1, Item6], Item7], Item8], Item9], Item10]
  type 被除数3 =
    被除数Positive[被除数Positive[被除数Positive[被除数Positive[被除数Positive[被除数Positive[被除数2, Item11], Item12], Item13], Item14], Item15], Item16]

  class 除数值3    extends 除数Positive[除数Positive[除数Positive[除数Zero2]]]
  class 除数Zero2 extends 除数Zero[除数值3]

  class 除数值5    extends 除数Positive[除数Positive[除数Positive[除数Positive[除数Positive[除数Zero3]]]]]
  class 除数Zero3 extends 除数Zero[除数值5]

  类型匹配(类型匹配[除数值5#除[被除数2], 商Positive[商Positive[商Zero]]])
  类型匹配(类型匹配[除数值3#除[被除数3], 商Positive[商Positive[商Positive[商Positive[商Positive[商Zero]]]]]])

}
