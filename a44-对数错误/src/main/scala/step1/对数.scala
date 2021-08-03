package step1

case class Item(name: String)

trait Result {
  def length: Int
}
case class ResultP(tail: Result, head: Item) extends Result {
  override def length: Int      = tail.length + 1
  override def toString: String = s"(${tail}, ${head.name})"
}
case object ResultO extends Result {
  override def length: Int      = 0
  override def toString: String = "Zero"
}

trait NumL {
  var tail: NumL
  def methodR(num: NumR): Result
}
trait NumR {
  def methodL(num: NumL, item: Item): Result
}

trait 火 extends NumL {
  def head: Item
  override def methodR(num: NumR): Result = ResultP(tail.methodR(num), head)
}
case class 左水(var tail: NumL, head: Item) extends NumL {
  override def methodR(num: NumR): Result = num.methodL(tail, head)
}
case class 右水(tail: NumR) extends NumR {
  override def methodL(num: NumL, item: Item): Result = {
    // println(s"右水：${num}")
    num.methodR(tail)
  }
}
class 风(tail: () => NumR) extends NumR {
  override def methodL(num: NumL, item: Item): Result = {
    // println(s"右风：${num}")
    tail().methodL(num, item)
  }
}
