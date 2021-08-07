package step1

object Runner extends App {

  case class LogContext(number1: Int, number2: Int) {
    // 定义阶段
    var zero: NumL = null
    val number3    = numLFromInt(number2)
    val numR       = numRFromInt(number1)

    case class 左零(override var tail: NumL, head: Item) extends NumL {
      override def methodR(num: NumR): Result = {
        if (num.isInstanceOf[风]) {
          val newZero = 左正(null, Item("Item02"))
          zero.tail = newZero
          zero = newZero
        }
        if (zero eq this) {
          ResultO
        } else {
          val newZero = 左零(null, head)
          zero.tail = newZero
          zero = newZero
          ResultP(tail.methodR(numR), head)
        }
      }
    }
    case class 左正(override var tail: NumL, head: Item) extends NumL {
      override def methodR(num: NumR): Result = {
        if (num.isInstanceOf[风]) {
          val newZero = 左正(null, Item("Item02"))
          zero.tail = newZero
          zero = newZero
        }
        num.methodL(tail, head)
      }
    }

    // 测试运行阶段
    def numLFromInt(n: Int): NumL = n match {
      case n1 if n1 > 0 => 左正(numLFromInt(n1 - 1), Item(s"Item${n1}"))
      case 0 =>
        zero = 左零(null, Item("Item01"))
        zero
    }
    def numRFromInt(n: Int): NumR = {
      def num1(n1: Int, tail: => NumR): NumR = {
        n1 match {
          case n2 if n2 > 0 => 水(num1(n2 - 1, tail))
          case 0            => 风(tail)
        }
      }
      lazy val num2: NumR = num1(n, num2)
      num2
    }

    def log: Int = number3.methodR(numR).length
  }

  def log(num1: Int, num2: Int): Int = {
    var result = 0
    while (math.pow(num1, result).toInt < num2) result += 1
    if (math.pow(num1, result).toInt > num2) result - 1 else result
  }

  for {
    i1 <- 2 to 40
    i2 <- 1 to 4000
  } yield {
    val num1 = LogContext(i1, i2).log
    val num2 = log(i1, i2)
    assert(num1 == num2)
  }

}
