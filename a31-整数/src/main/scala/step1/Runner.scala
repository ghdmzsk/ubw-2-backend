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

  type 负容器1[T] = 负数容器负数[零, T]
  type 负数1     = 负数[负容器1]
  type 负容器2[T] = 负数容器负数[负数1, T]
  type 负数2     = 负数[负容器2]
  type 负容器3[T] = 负数容器负数[负数2, T]
  type 负数3     = 负数[负容器3]
  type 负容器4[T] = 负数容器负数[负数3, T]
  type 负数4     = 负数[负容器4]
  type 负容器5[T] = 负数容器负数[负数4, T]
  type 负数5     = 负数[负容器5]
  type 负容器6[T] = 负数容器负数[负数5, T]
  type 负数6     = 负数[负容器6]

  type 正数1 = 正数[零, Item1]
  type 正数2 = 正数[正数[零, Item1], Item2]
  type 正数3 = 正数[正数[正数[零, Item1], Item2], Item3]
  type 正数4 = 正数[正数[正数[正数[零, Item1], Item2], Item3], Item4]
  type 正数5 = 正数[正数[正数[正数[正数[零, Item1], Item2], Item3], Item4], Item5]
  type 正数6 = 正数[正数[正数[正数[正数[正数[零, Item1], Item2], Item3], Item4], Item5], Item6]

  i(new Tag[正数4#加[负数6]], new Tag[负数2])
  i(new Tag[正数4#加[负数4]], new Tag[零])
  i(new Tag[正数4#加[负数2]], new Tag[正数2])
  i(new Tag[正数4#加[负数3]], new Tag[正数1])

  i(new Tag[负数4#加[正数6]], new Tag[正数2])
  i(new Tag[负数4#加[正数4]], new Tag[零])
  i(new Tag[负数4#加[正数2]], new Tag[负数2])
  i(new Tag[负数4#加[正数3]], new Tag[负数1])

  i(new Tag[正数3#加[正数[正数[零, Item4], Item5]]], new Tag[正数5])
  i(new Tag[负数3#加[负数2]], new Tag[负数5])

}
