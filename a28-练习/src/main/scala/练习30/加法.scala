package 练习30

case class Item(name: String) {
  override def toString: String = name
}

trait Result
case class ResultP(tail: Result, head: Item) extends Result {
  println("result: " + head)
  override def toString: String = s"($tail, $head)"
}
case object ResultO extends Result {
  println("result: " + this)
  override def toString: String = s"zero"
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
  def tail: NumR
  def methodL(num: NumL, item: Item): Result
}
case class NumRP(override val tail: NumR, head: Item) extends NumR {
  override def methodL(num: NumL, item: Item): Result = {
    println("method: " + head)
    ResultP(tail.methodL(num, item), head)
  }
}
trait NumRO extends NumR {
  override def methodL(num: NumL, item: Item): Result = ResultP(num.methodR(tail), item)
}
object NumRO {
  val value: NumRO = new NumRO {
    override def tail: NumR = value
  }
}
