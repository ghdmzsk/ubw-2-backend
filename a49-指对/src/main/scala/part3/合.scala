package part3

import scala.annotation.tailrec

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

trait NumR {
  def methodL(num: NumL): Result
}
