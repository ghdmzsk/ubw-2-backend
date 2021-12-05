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

  class 除数值1[T1] extends 除数1[除数值1, T1]

  type 被除数值1 = 被除数Positive[
    被除数Positive[
      被除数Positive[被除数Positive[被除数Positive[被除数Positive[被除数Positive[被除数Positive[被除数Zero, Item1], Item2], Item3], Item4], Item5], Item6],
      Item7
    ],
    Item8
  ]
  type 商1 = 商Positive[商Positive[商Positive[商Positive[商Positive[商Positive[商Positive[商Positive[商Zero]]]]]]]]

  class 除数值2[T1]
      extends 除数Positive[
        ({ type I1[N1] = 除数Positive[({ type I2[N2] = 除数Positive[({ type I3[N3] = 除数Positive[除数值3, N3] })#I3, N2] })#I2, N1] })#I1,
        T1
      ]
  class 除数值3[T1] extends 除数1[除数值2, T1]
  type 商2 = 商Positive[商Zero]

  class 除数值4[T1] extends 除数Positive[({ type I1[N1] = 除数Positive[({ type I2[N2] = 除数Positive[除数值5, N2] })#I2, N1] })#I1, T1]
  class 除数值5[T1] extends 除数1[除数值4, T1]
  type 商3 = 商Positive[商Positive[商Zero]]

  class 除数值6[T1] extends 除数Positive[({ type I1[N1] = 除数Positive[除数值7, N1] })#I1, T1]
  class 除数值7[T1] extends 除数1[除数值6, T1]
  type 商4 = 商Positive[商Positive[商Zero]]

  class 除数值8[T1] extends 除数Positive[除数值9, T1]
  class 除数值9[T1] extends 除数1[除数值8, T1]
  type 商5 = 商Positive[商Positive[商Positive[商Positive[商Zero]]]]

  i(new Tag[被除数值1#被除[除数值1]], new Tag[商1])
  i(new Tag[被除数值1#被除[除数值2]], new Tag[商2])
  i(new Tag[被除数值1#被除[除数值4]], new Tag[商3])
  i(new Tag[被除数值1#被除[除数值6]], new Tag[商4])
  i(new Tag[被除数值1#被除[除数值8]], new Tag[商5])
}
