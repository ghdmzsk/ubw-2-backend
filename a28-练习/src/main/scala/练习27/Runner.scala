package 练习27

object Runner extends App {

  val item01 = Item("Item01")
  val item02 = Item("Item02")
  val item03 = Item("Item03")
  val item04 = Item("Item04")
  val item05 = Item("Item05")
  val item06 = Item("Item06")
  val item07 = Item("Item07")

  case class Num2P(override var tail: Number2, override val head: Item) extends Number2P {
    override def method2(number1: Number1, item: Item): Result = {
      val zero = Num2O2(null)
      val num  = Num2P(Num2P(Num2P(Num2P(Num2P(Num2P(zero, item01), item02), item03), item04), item05), item05)
      number0.tail = num
      number0 = zero
      super.method2(number1, item)
    }
  }

  case class Num2O1(override var tail: Number2) extends Number2O1 {
    override def method2(number1: Number1, item: Item): Result = {
      val zero = Num2O1(null)
      number0.tail = zero
      number0 = zero
      super.method2(number1, item)
    }
  }

  case class Num2O2(override var tail: Number2) extends Number2O2

  var number0: Number2 = null
  var number1: Number2 = null

  def reset: Unit = {
    number0 = Num2O1(null)
    number1 = Num2P(Num2P(Num2P(Num2P(Num2P(number0, item01), item02), item03), item04), item04)
  }

  val number2 = Number1P(Number1P(Number1P(Number1O, item01), item02), item03)
  val number3 = Number1P(Number1P(Number1P(Number1P(Number1O, item01), item02), item03), item04)

  reset
  println(ResultP(number2.method1(number1), item01).length) // 6 ^ 3 = 216
  reset
  println(ResultP(number3.method1(number1), item01).length) // 6 ^ 4 = 1296

}
