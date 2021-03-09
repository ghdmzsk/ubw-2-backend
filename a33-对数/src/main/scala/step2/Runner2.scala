package step2

object Runner2 {

  class Tag[T]

  def i[T](tag1: Tag[T], tag2: Tag[T]): List[Tag[T]] = List(tag1, tag2)

  class Item1
  class Item2
  class Item3
  class Di1
  class Di2

  class 底数3 extends 底Positive[底Positive[底数1, Item1], Item2]
  class 底数1 extends 底1[底数3]

  i(
    new Tag[log#run[底数3, 指数1]],
    new Tag[隐数Positive[隐数Positive[隐数1, Item2], Item1]]
  )

  i(
    new Tag[log#run[底数3, 指数Positive[指数1, Di1]]],
    new Tag[隐数Positive[隐数Positive[隐数Positive[隐数Positive[隐数Positive[隐数Positive[隐数Positive[隐数Positive[隐数1, Item2], Item1], Item2], Item1], Item2], Item1], Item2], Item1]]
  )

  i(
    new Tag[log#run[底数3, 指数Positive[指数Positive[指数1, Di1], Di2]]],
    new Tag[隐数Positive[隐数Positive[隐数Positive[隐数Positive[
      隐数Positive[隐数Positive[隐数Positive[隐数Positive[隐数Positive[隐数Positive[隐数Positive[隐数Positive[隐数Positive[隐数Positive[隐数Positive[隐数Positive[隐数Positive[隐数Positive[
        隐数Positive[隐数Positive[隐数Positive[隐数Positive[隐数Positive[隐数Positive[隐数Positive[隐数Positive[隐数1, Item2], Item1], Item2], Item1], Item2], Item1], Item2], Item1],
        Item2
      ], Item1], Item2], Item1], Item2], Item1], Item2], Item1], Item2], Item1], Item2], Item1], Item2], Item1],
      Item2
    ], Item1], Item2], Item1]]
  )

}
