package a19.step1

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
class Item30
class Item31
class Item32
class Item33
class Item34
class Item35
class Item36

object 测试 {

  type jihjkhjih       = I_0[Item1, Item2, Item3, S_0[Item4]]
  type nlhnjsnroewrnwe = jihjkhjih#N[Item5]#N[Item6]#N[Item7]#N[Item8]#N[Item9]
  type dfgdfgereter    = nlhnjsnroewrnwe#N[Item10]#N[Item11]#N[Item12]

  类型匹配(类型匹配[nlhnjsnroewrnwe#_2_th], 类型匹配[Item3])

  类型匹配(类型匹配[nlhnjsnroewrnwe#_0#_2_th], 类型匹配[Item6])
  类型匹配(类型匹配[dfgdfgereter#_2#_1_th], 类型匹配[Item11])

  /*类型匹配(类型匹配[进位#_2#_3#_3#Up#Up#Up], 类型匹配[进位#_2#_3#_6])
  类型匹配(类型匹配[进位#_1#_2#_4#_4#Up#Up#Up], 类型匹配[进位#_1#_2#_4#_7])*/

  def main(arr: Array[String]): Unit = {
    println("22")
  }
}
