package 练习13

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
  class Item17
  class Item18
  class Item19
  class Item20
  class Item21

  type 被除数15 = 被除数Positive[被除数Positive[被除数Positive[被除数Positive[被除数Positive[被除数Positive[被除数Positive[被除数Positive[
    被除数Positive[被除数Positive[被除数Positive[被除数Positive[被除数Positive[被除数Positive[被除数Positive[被除数Zero, Item1], Item2], Item3], Item4], Item5], Item6], Item7],
    Item8
  ], Item9], Item10], Item11], Item12], Item13], Item14], Item15]
  class 除数1 extends 除数Positive[除数Positive[除数Positive[除数Positive[除数2, Item18], Item19], Item20], Item21]
  class 除数2 extends 除数Zero[除数1]

  i(new Tag[除数1#除[被除数15]], new Tag[商Positive[商Positive[商Positive[商Zero]]]])
  i(new Tag[除数1#除[被除数Positive[被除数15, Item16]]], new Tag[商Positive[商Positive[商Positive[商Positive[商Zero]]]]])
  i(new Tag[除数1#除[被除数Positive[被除数Positive[被除数15, Item16], Item17]]], new Tag[商Positive[商Positive[商Positive[商Positive[商Zero]]]]])

}
