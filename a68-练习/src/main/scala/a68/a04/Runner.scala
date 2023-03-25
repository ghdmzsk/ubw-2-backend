package a68.a04

object Runner {

  def number1Gen(n: Int): Number1                   = if (n > 0) Number1S(number1Gen(n - 1)) else Number1T
  def number2Gen(n: Int, zero: => Number2): Number2 = if (n > 0) Number2S(number2Gen(n - 1, zero)) else zero
  def count3(num3: Number3): Int = num3 match {
    case Number3S(tail) => count3(tail) + 1
    case Number3T       => 0
  }

  def main(arr: Array[String]): Unit = {
    {
      for {
        i1 <- 0 to 20
        i2 <- 1 to 20
      } {
        val num1                   = number1Gen(i1)
        lazy val num2: Number2     = number2Gen(i2, num2Zero)
        lazy val num2Zero: Number2 = Number2T(() => num2)
        val count1                 = count3(num2.method2(num1))
        val count2                 = count3(num1.method1(num2Zero))
        assert(count1 == i1 / i2)
        assert(count2 == (if (i1 % i2 == 0) i1 / i2 else i1 / i2 + 1))
      }
    }
  }

}
