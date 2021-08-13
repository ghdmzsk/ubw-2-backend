package part1

import part2.NumL

trait Queue {
  self =>

  val num: Vector[NumL]
  val reverse: Vector[NumL]

  def tail: (Queue, NumL, NumL) = (
    new Queue {
      override val num: Vector[NumL]     = self.num.drop(1)
      override val reverse: Vector[NumL] = self.reverse.dropRight(1)
    },
    num.head,
    reverse.head
  )

  def insert(numL: NumL): Queue = new Queue {
    override val num: Vector[NumL]     = self.num.appended(numL)
    override val reverse: Vector[NumL] = numL +: self.reverse
  }

}

object Queue {
  def apply(list: NumL*): Queue = new Queue {
    override val num: Vector[NumL]     = Vector.from(list)
    override val reverse: Vector[NumL] = num.reverse
  }
}
