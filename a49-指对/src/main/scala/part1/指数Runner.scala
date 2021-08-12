package part1

import scala.annotation.tailrec

object 指数Runner extends App {

  @tailrec
  final def appendLeft(num: NumL, toAppend: NumL): Unit =
    if (num.tail eq null)
      num.tail = toAppend
    else
      appendLeft(num.tail, toAppend)

  @tailrec
  final def last(num: NumL): NumL = if (num.tail eq null) num else last(num.tail)

  case class 左零(override var tail: NumL) extends NumL {
    override def methodR(num: NumR): Result = {
      if (tail.isInstanceOf[左零]) {
        appendLeft(tail, 左零(null))
        tail.methodR(num)
      } else if (last(tail).isInstanceOf[左正]) {
        appendLeft(tail, 左终结)
        tail.methodR(num火)
      } else tail.methodR(num)
    }
  }

  case class 风(override val tail: NumR) extends NumR {
    override def methodL(num: NumL): Result = {
      appendLeft(num, 左正(null))
      tail.methodL(num)
    }
  }

  val numL            = 左零(左零(左零(左零(左正(null)))))
  lazy val numR: NumR = 风(风(风(numR1)))
  lazy val numR1      = 水(() => numR)
  lazy val num火: NumR = 火(火(火(num火1)))
  lazy val num火1      = 水(() => num火)

  println(numL.methodR(numR).length) // 81

}
