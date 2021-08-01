package step1

case class Item(name: String)

trait Result {
  def length: Int
}
case class RP(tail: Result, head: Item) extends Result {
  override def length: Int = tail.length + 1
}
case object RO extends Result {
  override def length: Int = 0
}

trait NumL {
  var tail: NumL
  def methodR(num: NumR, item: Item): Result
}
trait NumR {
  def methodL(num: NumL): Result
}

trait 火 extends NumL {
  def head: Item
  override def methodR(num: NumR, item: Item): Result = RP(tail.methodR(num, item), head)
}
case class 左水(override var tail: NumL) extends NumL {
  override def methodR(num: NumR, item: Item): Result = num.methodL(tail)
}
case class 右水(tail: NumR, head: Item) extends NumR {
  override def methodL(num: NumL): Result = num.methodR(tail, head)
}
trait 风 extends NumR {
  val tail: () => NumR
  override def methodL(num: NumL): Result = tail().methodL(num)
}
