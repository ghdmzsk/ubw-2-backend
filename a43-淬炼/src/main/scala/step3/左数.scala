package step3

case class Item(name: String)

trait Result
case class ResultP(tail: Result, head: Item) extends Result {
  override def toString: String = s"(${tail}, ${head.name})"
}
case object ResultO extends Result {
  override def toString: String = "Zero"
}

/** 左数，被加数，被减数，被乘数，被除数
  */
trait NumL {
  def methodR(num: NumR): Result
}

/** 右数，加数，减数，乘数，除数
  */
trait NumR {
  def methodL(num: NumL, item: Item): Result
}

case class 左数有(tail: NumL, head: Item) extends NumL {
  override def methodR(num: NumR): Result = num.methodL(tail, head)
}
case object 左数零 extends NumL {
  override def methodR(num: NumR): Result = ResultO
}
