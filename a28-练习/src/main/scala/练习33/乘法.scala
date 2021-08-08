package 练习33

case class Item(name: String) {
  override def toString: String = name
}

trait Result {
  def length: Int
}
case class ResultP(tail: Result, head: Item) extends Result {
  override def length: Int = tail.length + 1
}
case object ResultO extends Result {
  override def length: Int = 0
}

trait NumL {
  def methodR(num: NumR): Result
}
case class NumLP(tail: NumL, head: Item) extends NumL {
  override def methodR(num: NumR): Result = num.methodL(tail, head)
}
case object NumLO extends NumL {
  override def methodR(num: NumR): Result = ResultO
}

trait NumR {
  def methodL(num: NumL, item: Item): Result
}
case class 火(tail: NumR, head: Item) extends NumR {
  override def methodL(num: NumL, item: Item): Result = ResultP(tail.methodL(num, item), head)
}
trait 水 extends NumR {
  def tail: NumR
  override def methodL(num: NumL, item: Item): Result = num.methodR(tail)
}
object 水 {
  def apply(tail1: => NumR): NumR = new 水 {
    override def tail: NumR = tail1
  }
}
