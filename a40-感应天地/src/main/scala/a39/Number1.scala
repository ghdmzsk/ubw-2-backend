package a39

case class Item(name: String)

trait Number1 {
  def method1(number2: Number2): Number3
}
case class Number1Positive(tail: Number1) extends Number1 {
  override def method1(number2: Number2): Number3 = number2.method2(tail, Number2Zero)
}
case object Number1Zero extends Number1 {
  override def method1(number2: Number2): Number3 = Number3Positive(Number3Zero)
}

trait Number2 {
  def method2(number1: Number1, number2: Number2): Number3
}
trait Number2Positive extends Number2 {
  def tail: Number2
  override def method2(number1: Number1, number2: Number2): Number3
}
case object Number2Zero extends Number2 {
  override def method2(number1: Number1, number2: Number2): Number3 = number1.method1(number2)
}

trait Number3 {
  def length: Int
}
case class Number3Positive(tail: Number3) extends Number3 {
  override def length: Int = tail.length + 1
}
case object Number3Zero extends Number3 {
  override def length: Int = 0
}
