package part2

import part3.{左终结, NumL, NumR, Result, ResultO, ResultP}

case class 左零(tail: NumL, numR: NumR) extends NumL {
  override def 入队(num: NumL): NumL = 左零(tail.入队(num), numR)
  override def methodR(num: NumR): Result = tail match {
    case a @ 左终结 => ResultO                                    // 当前元素是队列最后一个元素，他的 tail 是左终结
    case b       => ResultP(numR.methodL(b.入队(左零(左终结, numR)))) // 当前元素后面还有元素
    // 土 + 风
  }
}
