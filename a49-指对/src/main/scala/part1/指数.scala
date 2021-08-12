package part1

import part3.{左正, NumL, NumR, Result, ResultO, Utils}

import scala.annotation.tailrec

case class 左零(override var tail: NumL, numR: NumR) extends NumL {
  @tailrec
  final def last(num: NumL): NumL = if (num.tail eq null) num else last(num.tail)

  override def methodR(num: NumR): Result = {
    if (tail.isInstanceOf[左零]) {
      Utils.appendLeft(tail, 左零(null, numR))
      tail.methodR(num)
    } else if (last(tail).isInstanceOf[左正]) {
      Utils.appendLeft(tail, new 左终结)
      tail.methodR(numR)
    } else tail.methodR(num)
  }
}

class 左终结 extends NumL {
  override var tail: NumL                 = null
  override def methodR(num: NumR): Result = ResultO
}
