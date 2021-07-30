package step1

case class Item(name: String)

trait Result
case class ResultP(tail: Result, head: Item) extends Result {
  override def toString: String = s"(${tail}, ${head.name})"
}
case object ResultO extends Result {
  override def toString: String = "Zero"
}

trait NumL {
  var tail: NumL
  def methodR(num: NumR): Result
}
trait NumR {
  def methodL(num: NumL, item: Item): Result
}

case class 土(override var tail: NumL, head: Item) extends NumL {
  override def methodR(num: NumR): Result = ResultP(num.methodL(tail, head), head)
}
case class 左水(var tail: NumL, head: Item) extends NumL {
  override def methodR(num: NumR): Result = num.methodL(tail, head)
}
trait 零 extends NumL {
  override def methodR(num: NumR): Result = ResultO
}
case class 右水(tail: NumR) extends NumR {
  override def methodL(num: NumL, item: Item): Result = num.methodR(tail)
}
class 风(tail: () => NumR) extends NumR {
  override def methodL(num: NumL, item: Item): Result = tail().methodL(num, item)
}
