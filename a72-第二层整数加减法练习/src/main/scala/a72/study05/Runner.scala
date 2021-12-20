package a72.study05

object Runner {

  def count1(number1: Number1): Int = number1 match {
    case Number1S(tail, head) => count1(tail) + count2(head) + 1
    case Number1T             => 0
  }

  def count2(number2: Number2): Int = number2 match {
    case Number2S(tail, head) => count1(head) + count2(tail) - 1
    case Number2T             => 0
  }

  def randomLength = math.abs(util.Random.nextInt() % 5)

  def genNumber1(n: Int, deep: Int): Number1 = {
    if (deep > 0) {
      val randomLen = randomLength
      val otherN    = n - randomLen
      Number1S(
        if (randomLen == 1) Number1T else genNumber1(randomLen - 1, deep - 1),
        if (otherN == 0) Number2T else genNumber2(otherN, deep - 1)
      )
    } else {
      def gen(n: Int): Number1 =
        if (n > 0) Number1S(gen(n - 1), Number2T) else if (n == 0) Number1T else Number1S(Number1T, genNumber2(n - 1, 0))
      gen(n)
    }
  }
  def genNumber2(n: Int, deep: Int): Number2 = {
    if (deep > 0) {
      val randomLen = randomLength
      val otherN    = n - randomLen
      Number2S(
        if (randomLen == -1) Number2T else genNumber2(randomLen + 1, deep - 1),
        if (otherN == 0) Number1T else genNumber1(otherN, deep - 1)
      )
    } else {
      def gen(n: Int): Number2 =
        if (n < 0) Number2S(gen(n + 1), Number1T) else if (n == 0) Number2T else Number2S(Number2T, genNumber1(n + 1, 0))
      gen(n)
    }

  }

  def main1(arr: Array[String]): Unit = {
    for {
      i1 <- -20 to 20
      i2 <- -50 to 50
      i3 <- 5 to 10
    } {
      val number1 = genNumber1(i1, i3)
      val number2 = genNumber2(i2, i3)
      val result  = number1.method1(number2)
      assert(i1 == count1(number1))
      assert(i2 == count2(number2))
      assert(i1 + i2 == count2(result))
    }
  }

}
