package a39

object Runner {

  val item01 = Item("item01")
  val item02 = Item("item02")
  val item03 = Item("item03")
  val item04 = Item("item04")
  val item05 = Item("item05")
  val item06 = Item("item06")
  val item07 = Item("item07")
  val item08 = Item("item08")
  val item09 = Item("item09")
  val item10 = Item("item10")

  case class Number2Item1(override val tail: Number2) extends Number2Positive {
    override def method2(number1: Number1, number2: Number2): Number3 = Number3Positive(
      tail.method2(number1, Number2Item1(Number2Item1(Number2Item1(Number2Item1(number2)))))
    )
  }

  val number1_1 = Number1Positive(Number1Zero)
  val number1_2 = Number1Positive(Number1Positive(Number1Zero))
  val number1_3 = Number1Positive(Number1Positive(Number1Positive(Number1Zero)))
  val number1_4 = Number1Positive(Number1Positive(Number1Positive(Number1Positive(Number1Zero))))
  val number1_5 = Number1Positive(Number1Positive(Number1Positive(Number1Positive(Number1Positive(Number1Zero)))))
  val number2   = Number2Item1(Number2Item1(Number2Item1(Number2Zero)))

  def main(arr: Array[String]): Unit = {
    println(number1_1.method1(number2).length)
    println(number1_2.method1(number2).length)
    println(number1_3.method1(number2).length)
    println(number1_4.method1(number2).length)
    println(number1_5.method1(number2).length)
  }

}
