package step3

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

  /*type T1[_] = 零
  type 负数1   = 负数[({ type T7[T8] = 负数[T1, T8] })#T7, Item7]
  type 负数2   = 负数[({ type T2[T3] = 负数[({ type T4[T5] = 负数[T1, T5] })#T4, T3] })#T2, Item8]
  type 负数3   = 负数[({ type T2[T3] = 负数[({ type T4[T5] = 负数[({ type T6[_] = 负数[({ type T7[T8] = 负数[T1, T8] })#T7, Item7] })#T6, T5] })#T4, T3] })#T2, Item8]
  type 负数4   = 负数[({ type T2[T3] = 负数[({ type T4[T5] = 负数[({ type T6[_] = 负数1 })#T6, T5] })#T4, T3] })#T2, Item8]
  type 负数5   = 负数[T1, Item1]
  type 负数6   = 负数[({ type T4[T5] = 负数[T1, T5] })#T4, Item7]
  type 负数7   = 负数[({ type T2[T3] = 负数[({ type T4[T5] = 负数[T1, T5] })#T4, Item7] })#T2, Item1]

  type 正数1 = 正数[零, Item1]
  type 正数2 = 正数[正数[零, Item1], Item2]
  type 正数3 = 正数[正数[正数[零, Item1], Item2], Item3]
  type 正数4 = 正数[正数[正数[正数[零, Item1], Item2], Item3], Item4]
  type 正数5 = 正数[正数[正数[正数[正数[零, Item1], Item2], Item3], Item4], Item5]
  type 正数6 = 正数[正数[正数[正数[正数[正数[零, Item1], Item2], Item3], Item4], Item5], Item6]*/

}
