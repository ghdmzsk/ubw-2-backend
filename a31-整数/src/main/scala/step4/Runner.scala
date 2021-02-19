package step4

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

  type 整数1 = 正数[正数[正数[正数[正数[正数零, Item1], Item2], Item3], Item4], Item5]
  type 整数2 = 正数零#后继[Item1]#后继[Item2]#后继[Item3]#后继[Item4]#后继[Item5]
  i(new Tag[整数1], new Tag[整数2])

  type 整数3 = 负数[({ type T1[I1] = 负数代理[({ type T2[I2] = 负数代理[({ type T3[I3] = 负数代理零 })#T3, I2] })#T2, I1] })#T1]
  type 整数4 = 整数2#前驱#前驱#前驱#前驱#前驱#前驱#前驱
  i(new Tag[整数3], new Tag[整数4])

  type 整数5 = 负数[({ type T1[I1] = 负数代理[({ type T2[I2] = 负数代理[({ type T3[I3] = 负数代理零 })#T3, I2] })#T2, I1] })#T1]
  type 整数6 =
    负数[({ type T1[I1] = 负数代理[({ type T2[I2] = 负数代理[({ type T3[I3] = 负数代理[({ type T4[I4] = 负数代理[({ type T5[I5] = 负数代理零 })#T5, I4] })#T4, I3] })#T3, I2] })#T2, I1] })#T1]
  i(new Tag[整数5#前驱#前驱], new Tag[整数6])
  i(new Tag[整数5], new Tag[整数6#后继[Item2]#后继[Item1]])
  i(new Tag[整数5#前驱], new Tag[整数6#后继[Item2]])

  type 整数7 = 正数[正数[正数零, Item1], Item2]
  i(new Tag[整数7], new Tag[整数6#后继[Item7]#后继[Item6]#后继[Item5]#后继[Item4]#后继[Item3]#后继[Item1]#后继[Item2]])

}
