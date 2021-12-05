package 练习12

object Runner1 {

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

  class 被乘数1 extends 被乘数Positive[被乘数Positive[被乘数Positive[被乘数Positive[被乘数2, Item1], Item2], Item3], Item4]
  class 被乘数2 extends 被乘数Zero[被乘数1]
  type 乘数1 = 乘数Positive[乘数Positive[乘数Positive[乘数Zero, Item5], Item6], Item7]

  type 积1 = 积Positive[积Positive[积Positive[
    积Positive[积Positive[积Positive[
      积Positive[
        积Positive[积Positive[积Positive[积Positive[积Positive[积Zero, Item1, Item5], Item2, Item5], Item3, Item5], Item4, Item5], Item1, Item6],
        Item2,
        Item6
      ],
      Item3,
      Item6
    ], Item4, Item6], Item1, Item7],
    Item2,
    Item7
  ], Item3, Item7], Item4, Item7]

  i(new Tag[乘数1#乘[被乘数1]], new Tag[积1])

  class 被乘数3 extends 被乘数Zero[被乘数3]

  i(new Tag[乘数1#乘[被乘数3]], new Tag[积Zero])
  i(new Tag[乘数Zero#乘[被乘数2]], new Tag[积Zero])
  i(new Tag[乘数Zero#乘[被乘数3]], new Tag[积Zero])
  i(new Tag[乘数Zero#乘[乘数]], new Tag[积Zero])

}
