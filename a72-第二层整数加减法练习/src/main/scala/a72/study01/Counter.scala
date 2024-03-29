package a72.study01

trait Number1 {
  def method1(number2: Number2): Number2
}
case class Number1S(tail: Number1, head: Number2) extends Number1 {
  def method1(number2: Number2): Number2 = Number2S(number2, head.method2(tail))
}
case object Number1T extends Number1 {
  def method1(number2: Number2): Number2 = number2
}

trait Number2 {
  def method2(number1: Number1): Number1
}
case class Number2S(tail: Number2, head: Number1) extends Number2 {
  def method2(number1: Number1): Number1 = Number1S(number1, head.method1(tail))
}
case object Number2T extends Number2 {
  def method2(number1: Number1): Number1 = Number1S(Number1S(number1, Number2T), Number2T)
}
