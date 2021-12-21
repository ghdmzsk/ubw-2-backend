package 练习33

object Runner extends App {

  var i: Int = 1
  def item: Item = {
    val item1 = Item(s"Item${i}")
    i += 1
    item1
  }

  val number1 = NumLP(NumLP(NumLP(NumLP(NumLP(NumLP(NumLP(NumLP(NumLP(NumLO, item), item), item), item), item), item), item), item), item)
  lazy val number2: NumR =
    火(火(火(火(火(火(火(火(火(火(火(火(水(number2), item), item), item), item), item), item), item), item), item), item), item), item)
  println(number1.methodR(number2).length)

  lazy val number3: NumR =
    火(火(火(火(火(火(火(火(火(火(火(火(number4, item), item), item), item), item), item), item), item), item), item), item), item)
  lazy val number4: NumR = 水(number3)
  println(number4.methodL(number1, item).length)

  assert(number1.methodR(number2).length == 9 * 12)
  assert(number4.methodL(number1, item).length == 9 * 12)

}
