package a69.test01

trait Number1 {
  def method1(number2: Number2): (Number1, Int)
}
case class Number1S(tail: Number1) extends Number1 {
  override def method1(number2: Number2): (Number1, Int) = {
    val (result1, result2) = number2.method2(tail)
    (result1, result2 + 1)
  }
}
case object Number1T extends Number1 {
  override def method1(number2: Number2): (Number1, Int) = (Number1T, 0)
}

trait Number2 {
  def method2(number1: Number1): (Number1, Int)
}
case class Number2S(tail: () => Number2) extends Number2 {
  override def method2(number1: Number1): (Number1, Int) = {
    val (result1, result2) = tail().method2(number1)
    (Number1S(result1), result2 + 1)
  }
}
case class Number2T(tail: () => Number2) extends Number2 {
  override def method2(number1: Number1): (Number1, Int) = {
    val (result1, result2) = number1.method1(tail())
    (result1, result2 + 1)
  }
}
case object Number2U extends Number2 {
  override def method2(number1: Number1): (Number1, Int) = (number1, 0)
}
