package step2

object Runner extends App {

  val item01 = Item("Item01")
  val item02 = Item("Item02")
  val item03 = Item("Item03")
  val item04 = Item("Item04")
  val item05 = Item("Item05")
  val item06 = Item("Item06")
  val item07 = Item("Item07")
  val item08 = Item("Item08")
  val item09 = Item("Item09")
  val item10 = Item("Item10")
  val item11 = Item("Item11")
  val item12 = Item("Item12")

  val number1 = PlusNumberPositive(PlusNumberPositive(PlusNumberPositive(PlusNumberZero, item01), item02), item03)
  val number2 = PlusNumberPositive(PlusNumberPositive(PlusNumberPositive(PlusNumberPositive(PlusNumberPositive(PlusNumberZero, item04), item05), item06), item07), item08)
  val number3 = MinusNumberPositive(MinusNumberPositive(MinusNumberPositive(MinusNumberZero)))
  println(number1.相冲(number2))
  println(number2.交缠(number3))

}
