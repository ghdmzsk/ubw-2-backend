package step2

object Runner1 {

  class Tag[T]

  def i[T](tag1: Tag[T], tag2: Tag[T]): List[Tag[T]] = List(tag1, tag2)

  class Item1
  class Item2
  class Item3
  class Di1
  class Di2

  class 底数2 extends 底Positive[底数1, Item1]
  class 底数1 extends 底1[底数2]

  i(new Tag[log#run[底数2, 指数1]], new Tag[隐数Positive[隐数1, Item1]])

  type 指数值2 = 指数Positive[指数1, Di1]
  i(new Tag[log#run[底数2, 指数值2]], new Tag[隐数Positive[隐数Positive[隐数Positive[隐数1, Item1], Item1], Item1]])

  type 指数值3 = 指数Positive[指数值2, Di2]
  i(
    new Tag[log#run[底数2, 指数值3]],
    new Tag[
      隐数Positive[
        隐数Positive[隐数Positive[隐数Positive[隐数Positive[隐数Positive[隐数Positive[隐数1, Item1], Item1], Item1], Item1], Item1], Item1],
        Item1
      ]
    ]
  )

  type 指数值4 = 指数Positive[指数值3, Item3]
  i(
    new Tag[log#run[底数2, 指数值4]],
    new Tag[
      隐数Positive[隐数Positive[隐数Positive[隐数Positive[隐数Positive[隐数Positive[隐数Positive[
        隐数Positive[隐数Positive[
          隐数Positive[隐数Positive[隐数Positive[隐数Positive[隐数Positive[隐数Positive[隐数1, Item1], Item1], Item1], Item1], Item1], Item1],
          Item1
        ], Item1],
        Item1
      ], Item1], Item1], Item1], Item1], Item1], Item1]
    ]
  )

}
