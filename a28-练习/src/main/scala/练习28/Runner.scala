package 练习28

object Runner extends App {

  class LogCount(num1: Int, num2: Int) {
    var zero: NumL = null
    val (numRP, numRO): (NumR, NumR) = {
      def n(num: Int, tail: => NumR): NumR = {
        num match {
          case n1 if n1 > 0 => 水(n(num - 1, tail))
          case 0            => tail
        }
      }
      lazy val numR1: NumR = n(num1, numR2)
      lazy val numR2       = 风(numR1)
      (numR1, numR2)
    }

    case class 左火(override var tail: NumL, head: Item) extends NumL {
      override def methodR(num: NumR): Result = {
        if (num eq numRO) {
          val newZero = 左水(null, Item("Item01"))
          zero.tail = newZero
          zero = newZero
        }
        if (this eq zero) {
          ResultO
        } else {
          val newZero = new 左火(null, Item("Item02"))
          zero.tail = newZero
          zero = newZero
          ResultR(tail.methodR(numRP), head)
        }
      }
    }

    case class 左水(override var tail: NumL, head: Item) extends NumL {
      override def methodR(num: NumR): Result = {
        if (num eq numRO) {
          val newZero = 左水(null, Item("Item01"))
          zero.tail = newZero
          zero = newZero
        }
        num.methodL(tail)
      }
    }

    def numLCount(n: Int): NumL = {
      n match {
        case n1 if n1 > 0 => 左水(numLCount(n1 - 1), Item(s"Item$n1"))
        case 0 =>
          zero = 左火(null, Item("Item0"))
          zero
      }
    }

    val numL = numLCount(num2)

    def log: Int = numL.methodR(numRP).length

  }

  assert(new LogCount(3, 242).log == 4)
  assert(new LogCount(3, 243).log == 5)
  assert(new LogCount(3, 244).log == 5)

}
