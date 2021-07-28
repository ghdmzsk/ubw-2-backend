package 练习26

object Runner extends App {

  val item01 = Item("Item01")
  val item02 = Item("Item02")
  val item03 = Item("Item03")
  val item04 = Item("Item04")
  val item05 = Item("Item05")
  val item06 = Item("Item06")
  val item07 = Item("Item07")

  case class Number2P1(tail1: Number2, override val head: Item) extends Number2P {
    override def tail: Number2 = {
      val zero = new Number2O2
      val num  = Number2P1(Number2P1(Number2P1(Number2P1(Number2P1(zero, item01), item02), item03), item04), item05)
      number0.tail1 = num
      number0 = zero
      tail1
    }
  }
  case class Number2O11(override var tail1: Number2) extends Number2O1 {
    override def tail: Number2 = {
      val zero = Number2O11(null)
      number0.tail1 = zero
      number0 = zero
      tail1
    }
  }

  var number0: Number3 = null
  var number1: Number2 = null

  def reset: Unit = {
    number0 = Number2O11(null)
    number1 = Number2P1(Number2P1(Number2P1(Number2P1(number0, item01), item02), item03), item04)
  }

  val number2 = Number1P(Number1P(Number1P(Number1O, item01), item02), item03)
  val number3 = Number1P(Number1P(Number1P(Number1P(Number1P(Number1P(Number1O, item01), item02), item03), item04), item05), item06)

  reset
  println(ResultP(number2.method1(number1), item01).length) // 5 ^ 3 = 125
  reset
  println(ResultP(number3.method1(number1), item01).length) // 5 ^ 6 = 15625

}
