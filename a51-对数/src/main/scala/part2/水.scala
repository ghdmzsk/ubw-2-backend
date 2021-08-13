package part2

import part1.Queue

trait 水 extends NumR {
  def tail: NumR
  override def methodL(num: Queue): Result = Queue.merge(num, tail)
}
object 水 {
  def apply(tail1: => NumR): NumR = new 水 {
    override def tail: NumR = tail1
  }
}
