package 练习30

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

  val number1 = NumLP(NumLP(NumLP(NumLP(NumLO, item01), item02), item03), item04)
  val number2 = NumRP(NumRP(NumRP(NumRP(NumRP(NumRP(NumRO.value, item05), item06), item07), item08), item09), item10)

  println(number1.methodR(number2))

}
