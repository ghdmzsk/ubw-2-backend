package a72.study02

object Runner {

  def count1(number1: Number1): Int = number1 match {
    case Number1S(tail, head) => count1(tail) + count2(head) + 1
    case Number1T             => 0
  }

  def count2(number2: Number2): Int = number2 match {
    case Number2S(tail, head) => count2(tail) + count1(head) - 1
    case Number2T             => 0
  }

  def randomDeep   = math.abs(util.Random.nextInt() % 10)
  def randomLength = math.abs(util.Random.nextInt() % 5)

  def genNumber1(deep: Int): Number1 = if (randomDeep > deep) {
    def genLengthNumber1(length: Int): Number1 = if (length > 0) Number1S(genLengthNumber1(length - 1), genNumber2(deep + 1)) else Number1T
    genLengthNumber1(randomLength)
  } else Number1T

  def genNumber2(deep: Int): Number2 = if (randomDeep > deep) {
    def genLengthNumber2(length: Int): Number2 = if (length > 0) Number2S(genLengthNumber2(length - 1), genNumber1(deep + 1)) else Number2T
    genLengthNumber2(randomLength)
  } else
    Number2T

  def main1(arr: Array[String]): Unit = {
    for {
      i1 <- -10 to 0
      i2 <- -10 to 0
    } {
      val number1 = genNumber1(i1)
      val number2 = genNumber2(i2)
      val number3 = number1.method1(number2)
      val num1    = count1(number1)
      val num2    = count2(number2)
      val num3    = count2(number3)
      println(s"$num1 + $num2 = $num3, ${num3 == num1 + num2}")
    }
  }

}
