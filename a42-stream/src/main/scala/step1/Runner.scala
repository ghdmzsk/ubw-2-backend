package step1

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

  val number1 = FirstNumberPositive(FirstNumberPositive(FirstNumberPositive(FirstNumberZero, item01), item02), item03)
  val number2 = PlusNumberPositive(PlusNumberPositive(PlusNumberPositive(PlusNumberPositive(PlusNumberZero, item04), item05), item06), item07)
  val number3 = PlusNumberPositive(PlusNumberPositive(PlusNumberZero, item08), item09)
  val number4 = PlusNumberPositive(PlusNumberZero, item10)
  val number5 = PlusNumberPositive(PlusNumberPositive(PlusNumberZero, item11), item12)

  val count = ReverseStreamPositive(
    ReverseStreamPositive(ReverseStreamPositive(ReverseStreamPositive(ReverseStreamPositive(ReverseStreamZero, number1), number2), number3), number4),
    number5
  )

  println(count.run)

}
