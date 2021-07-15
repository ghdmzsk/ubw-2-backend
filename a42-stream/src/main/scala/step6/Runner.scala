package step6

object Runner {

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

  val number1 = Number1P(Number1P(Number1P(Number1P(Number1P(Nubmer1Zero, item01), item02), item03), item04), item05)
  val number2 = Number1P(Number1P(Number1P(Nubmer1Zero, item06), item07), item08)

  val btNumber = 双白树(left = number1, right = number2)

  def main(arr: Array[String]): Unit = {
    {
      val result1 = Number.count(btNumber, 加法)
      assert(
        result1 == ResultP(
          ResultP(ResultP(ResultP(ResultP(ResultP(ResultP(ResultP(ResultZero, item01), item02), item03), item04), item05), item06), item07),
          item08
        )
      )
    }

    {
      val result2 = Number.count(btNumber, 减法)
      assert(result2 == ResultP(ResultP(ResultZero, item01), item02))
    }
  }

}
