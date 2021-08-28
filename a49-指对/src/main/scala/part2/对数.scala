package part2

import part3.{NumL, NumR, Result, ResultO, ResultP, Utils}

case class 左零(override var tail: NumL, numR: NumR) extends NumL {
  override def methodR(num: NumR): Result = {
    if (tail eq null) ResultO
    else {
      Utils.appendLeft(tail, 左零(null, numR))
      ResultP(numR.methodL(tail))
    }
  }
}
