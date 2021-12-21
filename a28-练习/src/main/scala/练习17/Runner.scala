package 练习17

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

  type 被除数1 = 被除数Positive[被除数Positive[
    被除数Positive[
      被除数Positive[被除数Positive[被除数Positive[被除数Positive[被除数Positive[被除数Positive[被除数Zero, Item1], Item2], Item3], Item4], Item5], Item6],
      Item7
    ],
    Item8
  ], Item9]
  class 除数1 extends 除数Positive[除数Positive[除数2, Item1], Item2]
  class 除数2 extends 除数Zero[除数1]
  class 除数3 extends 除数Positive[除数Positive[除数Positive[除数4, Item1], Item2], Item3]
  class 除数4 extends 除数Zero[除数3]
  class 除数5 extends 除数Positive[除数Positive[除数Positive[除数Positive[除数6, Item1], Item2], Item3], Item4]
  class 除数6 extends 除数Zero[除数5]

  i(new Tag[除数1#除[被除数1]], new Tag[商Positive[商Positive[商Positive[商Positive[商Zero]]]]])
  i(new Tag[除数3#除[被除数1]], new Tag[商Positive[商Positive[商Positive[商Zero]]]])
  i(new Tag[除数5#除[被除数1]], new Tag[商Positive[商Positive[商Zero]]])

}
