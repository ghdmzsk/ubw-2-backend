package 练习16

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

  type 被减数1 = 被减数Positive[被减数Positive[被减数Zero, Item1], Item2]
  type 减数1  = 减数Positive[减数Positive[减数Positive[减数Positive[减数Positive[减数Positive[减数Positive[减数Zero, Item3], Item4], Item5], Item6], Item7], Item8], Item9]
  type 差1   = 减数Positive[减数Positive[减数Positive[减数Positive[减数Positive[减数Zero, Item3], Item4], Item5], Item6], Item7]
  i(new Tag[减数1#减[被减数1]], new Tag[差1])

  type 被减数2 = 被减数Positive[被减数Positive[被减数Positive[被减数Positive[被减数Positive[被减数Positive[被减数Zero, Item1], Item2], Item3], Item4], Item5], Item6]
  type 减数2  = 减数Positive[减数Positive[减数Positive[减数Zero, Item7], Item8], Item9]
  type 差2   = 被减数Positive[被减数Positive[被减数Positive[被减数Zero, Item1], Item2], Item3]
  i(new Tag[减数2#减[被减数2]], new Tag[差2])

}
