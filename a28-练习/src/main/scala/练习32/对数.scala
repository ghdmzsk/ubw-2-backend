package 练习32

case class Item(name: String) {
  override def toString: String = name
}

trait Result {
  def length: Int
}
case class ResultP(tail: Result, head: Item) extends Result {
  override def length: Int      = tail.length + 1
  override def toString: String = s"(${tail}, ${head})"
}
case object ResultO extends Result {
  override def length: Int      = 0
  override def toString: String = "zero"
}

trait NumL {
  var tail: NumL
  def methodR(num: NumR): Result
}

trait NumR {
  def methodL(num: NumL, item: Item): Result
}
case class 水(tail: NumR, head: Item) extends NumR {
  override def methodL(num: NumL, item: Item): Result = num.methodR(tail)
}
trait 风 extends NumR {
  def tail: NumR
  override def methodL(num: NumL, item: Item): Result = tail.methodL(num, item)
}
object 风 {
  def apply(tail1: => NumR): NumR = new 风 {
    override def tail: NumR = tail1
  }
}
