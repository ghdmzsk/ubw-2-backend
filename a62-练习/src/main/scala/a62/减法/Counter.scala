package a62.减法

// 跟加法类似，结果也是第一个运算数
trait Number1 {
  def method1(number2: Number2): Number1
}
case class Number1S(tail: Number1) extends Number1 {
  override def method1(number2: Number2): Number1 = number2.method2(tail)
}
case object Number1T extends Number1 {
  override def method1(number2: Number2): Number1 = Number1T
}

trait Number2 {
  def method2(number1: Number1): Number1
}
case class Number2S(tail: Number2) extends Number2 {
  override def method2(number1: Number1): Number1 = number1.method1(tail)
}
case object Number2T extends Number2 {
  override def method2(number1: Number1): Number1 = number1
}
