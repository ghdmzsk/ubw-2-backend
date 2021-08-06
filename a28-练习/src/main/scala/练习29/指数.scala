package 练习29

case class Item(name: String)

trait Result {
  def length: Int
}
case class ResultR(tail: Result, head: Item) extends Result {
  override def length: Int = tail.length + 1
}
case object ResultO extends Result {
  override def length: Int = 0
}

trait NumL {
  var tail: NumL
  def methodR(num: NumR): Result
}

trait NumR {
  def methodL(num: NumL): Result
}
trait 水 extends NumR {
  def tail: NumR
  override def methodL(num: NumL): Result = num.methodR(tail)
}
object 水 {
  def apply(tail1: NumR): NumR = new 水 {
    override def tail: NumR = tail1
  }
}
trait 风 extends NumR {
  def tail: NumR
  override def methodL(num: NumL): Result = tail.methodL(num)
}
object 风 {
  def apply(tail1: => NumR): NumR = new 风 {
    override def tail: NumR = tail1
  }
}
