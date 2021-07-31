package step1

object Runner extends App {

  def numLFromInt(n: Int): NumL = n match {
    case n1 if n1 > 0 => 左水(numLFromInt(n1 - 1), Item(s"Item${n1}"))
    case 0 =>
      zero = 左火(null, Item("Item01"))
      zero
  }
  def numRFromInt(n: Int): NumR = {
    def num1(n1: Int, tail: NumR): NumR = {
      n1 match {
        case n2 if n2 > 0 => 右水(num1(n2 - 1, tail))
        case 0            => tail
      }
    }
    lazy val num2: NumR = num1(n, num3)
    lazy val num3: NumR = 右风(() => num2)
    num2
  }

  var zero: NumL = null

  object 右风 {
    def apply(tail: () => NumR): NumR = new 风(tail) {
      override def methodL(num: NumL, item: Item): Result = {
        val newZero = 左水(null, Item("Item02"))
        zero.tail = newZero
        zero = newZero
        super.methodL(num, item)
      }
    }
  }

  object 左火 {
    def apply(tail1: NumL, head1: Item): NumL = new 火 {
      override var tail = tail1
      override val head = head1
      override def methodR(num: NumR): Result = {
        if (zero eq this) {
          ResultO
        } else {
          val newZero = 左火(null, head)
          zero.tail = newZero
          zero = newZero
          super.methodR(num)
        }
      }
    }
  }

  /*val number1 = numLFromInt(99)
  numRFromInt(3)
  val result1 = number1.methodR(numR)
  val result2 = (math.log(99) / math.log(3)).toInt
  assert(result1.length == result2)*/

  def printlnLog(num1: Int, num2: Int): Unit = {
    val number3 = numLFromInt(num1)
    val number4 = numRFromInt(num2)
    val result3 = number4.methodL(number3, Item("Item01"))
    val result4 = (math.log(num1) / math.log(num2)).toInt
    println(s"result left: ${result3.length}, result right: $result4")
  }

  for (i <- 1 to 12) {
    printlnLog(math.pow(2, i).toInt, 2)
  }

}
