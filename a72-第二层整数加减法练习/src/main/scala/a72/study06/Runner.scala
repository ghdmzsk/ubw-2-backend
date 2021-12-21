package a72.study06

object Runner {

  def count1(number1: Number1): Int = number1 match {
    case Number1S(tail, head) => count1(tail) + count2(head) + 1
    case Number1T             => 0
  }

  def count2(number2: Number2): Int = number2 match {
    case Number2S(tail, head) => count1(head) + count2(tail) - 1
    case Number2T             => 0
  }

  def randonLength = math.abs(util.Random.nextInt() % 5)

  def genNumber1(n: Int): Number1 = {
    if (n == 0)
      Number1T
    else {
      val rLen                         = randonLength
      def gen(a: Int, b: Int): Number1 = if (a > 0) Number1S(genNumber1(a - 1), genNumber2(b)) else Number1T
      gen(n - rLen, rLen)
    }
  }

  def genNumber2(n: Int): Number2 = {
    if (n == 0)
      Number2T
    else {
      val rLen                         = randonLength
      def gen(a: Int, b: Int): Number2 = if (a > 0) Number2S(genNumber2(a - 1), genNumber1(b)) else Number2T
      gen(n - rLen, rLen)
    }
  }

  def main1(arr: Array[String]): Unit = {
    {
      val number1: Number1 = genNumber1(8888)
      val number2: Number2 = genNumber2(3221)
      val number3: Number2 = number1.method1(number2)
      println(s"${count1(number1)} + ${count2(number2)} = ${count2(number3)}")
      assert(count1(number1) + count2(number2) == count2(number3))
    }
  }

}
