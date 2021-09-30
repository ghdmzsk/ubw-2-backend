package a62.乘法

trait Number1 {
  def method1(number2: Number2): Num
}
case class Number1S(tail: Number1) extends Number1 {
  override def method1(number2: Number2): Num = number2.method2(tail)
}
case object Number1T extends Number1 {
  override def method1(number2: Number2): Num = NumT
}

trait Number2 {
  def method2(number1: Number1): Num
}
case class Number2S(tail: Number2) extends Number2 {
  override def method2(number1: Number1): Num = NumS(tail.method2(number1))
}
case class Number2T(tail: () => Number2) extends Number2 {
  override def method2(number1: Number1): Num = number1.method1(tail())
}

trait Num
case class NumS(tail: Num) extends Num
case object NumT           extends Num
