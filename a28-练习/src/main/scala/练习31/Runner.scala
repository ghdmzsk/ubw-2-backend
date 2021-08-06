package 练习31

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

  val number1 = ResultP(ResultP(ResultP(ResultP(ResultO, item01), item02), item03), item04)
  val number2 = PlusP(PlusP(PlusP(PlusP(PlusP(PlusP(PlusO, item05), item06), item07), item08), item09), item10)

  println("===============================================")

  println(number2.plus(number1))

  /** result: ResultO
    * result: Item01
    * result: Item02
    * result: Item03
    * result: Item04
    * ===============================================
    * method: Item10
    * method: Item09
    * method: Item08
    * method: Item07
    * method: Item06
    * method: Item05
    * result: Item05
    * result: Item06
    * result: Item07
    * result: Item08
    * result: Item09
    * result: Item10
    */

}
