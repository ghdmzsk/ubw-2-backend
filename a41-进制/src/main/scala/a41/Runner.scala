package a41

object Runner {

  val item01 = Item("item01")
  val item02 = Item("item02")
  val item03 = Item("item03")
  val item04 = Item("item04")
  val item05 = Item("item05")
  val item06 = Item("item06")
  val item07 = Item("item07")
  val item08 = Item("item08")
  val item09 = Item("item09")
  val item10 = Item("item10")
  val item11 = Item("item11")
  val item12 = Item("item12")
  val item13 = Item("item13")
  val item14 = Item("item14")
  val item15 = Item("item15")
  val item16 = Item("item16")
  val item17 = Item("item17")
  val item18 = Item("item18")
  val item19 = Item("item19")
  val item20 = Item("item20")

  val number1 = Number1PSimple0.method1(item01).method1(item02).method1(item03).method1(item04).method1(item05).method1(item06)
  val number2 = number1.method1(item07) // .method1(item08).method1(item09).method1(item10).method1(item11).method1(item12)

  def main(arr: Array[String]): Unit = {
    println(number2)
    assert(number1(_1_th) == item01)
    assert(number1(_2_th) == item02)
    assert(number1(_1._0_th) == item03)
    assert(number1(_1._1_th) == item04)
    assert(number1(_1._2_th) == item05)
    assert(number1(_2._0_th) == item06)
    assert(number2(_2._1_th) == item07)
  }

}
