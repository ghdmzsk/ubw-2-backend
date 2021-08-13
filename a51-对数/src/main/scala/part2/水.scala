package part2

import part1.Queue

trait 水 extends NumR {
  def tail: NumR
  override def methodL(num: Queue): Result = num.tail match {
    case (tailQueue, NumLP, NumLP)       => tail.methodL(tailQueue)
    case (tailQueue, NumLP, NumLO(_))    => tail.methodL(tailQueue)
    case (tailQueue, NumLO(_), NumLO(_)) => ResultO
    case (tailQueue, NumLO(numR1), NumLP) =>
      val newQueue = tailQueue.insert(NumLO(numR1))
      ResultP(numR1.methodL(newQueue))
  }
}
object 水 {
  def apply(tail1: => NumR): NumR = new 水 {
    override def tail: NumR = tail1
  }
}
