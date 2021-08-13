package part2

import part1.Queue

trait Result {
  def length: Int
}
case class ResultP(tail: Result) extends Result {
  override def length: Int = tail.length + 1
}
case object ResultO extends Result {
  override def length: Int = 0
}

trait NumL

case object NumLP            extends NumL
case class NumLO(numR: NumR) extends NumL

trait NumR {
  def methodL(num: Queue): Result
}
