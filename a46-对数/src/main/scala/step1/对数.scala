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

case class 水(tail: NumR) extends NumR {
  override def methodL(num: NumL, item: Item): Result = num.methodR(tail)
}
case class 风(tail: () => NumR) extends NumR {
  override def methodL(num: NumL, item: Item): Result = tail().methodL(num, item)
}
