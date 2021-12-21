package a72.study04

trait Number1 {
  def method1(number1: Number1): Number1
  def method2(number1: Number1): Number1
}
case class Number1S(tail: () => Number1) extends Number1 {
  override def method1(number1: Number1): Number1 = number1.method1(tail())
  override def method2(number1: Number1): Number1 = Number1S(() => tail().method2(number1))
  override def toString: String                   = s"Number1S(${tail().toString})"
}
case object Number1T extends Number1 {
  override def method1(number1: Number1): Number1 = number1
  override def method2(number1: Number1): Number1 = number1
  override def toString: String                   = "Number1T"
}
case object Number1U extends Number1 {
  override def method1(number1: Number1): Number1 = Number1U
  override def method2(number1: Number1): Number1 = number1
  override def toString: String                   = "Number1T"
}

object Counter {
  def counter1(number1: () => Number1, number2: () => Number1, number3: () => Number1): Number1 = {
    number1() match {
      case s: Number1S => Number1S(() => counter1(() => number3().method1(s), () => number2().method2(number3()), number2))
      case Number1T    => Number1T
      case Number1U    => Number1U
    }
  }

  def counter2(number1: () => Number1, number2: () => Number1, number3: () => Number1): Number1 = {
    counter2(number1, () => number2().method2(number3()), number2)
  }

}
