package 对数.step1

object Runner {

  class 类型匹配[T]
  object 类型匹配 {
    def apply[T1, T2]: (类型匹配[T1], 类型匹配[T2])            = (new 类型匹配[T1], new 类型匹配[T2])
    def apply[T](i: (类型匹配[T], 类型匹配[T])): List[类型匹配[T]] = List(i._1, i._2)
  }

  class 底数1    extends 底数Positive[底数1, 底数One1]
  class 底数One1 extends 底数One[底数1]

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
  class Item18
  class Item19
  class Item20
  class Item21
  class Item22
  class Item23
  class Item24
  class Item25
  class Item26
  class Item27
  class Item28
  class Item29

  type 真数0  = 真数Zero
  type 对数值0 = 对数特殊负无穷
  类型匹配(类型匹配[真数0#对[底数1], 对数值0])

  type 真数1  = 真数Positive[真数Zero, Item1]
  type 对数值1 = 对数Zero
  类型匹配(类型匹配[真数1#对[底数1], 对数值1])

  type 真数2  = 真数Positive[真数1, Item2]
  type 对数值2 = 对数1
  类型匹配(类型匹配[真数2#对[底数1], 对数值2])

  type 真数3  = 真数Positive[真数2, Item3]
  type 对数值3 = 对数1
  类型匹配(类型匹配[真数3#对[底数1], 对数值3])

  type 真数4  = 真数Positive[真数3, Item4]
  type 对数值4 = 对数Positive[对数1]
  类型匹配(类型匹配[真数4#对[底数1], 对数值4])

  type 真数5  = 真数Positive[真数4, Item5]
  type 对数值5 = 对数Positive[对数1]
  类型匹配(类型匹配[真数5#对[底数1], 对数值5])

  type 真数6  = 真数Positive[真数5, Item6]
  type 对数值6 = 对数Positive[对数1]
  类型匹配(类型匹配[真数6#对[底数1], 对数值6])

  type 真数7  = 真数Positive[真数6, Item7]
  type 对数值7 = 对数Positive[对数1]
  类型匹配(类型匹配[真数7#对[底数1], 对数值7])

  type 真数8  = 真数Positive[真数7, Item8]
  type 对数值8 = 对数Positive[对数Positive[对数1]]
  类型匹配(类型匹配[真数8#对[底数1], 对数值8])

  type 真数9  = 真数Positive[真数8, Item9]
  type 对数值9 = 对数Positive[对数Positive[对数1]]
  类型匹配(类型匹配[真数9#对[底数1], 对数值9])

  type 真数10  = 真数Positive[真数9, Item10]
  type 对数值10 = 对数Positive[对数Positive[对数1]]
  类型匹配(类型匹配[真数10#对[底数1], 对数值10])

  type 真数11  = 真数Positive[真数10, Item11]
  type 对数值11 = 对数Positive[对数Positive[对数1]]
  类型匹配(类型匹配[真数11#对[底数1], 对数值11])

  type 真数12  = 真数Positive[真数11, Item12]
  type 对数值12 = 对数Positive[对数Positive[对数1]]
  类型匹配(类型匹配[真数12#对[底数1], 对数值12])

  type 真数13  = 真数Positive[真数12, Item13]
  type 对数值13 = 对数Positive[对数Positive[对数1]]
  类型匹配(类型匹配[真数13#对[底数1], 对数值13])

  type 真数14  = 真数Positive[真数13, Item14]
  type 对数值14 = 对数Positive[对数Positive[对数1]]
  类型匹配(类型匹配[真数14#对[底数1], 对数值14])

  type 真数15  = 真数Positive[真数14, Item15]
  type 对数值15 = 对数Positive[对数Positive[对数1]]
  类型匹配(类型匹配[真数15#对[底数1], 对数值15])

  type 真数16  = 真数Positive[真数15, Item16]
  type 对数值16 = 对数Positive[对数Positive[对数Positive[对数1]]]
  类型匹配(类型匹配[真数16#对[底数1], 对数值16])

  type 真数17  = 真数Positive[真数16, Item17]
  type 对数值17 = 对数Positive[对数Positive[对数Positive[对数1]]]
  类型匹配(类型匹配[真数17#对[底数1], 对数值17])

  type 真数18 = 真数Positive[真数17, Item18]
  type 真数19 = 真数Positive[真数18, Item19]
  type 真数20 = 真数Positive[真数19, Item20]
  type 真数21 = 真数Positive[真数20, Item21]
  type 真数22 = 真数Positive[真数21, Item22]
  type 真数23 = 真数Positive[真数22, Item23]
  type 真数24 = 真数Positive[真数23, Item24]
  type 真数25 = 真数Positive[真数24, Item25]
  type 真数26 = 真数Positive[真数25, Item26]
  type 真数27 = 真数Positive[真数26, Item27]
  type 真数28 = 真数Positive[真数27, Item28]
  type 真数29 = 真数Positive[真数28, Item29]

  class 底数2    extends 底数Positive[底数2, 底数Positive[底数2, 底数One2]]
  class 底数One2 extends 底数One[底数2]

  type 对数值18 = 对数Zero
  类型匹配(类型匹配[真数1#对[底数2], 对数值18])
  类型匹配(类型匹配[真数2#对[底数2], 对数值18])

  type 对数值19 = 对数1
  类型匹配(类型匹配[真数3#对[底数2], 对数值19])
  类型匹配(类型匹配[真数4#对[底数2], 对数值19])
  类型匹配(类型匹配[真数8#对[底数2], 对数值19])

  type 对数值20 = 对数Positive[对数1]
  类型匹配(类型匹配[真数9#对[底数2], 对数值20])
  类型匹配(类型匹配[真数10#对[底数2], 对数值20])
  类型匹配(类型匹配[真数26#对[底数2], 对数值20])

  type 对数值21 = 对数Positive[对数Positive[对数1]]
  类型匹配(类型匹配[真数27#对[底数2], 对数值21])
  类型匹配(类型匹配[真数28#对[底数2], 对数值21])
  类型匹配(类型匹配[真数29#对[底数2], 对数值21])

}
