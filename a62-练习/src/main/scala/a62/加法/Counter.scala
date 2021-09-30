package a62.加法

// 数据结构的开始，也是第一个运算数
trait Number1
case class Number1S(tail: Number1) extends Number1
case object Number1T               extends Number1

trait Number2 {
  def method1(number1: Number1): Number1
}
case class Number2S(tail: Number2) extends Number2 {
  override def method1(number1: Number1): Number1 = Number1S(tail.method1(number1))
}
case object Number2T extends Number2 {
  override def method1(number1: Number1): Number1 = number1
}
