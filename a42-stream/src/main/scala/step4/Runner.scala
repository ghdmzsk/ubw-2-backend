package step4

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

  val number1 = PlusNumberPositive(PlusNumberPositive(PlusNumberPositive(PlusNumberZero, item01), item02), item03)
  // + 3
  val number2 = PlusNumberPositive(PlusNumberPositive(PlusNumberPositive(PlusNumberPositive(PlusNumberPositive(PlusNumberZero, item04), item05), item06), item07), item08)
  // + 5
  val number3 = PlusNumberPositive(PlusNumberPositive(PlusNumberPositive(PlusNumberPositive(PlusNumberZero, item09), item10), item11), item12)
  // + 4
  val number4 = MinusNumberPositive(MinusNumberPositive(MinusNumberPositive(MinusNumberZero, itemX), itemX), itemX)
  // - 3
  val number5 =
    MinusNumberPositive(MinusNumberPositive(MinusNumberPositive(MinusNumberPositive(MinusNumberPositive(MinusNumberZero, itemX), itemX), itemX), itemX), itemX)
  // - 5
  val number6 = MinusNumberPositive(MinusNumberPositive(MinusNumberPositive(MinusNumberPositive(MinusNumberZero, itemX), itemX), itemX), itemX)
  // - 4

  val count1 = 被动消耗正(被动消耗正(被动消耗正(被动消耗零, number1), number2), number3)
  // 3 + 5 + 4 = 12

  println(count1.向左无害计算)
  // ((((((((((((Zero, Item(Item01)), Item(Item02)), Item(Item03)), Item(Item04)), Item(Item05)), Item(Item06)), Item(Item07)), Item(Item08)), Item(Item09)), Item(Item10)), Item(Item11)), Item(Item12))

  val count2 = 被动消耗正(被动消耗正(被动消耗正(被动消耗正(被动消耗零, number1), number2), number3), number4)
  // 3 + 5 + 4 - 3 = 9

  println(count2.向左无害计算)
  // (((((((((Zero, Item(Item01)), Item(Item02)), Item(Item03)), Item(Item04)), Item(Item05)), Item(Item06)), Item(Item07)), Item(Item08)), Item(Item09))

  val count6 = 被动消耗正(被动消耗正(被动消耗正(被动消耗零, number1), number2), number5)
  // 3 + 5 - 5 = 3

  println(count6.向左无害计算)
  // (((((((Zero, Item(Item01)), Item(Item02)), Item(Item03)), Item(Item04)), Item(Item05)), Item(Item09))

}
