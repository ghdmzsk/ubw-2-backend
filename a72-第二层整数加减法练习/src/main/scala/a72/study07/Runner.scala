package a72.study07

object Runner {

  def count1(number1: Number1): Int = number1 match {
    case Number1S(tail, head) => count1(tail) + count2(head) + 1
    case Number1T             => 0
  }
  def count2(number2: Number2): Int = number2 match {
    case Number2S(tail, head) => count2(tail) + count1(head) - 1
    case Number2T             => 0
  }

  def gen1(n: Int): Number1 = if (n > 0) Number1S(gen1(n - 1), Number2T) else if (n < 0) Number1S(Number1T, gen2(-n + 1)) else Number1T
  def gen2(n: Int): Number2 = if (n > 0) Number2S(Number2S(Number2T, Number1T), Number1S(Number1T, gen2(n - 1)))
  else if (n < 0) Number2S(Number2T, gen1(-n + 1))
  else Number2T

  def main1(arr: Array[String]): Unit = {
    {
      for {
        i1 <- -80 to 80
        i2 <- -80 to 80
      } {
        val number1 = gen1(i1)
        val number2 = gen2(i2)
        val result  = number1.method1(number2)
        val count   = count2(result)
        assert(i1 - i2 == count)
        println(s"$i1 - $i2 = $count")
      }
    }
  }

}
