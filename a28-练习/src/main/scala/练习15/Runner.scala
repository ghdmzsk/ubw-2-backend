package 练习15

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

  type 被加数1 = 被加数Positive[被加数Positive[被加数Positive[被加数Zero, Item1], Item2], Item3]
  type 加数1  = 加数Positive[加数Positive[加数Positive[加数Positive[加数Positive[加数Positive[加数Zero, Item4], Item5], Item6], Item7], Item8], Item9]
  type 和1 = 被加数Positive[被加数Positive[
    被加数Positive[
      被加数Positive[被加数Positive[被加数Positive[被加数Positive[被加数Positive[被加数Positive[被加数Zero, Item1], Item2], Item3], Item4], Item5], Item6],
      Item7
    ],
    Item8
  ], Item9]
  i(new Tag[加数1#加[被加数1]], new Tag[和1])

}
