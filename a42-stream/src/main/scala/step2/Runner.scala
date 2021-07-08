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
  // + 3
  val number2 = PlusNumberPositive(PlusNumberPositive(PlusNumberPositive(PlusNumberPositive(PlusNumberPositive(PlusNumberZero, item04), item05), item06), item07), item08)
  // + 5
  val number3 = PlusNumberPositive(PlusNumberPositive(PlusNumberPositive(PlusNumberPositive(PlusNumberZero, item09), item10), item11), item12)
  // + 4
  val number4 = MinusNumberPositive(MinusNumberPositive(MinusNumberPositive(MinusNumberZero)))
  // - 3
  val number5 = MinusNumberPositive(MinusNumberPositive(MinusNumberPositive(MinusNumberPositive(MinusNumberPositive(MinusNumberZero)))))
  // - 5
  val number6 = MinusNumberPositive(MinusNumberPositive(MinusNumberPositive(MinusNumberPositive(MinusNumberZero))))
  // - 4

  val count1 = 被动消耗Positive(被动消耗Positive(被动消耗Positive(被动消耗Zero, number1), number2), number3)
  // 3 + 5 + 4 = 12

  println(count1.向左计算)
  // ((((((((((((Zero, Item(Item01)), Item(Item02)), Item(Item03)), Item(Item04)), Item(Item05)), Item(Item06)), Item(Item07)), Item(Item08)), Item(Item09)), Item(Item10)), Item(Item11)), Item(Item12))

  val count2 = 被动消耗Positive(被动消耗Positive(被动消耗Positive(被动消耗Positive(被动消耗Zero, number1), number2), number3), number4)
  // 3 + 5 + 4 - 3 = 9

  println(count2.向左计算)
  // (((((((((Zero, Item(Item01)), Item(Item02)), Item(Item03)), Item(Item04)), Item(Item05)), Item(Item06)), Item(Item07)), Item(Item08)), Item(Item09))

  val count3 = 被动消耗Positive(被动消耗Positive(被动消耗Positive(被动消耗Zero, number1), 被动消耗Positive(被动消耗Positive(被动消耗Zero, number2), number4)), number3)
  // 3 + (5 - 3) + 4 = 9

  println(count3.向左计算)
  // (((((((((Zero, Item(Item01)), Item(Item02)), Item(Item03)), Item(Item04)), Item(Item05)), Item(Item09)), Item(Item10)), Item(Item11)), Item(Item12))

  val count4 = 被动消耗Positive(被动消耗Positive(被动消耗Positive(被动消耗Positive(被动消耗Zero, number1), 被动消耗Positive(被动消耗Positive(被动消耗Zero, number2), number4)), number3), number5)
  // 3 + (5 - 3) + 4 - 5 = 4

  println(count4.向左计算)
  // ((((Zero, Item(Item01)), Item(Item02)), Item(Item03)), Item(Item04))

  val count5 = 被动消耗Positive(
    被动消耗Positive(被动消耗Positive(被动消耗Zero, number1), 被动消耗Positive(被动消耗Positive(被动消耗Zero, number2), number4)),
    被动消耗Positive(被动消耗Positive(被动消耗Zero, number3), number6)
  )
  // 3 + (5 - 3) + (4 - 4) = 5

  println(count5.向左计算)
  // (((((Zero, Item(Item01)), Item(Item02)), Item(Item03)), Item(Item04)), Item(Item05))

  val count6 = 被动消耗Positive(
    被动消耗Positive(被动消耗Positive(被动消耗Zero, number1), 被动消耗Positive(被动消耗Positive(被动消耗Zero, number2), number4)),
    被动消耗Positive(被动消耗Positive(被动消耗Zero, number3), number4)
  )
  // 3 + (5 - 3) + (4 - 3) = 5

  println(count6.向左计算)
  // (((((((Zero, Item(Item01)), Item(Item02)), Item(Item03)), Item(Item04)), Item(Item05)), Item(Item09))

}
