package part1

import part3.{左正, 左终结, NumL, NumR, Result}

import scala.annotation.tailrec

case class 左零(tail: NumL, numR: NumR) extends NumL {
  override def 入队(num: NumL): NumL = 左零(tail.入队(num), numR)

  @tailrec
  final def last(num: NumL): NumL = num match {
    case a @ 左正(左终结)         => a
    case a @ (左零(左终结, numR)) => a
    case 左正(n)               => last(n)
    case 左零(n, numR)         => last(n)
  }

  override def methodR(num: NumR): Result = {
    if (tail.isInstanceOf[左零]) // 连续两个左零
      tail.入队(左零(左终结, numR)).methodR(num)
    else if (last(tail).isInstanceOf[左正]) // 前后都是左正，包着一个左零，到了出结果阶段
      tail.methodR(numR)
    else tail.methodR(num) // 有连续左零，到了最后一个左零
  }
}
