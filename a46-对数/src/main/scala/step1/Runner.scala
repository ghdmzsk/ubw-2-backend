package step1

object Runner extends App {

  // 定义阶段
  var zero: NumL     = null
  var numRP: NumR    = null
  var numRZero: NumR = null

  case class 左火(override var tail: NumL, head: Item) extends NumL {
    override def methodR(num: NumR): Result = {
      if (num eq numRZero) {
        val newZero = 左水(null, Item("Item02"))
        zero.tail = newZero
        zero = newZero
      }
      if (zero eq this) {
        ResultO
      } else {
        val newZero = 左火(null, head)
        zero.tail = newZero
        zero = newZero
        ResultP(tail.methodR(numRP), head)
      }
    }
  }
  case class 左水(override var tail: NumL, head: Item) extends NumL {
    override def methodR(num: NumR): Result = {
      if (num eq numRZero) {
        val newZero = 左水(null, Item("Item02"))
        zero.tail = newZero
        zero = newZero
      }
      num.methodL(tail, head)
    }
  }

  // 测试运行阶段
  def numLFromInt(n: Int): NumL = n match {
    case n1 if n1 > 0 => 左水(numLFromInt(n1 - 1), Item(s"Item${n1}"))
    case 0 =>
      zero = 左火(null, Item("Item01"))
      zero
  }
  def numRFromInt(n: Int): Unit = {
    def num1(n1: Int, tail: NumR): NumR = {
      n1 match {
        case n2 if n2 > 0 => 水(num1(n2 - 1, tail))
        case 0            => tail
      }
    }
    lazy val num2: NumR = num1(n, num3)
    lazy val num3: NumR = 风(() => num2)
    numRP = num2
    numRZero = num3
  }

  def printlnLog(num1: Int, num2: Int): Unit = {
    val number3 = numLFromInt(num2)
    numRFromInt(num1)
    val result3 = number3.methodR(numRP)
    val result4 = (math.log(num2) / math.log(num1))
    println(s"log($num1, $num2), result left: ${result3.length}, result right: $result4")
  }

  for (i <- 1 to math.pow(2, 8).toInt) {
    printlnLog(3, i)
  }

}
