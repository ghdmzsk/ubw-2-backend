package step2

object Runner3 {

  class Tag[T]

  def i[T](tag1: Tag[T], tag2: Tag[T]): List[Tag[T]] = List(tag1, tag2)

  class Item1
  class Item2
  class Item3
  class Di1
  class Di2

  class 底数4 extends 底Positive[底Positive[底Positive[底数1, Item1], Item2], Item3]
  class 底数1 extends 底1[底数4]

  i(
    new Tag[log#run[底数4, 指数1]],
    new Tag[隐数Positive[隐数Positive[隐数Positive[隐数1, Item3], Item2], Item1]]
  )

  i(
    new Tag[log#run[底数4, 指数Positive[指数1, Di1]]],
    new Tag[隐数Positive[隐数Positive[隐数Positive[隐数Positive[隐数Positive[隐数Positive[隐数Positive[
      隐数Positive[隐数Positive[
        隐数Positive[隐数Positive[隐数Positive[隐数Positive[隐数Positive[隐数Positive[隐数1, Item3], Item2], Item1], Item3], Item2], Item1],
        Item3
      ], Item2],
      Item1
    ], Item3], Item2], Item1], Item3], Item2], Item1]]
  )

  type 隐数10 = 隐数Positive[
    隐数Positive[隐数Positive[
      隐数Positive[隐数Positive[隐数Positive[隐数Positive[隐数Positive[隐数Positive[隐数1, Item3], Item2], Item1], Item3], Item2], Item1],
      Item3
    ], Item2],
    Item1
  ]
  type 隐数20 = 隐数Positive[隐数Positive[
    隐数Positive[隐数Positive[
      隐数Positive[隐数Positive[隐数Positive[隐数Positive[隐数Positive[隐数Positive[隐数10, Item3], Item2], Item1], Item3], Item2], Item1],
      Item3
    ], Item2],
    Item1
  ], Item3]
  type 隐数26 = 隐数Positive[隐数Positive[隐数Positive[隐数Positive[隐数Positive[隐数Positive[隐数20, Item2], Item1], Item3], Item2], Item1], Item3]
  type 隐数30 = 隐数Positive[隐数Positive[隐数Positive[隐数Positive[隐数20, Item2], Item1], Item3], Item2]
  type 隐数40 = 隐数Positive[隐数Positive[
    隐数Positive[隐数Positive[
      隐数Positive[隐数Positive[隐数Positive[隐数Positive[隐数Positive[隐数Positive[隐数30, Item1], Item3], Item2], Item1], Item3], Item2],
      Item1
    ], Item3],
    Item2
  ], Item1]
  type 隐数50 = 隐数Positive[隐数Positive[
    隐数Positive[隐数Positive[
      隐数Positive[隐数Positive[隐数Positive[隐数Positive[隐数Positive[隐数Positive[隐数40, Item3], Item2], Item1], Item3], Item2], Item1],
      Item3
    ], Item2],
    Item1
  ], Item3]
  type 隐数60 = 隐数Positive[隐数Positive[
    隐数Positive[隐数Positive[
      隐数Positive[隐数Positive[隐数Positive[隐数Positive[隐数Positive[隐数Positive[隐数50, Item2], Item1], Item3], Item2], Item1], Item3],
      Item2
    ], Item1],
    Item3
  ], Item2]
  i(
    new Tag[
      log#run[底数4, 指数Positive[指数Positive[指数1, Di1], Di2]]#T#T#T#T#T#T#T#T#T#T#T#T#T#T#T#T#T#T#T#T#T#T#T#T#T#T#T#T#T#T#T#T#T#T#T#T#T#T
    ],
    new Tag[隐数26]
  )
}
