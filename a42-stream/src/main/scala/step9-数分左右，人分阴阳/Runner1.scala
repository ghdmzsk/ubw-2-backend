package step9

object Runner1 {

  val itemX   = Item("ItemX")
  val minus03 = Item("Minus03")
  val minus02 = Item("Minus02")
  val minus01 = Item("Minus01")
  val minus00 = Item("Minus00")
  val item01  = Item("Item01")
  val item02  = Item("Item02")
  val item03  = Item("Item03")
  val item04  = Item("Item04")
  val item05  = Item("Item05")
  val item06  = Item("Item06")
  val item07  = Item("Item07")
  val item08  = Item("Item08")
  val item09  = Item("Item09")
  val item10  = Item("Item10")
  val item11  = Item("Item11")
  val item12  = Item("Item12")

  def main(arr: Array[String]): Unit = {
    val number1 = 被加数P(被加数P(被加数P(被加数P(被加数P(被加数P(被加数O, item01), item02), item03), item04), item05), item06)
    val number2 = 加数P(加数P(加数P(加数P(加数P(加数P(加数O, item07), item08), item09), item10), item11), item12)
    println(number2.countLP(number1))
  }

}
