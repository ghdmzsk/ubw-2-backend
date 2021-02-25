package 练习07

object Runner {

  class Tag[T]
  def i[T](i1: Tag[T], i2: Tag[T]): List[Tag[T]] = List(i1, i2)

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

  type 被除数16 = 被除数Positive[被除数Positive[被除数Positive[被除数Positive[被除数Positive[被除数Positive[被除数Positive[被除数Positive[被除数Positive[
    被除数Positive[被除数Positive[被除数Positive[被除数Positive[被除数Positive[被除数Positive[被除数Positive[被除数Zero, Item1], Item2], Item3], Item4], Item5], Item6], Item7],
    Item8
  ], Item9], Item10], Item11], Item12], Item13], Item14], Item15], Item16]

  class 除数8
      extends 除数Positive[除数Positive[除数Positive[除数Positive[除数Positive[除数Positive[除数Positive[除数Positive[除数零1, Item1], Item2], Item3], Item4], Item5], Item6], Item7], Item8]
  class 除数零1 extends 除数Zero[除数8]

  type 商2 = 商Postive[商Postive[商Zero]]

  i(new Tag[除数8#除[被除数16]], new Tag[商2])

  class 除数2  extends 除数Positive[除数Positive[除数零2, Item1], Item2]
  class 除数零2 extends 除数Zero[除数2]

  type 商8 = 商Postive[商Postive[商Postive[商Postive[商Postive[商Postive[商Postive[商Postive[商Zero]]]]]]]]

  i(new Tag[除数2#除[被除数16]], new Tag[商8])

  class 除数5  extends 除数Positive[除数Positive[除数Positive[除数Positive[除数Positive[除数零3, Item1], Item2], Item3], Item4], Item5]
  class 除数零3 extends 除数Zero[除数5]

  type 商3 = 商Postive[商Postive[商Postive[商Zero]]]

  i(new Tag[除数5#除[被除数16]], new Tag[商3])
}
