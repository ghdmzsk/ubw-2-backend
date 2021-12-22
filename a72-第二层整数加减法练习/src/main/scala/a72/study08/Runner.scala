package a72.study08

object Runner {

  def count1(number1: Number1): Int = number1 match {
    case Number1S(tail, head) => count1(tail) + count2(head) + 1
    case Number1T             => 0
  }

  def count2(number2: Number2): Int = number2 match {
    case Number2S(tail, head) => count2(tail) + count1(head) - 1
    case Number2T             => 0
  }

  def gen1(n: Int): Number1 = if (n > 0) Number1S(gen1(n - 1), Number2T)
  else if (n < 0) Number1S(gen1(n + 1), Number2S(Number2S(Number2T, Number1T), Number1T))
  else Number1T
  def gen2(n: Int): Number2 = if (n < 0) Number2S(gen2(n + 1), Number1T)
  else if (n > 0) Number2S(gen2(n - 1), Number1S(Number1S(Number1T, Number2T), Number2T))
  else Number2T

  def main(arr: Array[String]): Unit = {
    {
      for {
        i1 <- -30 to 30
        i2 <- -30 to 30
      } {
        val number1 = gen1(i1)
        val number2 = gen2(i2)
        val number3 = number1.method1(number2)
        assert(count1(number1) + count2(number2) == count2(number3))
        println(s"${count1(number1)} + ${count2(number2)} == ${count2(number3)}")
      }
    }
  }

}
