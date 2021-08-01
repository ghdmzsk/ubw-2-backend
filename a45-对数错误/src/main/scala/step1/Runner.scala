package step1

object Runner {

  var zero: NumL = null
  var winR: NumR = null

  case class 左火(override var tail: NumL, head: Item) extends 火 {
    override def methodR(num: NumR, item: Item): Result = {
      if (zero eq this) {
        RO
      } else {
        val newZero = 左火(null, Item("Item01"))
        zero.tail = newZero
        zero = newZero
        super.methodR(winR, item)
      }
    }
  }

  case class 右风(override val tail: () => NumR) extends 风 {
    override def methodL(num: NumL): Result = {
      val newZero = 左水(null)
      zero.tail = newZero
      zero = newZero
      super.methodL(num)
    }
  }

  def numLFromInt(n: Int): NumL = n match {
    case n1 if n1 > 0 => 左水(numLFromInt(n1 - 1))
    case 0 =>
      zero = 左火(null, Item("Item00"))
      zero
  }

  def numRFromInt(n: Int): Unit = {
    def num1(n1: Int, zero: => NumR): NumR = n1 match {
      case n2 if n2 > 0 => 右水(num1(n2 - 1, zero), Item(s"Item$n2"))
      case 0            => zero
    }
    lazy val num2: NumR = num1(n, num3)
    lazy val num3: NumR = 右风(() => num2)
    winR = num2
  }

  def printlnLog(number1: Int, number2: Int): NumberResult = {
    val result1 = (math.log(number2) / math.log(number1)).toInt

    var number3 = number2
    var i       = result1
    while (i > 0) {
      number3 += math.pow(number1, i).toInt
      i -= 1
    }
    val number4 = numLFromInt(number3)
    numRFromInt(number1)
    val result2 = number4.methodR(winR, Item("Item01")).length

    NumberResult(di = number1, leftTrue = number3, rightTrue = number2, leftResult = result2, rightResult = result1)
  }

  for (i <- 1 to 2000) {
    println(printlnLog(4, i))
  }

}

case class NumberResult(di: Int, leftTrue: Int, rightTrue: Int, leftResult: Int, rightResult: Int) {
  override def toString: String = s"num left: log($di, $leftTrue) = $leftResult, num right: log($di, $rightTrue) = $rightResult"
}
