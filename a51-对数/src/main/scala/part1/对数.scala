package part1

import part2.{NumL, NumLO, NumLP, NumR, Result, ResultO, ResultP}

class Queue(num: Vector[NumL]) {
  def tail: (Queue, NumL, NumL) = (new Queue(num.drop(1)), num.head, num.last)
  def insert(numL: NumL): Queue = new Queue(num.appended(numL))
}

object Queue {
  def apply(list: NumL*): Queue = new Queue(Vector.from(list))

  def merge(queue: Queue, num: NumR): Result = queue.tail match {
    case (tailQueue, NumLP, NumLP)       => num.methodL(tailQueue)
    case (tailQueue, NumLP, NumLO(_))    => num.methodL(tailQueue)
    case (tailQueue, NumLO(_), NumLO(_)) => ResultO
    case (tailQueue, NumLO(numR1), NumLP) =>
      val newQueue = tailQueue.insert(NumLO(numR1))
      ResultP(numR1.methodL(newQueue))
  }
}
