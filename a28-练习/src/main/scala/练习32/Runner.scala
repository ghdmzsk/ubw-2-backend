package 练习32

import java.math.MathContext

object Runner extends App {

  case class LongContext(number1: Int, number2: Int) {

    def winTran(n: Int, tail: => NumR): NumR = {
      n match {
        case n1 if n1 > 0 => 水(winTran(n1 - 1, tail), Item(s"Item$n1"))
        case 0            => 风(tail)
      }
    }
    def numLTran(n: Int): NumL = {
      n match {
        case n1 if n1 > 0 => NumLP(numLTran(n1 - 1), Item("Item01"))
        case 0 =>
          zero = NumLO(null)
          zero
      }
    }

    lazy val numR: NumR = winTran(number1, numR)
    var zero: NumL      = null
    val numL            = numLTran(number2)

    case class NumLP(override var tail: NumL, head: Item) extends NumL {
      override def methodR(num: NumR): Result = {
        if (num.isInstanceOf[风]) {
          val newZero = NumLP(null, head)
          zero.tail = newZero
          zero = newZero
        }
        num.methodL(tail, head)
      }
    }

    case class NumLO(override var tail: NumL) extends NumL {
      override def methodR(num: NumR): Result = {
        if (num.isInstanceOf[风]) {
          val newZero = NumLP(null, Item("Item01"))
          zero.tail = newZero
          zero = newZero
        }
        if (zero.isInstanceOf[NumLO]) {
          ResultO
        } else {
          val newZero = NumLO(null)
          zero.tail = newZero
          zero = newZero
          ResultP(tail.methodR(numR), Item("Item01"))
        }
      }
    }

    def log: Int = numL.methodR(numR).length

  }

  import spire.implicits._
  import spire.math._
  val list1 = for {
    i1 <- LazyList.from(2 to 40)
    i2 <- LazyList.from(1 to 4000)
  } yield {
    val num1 = LongContext(i1, i2).log
    val num2 = log(i2, i1)
    (i1, i2, num1, num2)
  }

  val result = list1.filter(s => !(s._3 == s._4.toInt))

  result.to(List).map(s => println(s"log(${s._1}, ${s._2}), number left in spire: ${s._4}, number right: ${s._3}"))

}
