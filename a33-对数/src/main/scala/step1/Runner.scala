package step1

object Runner1 {

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
  class Item9
  class Item10
  class Item11
  class Item12
  class Item13
  class Item14
  class Item15
  class Item16
  class Item17

  class 底数2 extends 底Positive[底数1, Item17]
  class 底数1 extends 底1[底数2]

  type 真数1 = 真数Positive[真数Zero, Item1]
  i(new Tag[log#run[底数2, 真数1]], new Tag[对数Zero])

  type 真数2 = 真数Positive[真数1, Item2]
  i(new Tag[log#run[底数2, 真数2]], new Tag[对数Positive[对数Zero]])

  type 真数3 = 真数Positive[真数2, Item3]
  i(new Tag[log#run[底数2, 真数3]], new Tag[对数Positive[对数Zero]])

  type 真数4 = 真数Positive[真数3, Item4]
  i(new Tag[log#run[底数2, 真数4]], new Tag[对数Positive[对数Zero]])

  /*type 真数5 = 真数Positive[真数4, Item5]
  i(new Tag[log#run[底数2, 真数5]], new Tag[对数Positive[对数Zero]])

  type 真数6 = 真数Positive[真数5, Item6]
  i(new Tag[log#run[底数2, 真数6]], new Tag[对数Positive[对数Positive[对数Zero]]])

  type 真数7 = 真数Positive[真数6, Item7]
  i(new Tag[log#run[底数2, 真数7]], new Tag[对数Positive[对数Positive[对数Zero]]])

  type 真数8 = 真数Positive[真数7, Item8]
  i(new Tag[log#run[底数2, 真数8]], new Tag[对数Positive[对数Positive[对数Zero]]])

  type 真数9 = 真数Positive[真数8, Item9]
  i(new Tag[log#run[底数2, 真数9]], new Tag[对数Positive[对数Positive[对数Zero]]])

  type 真数10 = 真数Positive[真数9, Item10]
  i(new Tag[log#run[底数2, 真数10]], new Tag[对数Positive[对数Positive[对数Zero]]])

  type 真数11 = 真数Positive[真数10, Item11]
  i(new Tag[log#run[底数2, 真数11]], new Tag[对数Positive[对数Positive[对数Zero]]])

  type 真数12 = 真数Positive[真数11, Item12]
  i(new Tag[log#run[底数2, 真数12]], new Tag[对数Positive[对数Positive[对数Positive[对数Zero]]]])

  type 真数13 = 真数Positive[真数12, Item13]
  i(new Tag[log#run[底数2, 真数13]], new Tag[对数Positive[对数Positive[对数Positive[对数Zero]]]])

  type 真数14 = 真数Positive[真数13, Item14]
  i(new Tag[log#run[底数2, 真数14]], new Tag[对数Positive[对数Positive[对数Positive[对数Zero]]]])

  type 真数15 = 真数Positive[真数14, Item15]
  i(new Tag[log#run[底数2, 真数15]], new Tag[对数Positive[对数Positive[对数Positive[对数Zero]]]])

  type 真数16 = 真数Positive[真数15, Item16]
  i(new Tag[log#run[底数2, 真数16]], new Tag[对数Positive[对数Positive[对数Positive[对数Zero]]]])*/
}
