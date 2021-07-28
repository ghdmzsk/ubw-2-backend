package 练习26

case class Item(name: String)

trait Number1 {
  def method1(number2: Number2): Result
}
case class Number1P(tail: Number1, head: Item) extends Number1 {
  override def method1(number2: Number2): Result = number2.method2(tail, head)
}
case object Number1O extends Number1 {
  override def method1(number2: Number2): Result = ResultO
}

trait Number2 {
  def method2(number1: Number1, item: Item): Result
}
trait Number3 extends Number2 {
  var tail1: Number2
}

trait Number2P extends Number2 {
  def tail: Number2
  def head: Item
  override def method2(number1: Number1, item: Item): Result = ResultP(tail.method2(number1, item), head)
}
trait Number2O1 extends Number3 {
  def tail: Number2
  override var tail1: Number2
  override def method2(number1: Number1, item: Item): Result = number1.method1(tail)
}
class Number2O2 extends Number3 {
  def tail: Number2                                          = tail1
  override var tail1: Number2                                = null
  override def method2(number1: Number1, item: Item): Result = tail.method2(number1, item)
}

trait Result {
  def length: Int
}
case class ResultP(tail: Result, item: Item) extends Result {
  override def length: Int = tail.length + 1
}
case object ResultO extends Result {
  override def length: Int = 0
}
