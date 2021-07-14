package step5

object Runner extends App {

  val itemX  = Item("ItemX")
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

  val number1 = 加法正(加法正(加法正(加法正(加法零, item01), item02), item03), item04)
  val number2 = 加法正(加法正(加法正(加法零, item05), item06), item07)
  val number3 = 加法正(加法正(加法正(加法正(加法零, item08), item09), item10), item11)
  val number4 = 加法正(加法零, item12)

  val l1 = 黑左正右正(number2, number1)

  println(Number.count(l1))
  // (((((((Zero, Item01), Item02), Item03), Item04), Item05), Item06), Item07)

  val l2 = 黑左树右正(黑左树右正(黑左正右正(number4, number3), number2), number1)

  println(Number.count(l2))
  // ((((((((((((Zero, Item01), Item02), Item03), Item04), Item05), Item06), Item07), Item08), Item09), Item10), Item11), Item12)

}
