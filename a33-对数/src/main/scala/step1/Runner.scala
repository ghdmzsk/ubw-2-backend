package step1

object Runner {

  class Tag[T]

  def i[T](tag1: Tag[T], tag2: Tag[T]): List[Tag[T]] = List(tag1, tag2)

  class Item1
  class Item2
  class Item3
  class Item4
  class Item5
  class Item6
  class Item7
  class Item8

  /*type 被减数1 = 被减数Positive[被减数Positive[被减数Positive[被减数Zero, Item1], Item2], Item3]
  type 减数1  = 减数Positive[减数Positive[减数Positive[减数Positive[减数Positive[减数Zero, Item4], Item5], Item6], Item7], Item8]
  type 结果1  = 减数Positive[减数Positive[减数Zero, Item4], Item5]
  i(new Tag[结果1], new Tag[减数1#减[被减数1]])

  type 被减数2 = 被减数Positive[被减数Positive[被减数Positive[被减数Positive[被减数Zero, Item1], Item2], Item3], Item4]
  type 减数2  = 减数Positive[减数Zero, Item5]
  type 结果2  = 被减数Positive[被减数Positive[被减数Positive[被减数Zero, Item1], Item2], Item3]
  i(new Tag[结果2], new Tag[减数2#减[被减数2]])

  type 被减数3 = 被减数Positive[被减数Positive[被减数Positive[被减数Zero, Item1], Item2], Item3]
  type 减数3  = 减数Positive[减数Positive[减数Positive[减数Zero, Item4], Item5], Item6]
  type 结果3  = 被减数Zero*/
  // i(new Tag[结果3], new Tag[减数3#减[被减数3]])

}
