package 练习18

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

  class 被乘数1 extends 被乘数Positive[被乘数Positive[被乘数Positive[被乘数2, Item1], Item2], Item3]
  class 被乘数2 extends 被乘数Zero[被乘数1]
  type 乘数1 = 乘数Positive[乘数Positive[乘数Zero, Item4], Item5]

  type 积1 = 积Positive[积Positive[积Positive[积Positive[积Positive[积Positive[积Zero, Item1, Item4], Item2, Item4], Item3, Item4], Item1, Item5], Item2, Item5], Item3, Item5]

  class 被乘数3 extends 被乘数Positive[被乘数Positive[被乘数4, Item1], Item2]
  class 被乘数4 extends 被乘数Zero[被乘数3]
  type 乘数2 = 乘数Positive[乘数Positive[乘数Positive[乘数Positive[乘数Zero, Item3], Item4], Item5], Item6]
  type 积2 = 积Positive[积Positive[
    积Positive[积Positive[积Positive[积Positive[积Positive[积Positive[积Zero, Item1, Item3], Item2, Item3], Item1, Item4], Item2, Item4], Item1, Item5], Item2, Item5],
    Item1,
    Item6
  ], Item2, Item6]
  i(new Tag[乘数2#乘[被乘数3]], new Tag[积2])

}
