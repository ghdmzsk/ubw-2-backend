package a19.step7

class 类型匹配[T]

object 类型匹配 {
  def apply[T]                                              = new 类型匹配[T]
  def apply[T](i: 类型匹配[T], ii: 类型匹配[T]): (类型匹配[T], 类型匹配[T]) = (i, ii)
}

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

object 测试 {

  type i1 = P_3_Step_1[
    I_2_Step_0[S_2[Item1, Item1, Item1], S_2[Item1, Item1, Item1], S_2[Item1, Item1, Item1]],
    I_2_Step_0[S_2[Item1, Item1, Item1], S_2[Item1, Item1, Item1], S_2[Item1, Item1, Item1]]
  ]
  type i2 = i1#Next[Item1]#Next[Item2]#Next[Item3]#Next[Item4]#Next[Item5]#Next[Item6]#Next[Item7]#Next[Item8]#Next[Item9]
  type i3 = i2#Next[Item10]#Next[Item11]#Next[Item12]#Next[Item13]#Next[Item14]#Next[Item15]#Next[Item16]#Next[Item17]#Next[Item18]

  类型匹配(
    类型匹配[i3],
    类型匹配[P_3_Step_1[
      I_2_Step_0[S_2[Item1, Item2, Item3], S_2[Item7, Item8, Item9], S_2[Item13, Item14, Item15]],
      I_2_Step_0[S_2[Item4, Item5, Item6], S_2[Item10, Item11, Item12], S_2[Item16, Item17, Item18]]
    ]]
  )

  def main(arr: Array[String]): Unit = {
    println("22")
  }
}
