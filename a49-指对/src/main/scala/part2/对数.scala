package part2

import scala.annotation.tailrec

case class Item(name: String)

object Utils {
  @tailrec
  final def appendLeft(num: NumL, toAppend: NumL): Unit =
    if (num.tail eq null)
      num.tail = toAppend
    else
      appendLeft(num.tail, toAppend)
}

trait Result {
  def length: Int
}
case class ResultP(tail: Result) extends Result {
  override def length: Int = tail.length + 1
}
case object ResultO extends Result {
  override def length: Int = 0
}

trait NumL {
  var tail: NumL
  def methodR(num: NumR): Result
}
case class 左正(override var tail: NumL) extends NumL {
  override def methodR(num: NumR): Result = num.methodL(tail)
}
case class 左零(override var tail: NumL, numR: NumR) extends NumL {
  override def methodR(num: NumR): Result = {
    if (tail eq null) ResultO
    else {
      Utils.appendLeft(tail, 左零(null, numR))
      ResultP(numR.methodL(tail))
    }
  }
}

trait NumR {
  def methodL(num: NumL): Result
}
case class 水(tail: NumR) extends NumR {
  override def methodL(num: NumL): Result = num.methodR(tail)
}
case class 风(tail: () => NumR) extends NumR {
  override def methodL(num: NumL): Result = {
    Utils.appendLeft(num, 左正(null))
    tail().methodL(num)
  }
}
