package part2

import part1.Queue

trait 风 extends NumR {
  def tail: NumR
  override def methodL(num: Queue): Result = {
    val newQueue = num.insert(NumLP)
    tail.methodL(newQueue)
  }
}
object 风 {
  def apply(tail1: => NumR): NumR = new 风 {
    override def tail: NumR = tail1
  }
}
