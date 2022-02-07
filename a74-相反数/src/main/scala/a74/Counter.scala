package a74

trait Number1 {
  def method1(number2: Number2): Number2
}
case class Number1S(tail: Number1, head: Number2) extends Number1 {
  override def method1(number2: Number2): Number2 = Number2S(number2, head.method2(tail))
}
case object Number1T extends Number1 {
  override def method1(number2: Number2): Number2 = number2
}

trait Number2 {
  def method2(number1: Number1): Number1
}
case class Number2S(tail: Number2, head: Number1) extends Number2 {
  override def method2(number1: Number1): Number1 = Number1S(number1, head.method1(tail))
}
case object Number2T extends Number2 {
  override def method2(number1: Number1): Number1 = Number1S(Number1S(number1, Number2T), Number2T)
}

trait Number3 {
  def method1(number2: Number4): Number4
}
case class Number3S(tail: Number3, head: Number4) extends Number3 {
  override def method1(number2: Number4): Number4 = Number4S(number2, head.method2(tail))
}
case object Number3T extends Number3 {
  override def method1(number2: Number4): Number4 = number2
}

trait Number4 {
  def method2(number1: Number3): Number3
}
case class Number4S(tail: Number4, head: Number3) extends Number4 {
  override def method2(number1: Number3): Number3 = Number3S(number1, head.method1(tail))
}
case object Number4T extends Number4 {
  override def method2(number1: Number3): Number3 = Number3S(Number3S(number1, Number4T), Number4T)
}
